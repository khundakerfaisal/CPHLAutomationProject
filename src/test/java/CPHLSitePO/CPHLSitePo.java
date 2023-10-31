package CPHLSitePO;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLSitePo {

	public static void main(String[] args)throws InterruptedException {
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

		

		// order menu button Pressed
		WebElement orderMenuSelection = driver.findElement(By.xpath("//button[@title='Orders']"));
		orderMenuSelection.click();
		Thread.sleep(2000);

		// Site purchase order menu click
		WebElement sitePoSelection = driver
				.findElement(By.xpath("//a[@data-menu-xmlid='cphl_local_purchase.menu_action_site_purchase_views']"));
		sitePoSelection.click();
		Thread.sleep(2000);

		// Site purchase order create button click

//		WebElement sitePoCreateButton = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
//		sitePoCreateButton.click();
//		Thread.sleep(3000);

		// Site purchase order vendor selection

		WebElement inputElement = driver
				.findElement(By.xpath("//div[contains(@placeholder, 'Name, TIN, Email, or Reference')]"));
		inputElement.click();
		Thread.sleep(2000);

		// Site purchase order dropdown vendor selection

		WebElement sitePoVendorSelection = driver
				.findElement(By.xpath("//li/a[text()='Billal Electric & electronics']"));
		sitePoVendorSelection.click();
		Thread.sleep(2000);

		// Site po--PR dropdown value selection work start

		WebElement prDropdownclick = driver.findElement(By.xpath("//div[@name='purchase_request_id']"));
		prDropdownclick.click();
		Thread.sleep(2000);

		WebElement firstItem = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		// Click on the first item
		firstItem.click();
		System.out.println("Dropdown PR selection perfectly");
		Thread.sleep(3000);
		
		WebElement sitePObudgetclick = driver.findElement(By.xpath("//div[@name='budget_id']"));
		sitePObudgetclick.click();
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
		WebElement sitePObudgetselect = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-2']/li[6]/a")));
		sitePObudgetselect.click();
		Thread.sleep(2000);

		// Table td data unit price input work start :: Site po unit price input
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
		// Table td data unit price input work Close..

		// RfQ submit button work start ..
		WebElement sitPOSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final submission
		sitPOSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("Site PO Created successfully!");

	}

}
