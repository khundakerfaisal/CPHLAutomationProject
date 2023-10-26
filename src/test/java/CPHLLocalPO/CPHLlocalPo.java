package CPHLLocalPO;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLlocalPo {

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

		driver.findElement(By.xpath("//a[@data-menu-xmlid='purchase.menu_purchase_form_action']")).click();
		Thread.sleep(2000);

		WebElement LocalAgreementPoCreated = driver
				.findElement(By.xpath("//button[@data-original-title='Create record']"));
		LocalAgreementPoCreated.click();
		Thread.sleep(3000);

		WebElement purchaseBase = driver.findElement(By.xpath("//select[@name='purchase_base']"));
		purchaseBase.click();
		Thread.sleep(2000);
		Select purchaseBaseDropdownselection = new Select(purchaseBase);
		purchaseBaseDropdownselection.selectByVisibleText("Comparative Statement");

		Thread.sleep(2000);

		WebElement rfqDropdownSelect = driver.findElement(By.xpath("//div[@name='rfq_ids']"));
		rfqDropdownSelect.click();
		Thread.sleep(2000);

		WebElement rfqDropdownValueSelect = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		rfqDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement budgetDropdownSelect = driver.findElement(By.xpath("//div[@name='budget_id']"));
		budgetDropdownSelect.click();
		Thread.sleep(3000);

		WebDriverWait waitPO = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
		WebElement agreementPObudgetselect = waitPO
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-3']/li[3]/a")));
		agreementPObudgetselect.click();
		Thread.sleep(2000);

		WebElement LocalPOSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
		// submission
		LocalPOSubmit.click();
		Thread.sleep(2000);

		//////////////////// Local PO approval
		//////////////////// start//////////////////////////////////////////////////
		WebElement localPoSCMapproval = driver.findElement(By.xpath("//button[@name='send_for_scm_approval']"));
		localPoSCMapproval.click();

		Thread.sleep(1000);

		WebElement localPoScmCooapproval = driver.findElement(By.xpath("//button[@name='send_for_scm_coo_approval']"));
		localPoScmCooapproval.click();

		Thread.sleep(1000);

		WebElement localPoConfirmButton = driver.findElement(By.xpath("//button[@name='button_confirm']"));
		localPoConfirmButton.click();

		Thread.sleep(1000);

		System.out.println("Local Purchase successfully created");
		Thread.sleep(1000);
		driver.quit();

	}

}
