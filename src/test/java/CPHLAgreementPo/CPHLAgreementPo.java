package CPHLAgreementPo;

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

public class CPHLAgreementPo {

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
		purchaseBaseDropdownselection.selectByVisibleText("Agreement & Notesheet");

		Thread.sleep(2000);
		WebElement prDropdownSelect = driver.findElement(By.xpath("//div[@name='purchase_request_id']"));
		prDropdownSelect.click();
		Thread.sleep(2000);

		WebElement prDropdownValueSelect = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		prDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement vendorDropdownSelect = driver
				.findElement(By.xpath("//div[contains(@placeholder, 'Name, TIN, Email, or Reference')]"));
		vendorDropdownSelect.click();
		Thread.sleep(2000);

		WebElement prVendorSelect = driver.findElement(By.xpath("//li/a[text()='Mayer Dowa Enterprice']"));
		prVendorSelect.click();
		Thread.sleep(2000);

		WebElement agreementDropdownSelect = driver.findElement(By.xpath("//div[@name='agreement_id']"));
		agreementDropdownSelect.click();
		Thread.sleep(2000);

		WebElement agreementValueSelect = driver.findElement(By.xpath("//li/a[text()='MD-101']"));
		agreementValueSelect.click();
		Thread.sleep(2000);

		WebElement budgetDropdownSelect = driver.findElement(By.xpath("//div[@name='budget_id']"));
		budgetDropdownSelect.click();
		Thread.sleep(3000);

//		List<WebElement> dropdownOptions = driver
//				.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
//		int count = dropdownOptions.size();
//		System.out.println(count);
//		dropdownOptions.get(count - 3).click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
		WebElement agreementPObudgetselect = wait3
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-3']/li[3]/a")));
		agreementPObudgetselect.click();
		Thread.sleep(2000);

//		WebElement budgetValueSelect = driver.findElement(By.xpath(
//				"//a[text()='A. Fixed Plant Overhead - 3.Overtime & Holiday Bill - 2022-2023 (CPBL) (916095.8200000001) (1079830.0)']"));
//		budgetValueSelect.click();
//		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create a WebDriverWait instance with
		// a timeout (in seconds) first cell
		// selection

		WebElement firstCellRfq = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tr.o_data_row:first-child"))); // Wait
		// for
		// the
		// First
		// table
		// cell
		// selection

		firstCellRfq.click();
		WebElement unitPrice1Selection = firstCellRfq.findElement(By.xpath("//td[@name='price_unit']/input")); // First
		// row
		// price
		// input
		// button
		// click
		unitPrice1Selection.clear();
		unitPrice1Selection.sendKeys("600"); // input/Set First row unit price
		unitPrice1Selection.sendKeys(Keys.ENTER); // Enter Second selected cell
		Thread.sleep(2000);

		System.out.println("Price assign suceesfully in first table data!");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Create a WebDriverWait instance with
		// a timeout (in seconds) Second
		// cell selection
		WebElement secondCellRfq = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//td[@class='o_data_cell o_field_cell o_list_number o_required_modifier']/input[@name='price_unit']"))); // Second
		// row
		// price
		// input
		// button
		// click
		secondCellRfq.click();
		secondCellRfq.clear();
		secondCellRfq.sendKeys("700"); // input/Set Second row unit price

		System.out.println("Price assign suceesfully in second table data!");

		// Local Po submit button work start ..
		WebElement LocalPOAgrementSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
																											// submission
		LocalPOAgrementSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
//		System.out.println("Local PO Agrement Created successfully!");

		WebElement scmApproval = driver.findElement(By.xpath("//button[@name='send_for_scm_approval']"));
		scmApproval.click();
		Thread.sleep(2000);
		WebElement scmCooApproval = driver.findElement(By.xpath("//button[@name='send_for_scm_coo_approval']"));
		scmCooApproval.click();
		Thread.sleep(2000);
		WebElement buttonConfirm = driver.findElement(By.xpath("//button[@name='button_confirm']"));
		buttonConfirm.click();
		Thread.sleep(2000);
//		WebElement buttonApproveAgreement = driver.findElement(By.xpath("//button[@name='button_approve']"));
//		buttonApproveAgreement.click();
//		Thread.sleep(2000);

		System.out.println("Purchase Agreement successfully created");
		Thread.sleep(2000);

		driver.quit();

	}

}
