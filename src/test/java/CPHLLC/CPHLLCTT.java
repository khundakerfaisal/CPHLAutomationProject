package CPHLLC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLLCTT {

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

		driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_foreign_purchase.menu_cphl_lc_details']"))
				.click();
		Thread.sleep(2000);

		WebElement LcCreated = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		LcCreated.click();
		Thread.sleep(3000);

		WebElement VendorDropdownSelect = driver.findElement(By.xpath("//div[@name='partner_id']"));
		VendorDropdownSelect.click();
		Thread.sleep(2000);

		WebElement VendorDropdownValueSelect = driver.findElement(By.xpath("//a[text()='Chowdhury Motors']"));
		VendorDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement LcDropdownSelect = driver.findElement(By.xpath("//div[@name='proforma_invoice_ids']"));
		LcDropdownSelect.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement LcDropdownValueSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item'][1]/a")));
//		WebElement PoDropdownValueSelect = driver.findElement(By.xpath("//ul[@id='ui-id-5']/li[1]/a"));
		LcDropdownValueSelect.click();
		Thread.sleep(2000);

		
		WebElement LcAutoNumberColumn = driver.findElement(
				By.xpath("//input[@class='o_field_char o_field_widget o_quick_editable o_input o_required_modifier']"));
		LcAutoNumberColumn.sendKeys("LC/TT-2023-00001");
		Thread.sleep(2000);

//		WebDriverWait waitForeignPO = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
//		WebElement agreementPObudgetselect = waitForeignPO
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-5']/li[3]/a")));
//		agreementPObudgetselect.click();
//		Thread.sleep(2000);
		
//		AutoGenerateNumber function= new AutoGenerateNumber(driver);
//		function.generateUniqueProformaNumber();
//		Thread.sleep(2000);



		WebElement LCttSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
		// submission
		LCttSubmit.click();
		Thread.sleep(2000);


	}

}