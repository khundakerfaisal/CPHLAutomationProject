package CPHLRFQ;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLRFQ {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		ChromeDriver driver = new ChromeDriver();
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

		// Order root menu selection

		driver.findElement(By.xpath("//button[@data-menu-xmlid='purchase.menu_procurement_management']")).click();
		Thread.sleep(2000);

		// RFQ Sub menu selection

		driver.findElement(By.xpath("//a[@data-menu-xmlid='purchase_requisition.menu_purchase_requisition_pro_mgt']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@name='purchase_request_id']")).click();
		Thread.sleep(2000);

		// PR First dropdown value selection work start

		WebElement firstItem = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		// Click on the first item
		firstItem.click();
		System.out.println("Dropdown PR selection perfectly");
		WebElement rfqVendorSelection = driver
				.findElement(By.xpath("//button[@name='action_create_multiple_quotation_form']"));
		rfqVendorSelection.click();
		Thread.sleep(3000);

		// PR First dropdown value selection work close

		// Vendor selection multiple using Array
		String[] vendorSelectionRfq = { "Mayer Dowa Enterprice", "Chowdhury Motors" };

		for (int i = 0; i < vendorSelectionRfq.length; i++) {
			WebElement vendorDropdown = driver.findElement(By.xpath("//input[@id='o_field_input_241']"));
//			WebElement vendorDropdown = driver.findElement(By.xpath("//div[@name='vendor_ids']"));

			vendorDropdown.click();
			Thread.sleep(200);

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement vendorSelect = wait1.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//a[text()='" + vendorSelectionRfq[i] + "']")));

			// Click the dropdown element
			vendorSelect.click();

			// Wait for the specific item in the dropdown to be clickable

			Thread.sleep(2000);
			try {
				Thread.sleep(3000); // Wait for 1 second (1000 milliseconds)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Table td data unit price input work start
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create a WebDriverWait instance with
																				// a timeout (in seconds) first cell
																				// selection

		WebElement firstCellRfq = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@data-id='purchase.order.line_9']"))); // Wait
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
		unitPrice1Selection.sendKeys("500"); // input/Set First row unit price
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
		secondCellRfq.sendKeys("800"); // input/Set Second row unit price

		System.out.println("Price assign suceesfully in second table data!");
		// Table td data unit price input work Close..

		// RfQ submit button work start ..
		WebElement rfqSubmit = driver.findElement(By.xpath("//button[@name='action_multiple_quotation_save']")); // RFQ
																													// final
																													// submission
		rfqSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("RFQ Submission successfully!");

		WebElement rfqFinalSubmit = driver.findElement(
				By.xpath("//button[@class='btn btn-primary o_form_button_save' and @title='Save record']")); // RFQ
																												// final
																												// submission
		rfqFinalSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("RFQ Final Submission successfully!");

		driver.quit();

	}

}
