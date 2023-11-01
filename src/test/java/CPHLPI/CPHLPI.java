package CPHLPI;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLPI {



	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		ChromeOptions Option = new ChromeOptions();
		Option.addArguments("--remote-allow-origins=*");
		driver.get("http://10.10.14.196:9091/web/login");
		driver.findElement(By.name("login")).sendKeys("Test_data_migration");
		driver.findElement(By.name("password")).sendKeys("@testdata1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@title='Home Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-menu-xmlid='purchase.menu_purchase_root']")).click();
		Thread.sleep(2000);

		// Order Root menu selection
		driver.findElement(By.xpath("//button[@data-menu-xmlid='purchase.menu_procurement_management']")).click();
		Thread.sleep(2000);
		// Order Root menu End

		// Agreement PO start

		driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_foreign_purchase.menu_cphl_proforma_invoice']"))
				.click();
		Thread.sleep(2000);

		WebElement PiCreated = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		PiCreated.click();
		Thread.sleep(3000);

//		WebElement purchaseBase = driver.findElement(By.xpath("//select[@name='purchase_base']"));
//		purchaseBase.click();
//		Thread.sleep(2000);
//		Select purchaseBaseDropdownselection = new Select(purchaseBase);
//		purchaseBaseDropdownselection.selectByVisibleText("Comparative Statement");
//
//		Thread.sleep(2000);
//
		WebElement VendorDropdownSelect = driver.findElement(By.xpath("//div[@name='partner_id']"));
		VendorDropdownSelect.click();
		Thread.sleep(2000);

		WebElement VendorDropdownValueSelect = driver.findElement(By.xpath("//a[text()='Chowdhury Motors']"));
		VendorDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement PoDropdownSelect = driver.findElement(By.xpath("//div[@name='purchase_order_ids']"));
		PoDropdownSelect.click();

//		
//		PoDropdownSelect.sendKeys(Keys.DOWN);
//		PoDropdownSelect.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement PoDropdownValueSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-5']/li[1]/a")));
//		WebElement PoDropdownValueSelect = driver.findElement(By.xpath("//ul[@id='ui-id-5']/li[1]/a"));
		PoDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement CurrencyDropdownSelect = driver.findElement(By.xpath("//div[@name='currency_id']"));
		CurrencyDropdownSelect.click();
		Thread.sleep(3000);

		WebElement CurrencyDropdownValueSelect = driver.findElement(By.xpath("//a[text()='USD']"));
		CurrencyDropdownValueSelect.click();
		Thread.sleep(2000);
//
//		WebDriverWait waitForeignPO = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
//		WebElement agreementPObudgetselect = waitForeignPO
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-5']/li[3]/a")));
//		agreementPObudgetselect.click();
//		Thread.sleep(2000);
		
		AutoGenerateNumber function= new AutoGenerateNumber(driver);
		function.generateUniqueProformaNumber();
		Thread.sleep(2000);



		WebElement ProformaSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
		// submission
		ProformaSubmit.click();
		Thread.sleep(2000);
//
//		//////////////////// Local PO approval
//		//////////////////// start//////////////////////////////////////////////////
//		WebElement ForeignPoSCMapproval = driver.findElement(By.xpath("//button[@name='send_for_scm_approval']"));
//		ForeignPoSCMapproval.click();
//
//		Thread.sleep(1000);
//
//		WebElement ForeignPoScmCooapproval = driver.findElement(By.xpath("//button[@name='send_for_scm_coo_approval']"));
//		ForeignPoScmCooapproval.click();
//
//		Thread.sleep(1000);
//
//		WebElement ForeignPoConfirmButton = driver.findElement(By.xpath("//button[@name='button_confirm']"));
//		ForeignPoConfirmButton.click();
//
//		Thread.sleep(1000);
//
//		System.out.println("Foreign Po successfully created");
//		Thread.sleep(1000);
//		driver.quit();

	}


}
