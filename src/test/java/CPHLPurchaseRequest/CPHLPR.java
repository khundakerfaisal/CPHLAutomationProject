package CPHLPurchaseRequest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class CPHLPR {

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
		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		Thread.sleep(2000);

		///////////////////// Budget Line
		///////////////////// Selection///////////////////////////////////////
		driver.findElement(By.xpath("//div[@name='budget_line_id']")).click();
		Thread.sleep(2000);

		List<WebElement> dropdownOptions = driver
				.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
		int count = dropdownOptions.size();
		System.out.println(count);
		dropdownOptions.get(count - 3).click();

		///////////////////// Budget Line Selection
		///////////////////// End///////////////////////////////////////

		///////////////////// Selection Requisition
		///////////////////// Date///////////////////////////////////////
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='requisition_date']"));
		datePicker.click();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		WebElement dateTimeInput = driver.findElement(By.xpath("//div[@name='requisition_date']/input")); // locator
		dateTimeInput.clear();
		dateTimeInput.sendKeys(formattedDateTime);
		Thread.sleep(2000);

		///////////////////// End Selection Requisition
		///////////////////// Date///////////////////////////////////////

		///////////////////// Selection Priority///////////////////////////////////////
		WebElement prioritySelect = driver.findElement(By.xpath("//select[@name='priority']"));
		prioritySelect.click();
		Select select = new Select(prioritySelect);
		select.selectByVisibleText("High");
		Thread.sleep(2000);
		///////////////////// End priority
		///////////////////// selection///////////////////////////////////////

		///////////////////// Selection Requirement
		///////////////////// For///////////////////////////////////////
		WebElement requirement_forSelect = driver.findElement(By.xpath("//select[@name='requirement_for']"));
		prioritySelect.click();
		Select requirement_forselectoptions = new Select(requirement_forSelect);
		requirement_forselectoptions.selectByVisibleText("Operation");
		Thread.sleep(2000);
		///////////////////// End Requirement for///////////////////////////////////////

		///////////////////// Selection Requisition
		///////////////////// Type///////////////////////////////////////
		WebElement requisition_typeSelect = driver.findElement(By.xpath("//select[@name='requisition_type']"));
		prioritySelect.click();
		Select requisition_typeselectoptions = new Select(requisition_typeSelect);
		requisition_typeselectoptions.selectByVisibleText("Local");
		Thread.sleep(2000);
		///////////////////// End requisition
		///////////////////// Type///////////////////////////////////////

		///////////////////// Selection Purchase
		///////////////////// Type///////////////////////////////////////

		WebElement purchase_typeSelect = driver.findElement(By.xpath("//select[@name='purchase_type']"));
		prioritySelect.click();
		Select purchase_typeselectoptions = new Select(purchase_typeSelect);
		purchase_typeselectoptions.selectByVisibleText("New Purchase");
		Thread.sleep(2000);
		///////////////////// End purchase type//////////////////////////////////////

		///////////////////// Selection Approver///////////////////////////////////////
		// Selection Approved by option
		WebElement approvebyselect = driver.findElement(By.xpath("//div[@name='assigned_to']"));
		approvebyselect.click();
		Thread.sleep(2000);
		// Locate the specific option you want to click by its text
		String optionText = "Administrator"; // Replace with the option you want to select
		WebElement optionToSelect = approvebyselect.findElement(By.xpath("//a[text()='" + optionText + "']"));
		// Click on the option
		optionToSelect.click();
		Thread.sleep(2000);

		///////////////////// Approver Selection
		///////////////////// End///////////////////////////////////////

		///////////////////// Product Line input table start
		///////////////////// ///////////////////////////////////////
		WebElement lineSelection = driver.findElement(By.xpath("//a[text()='Add a line']"));
		lineSelection.click();
		Thread.sleep(2000);

		// Start Using Singel item selection with out loop //
		WebElement dropdownElementProduct1 = driver.findElement(By.xpath("//td[@name='product_id']"));
		dropdownElementProduct1.click();
		Thread.sleep(2000);
		WebElement itemToSelect = driver.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
		itemToSelect.click();
		Thread.sleep(2000);
		WebElement prQty = driver.findElement(By.xpath("//input[@name='product_qty']"));
		prQty.clear();
		prQty.sendKeys("5.000");
		Thread.sleep(2000);
		WebElement okButton = driver.findElement(By.xpath("//button[text()='Ok']")); // Invisible Modal comming for this
																						// reason it is need to close
																						// [Windows Modal OK
		okButton.click(); // Click the "Ok" button
		Thread.sleep(2000);
		// End Using Singel item selection without loop //

		// Start Using Multiple item selection with loop
		WebElement lineSelection2 = driver.findElement(By.xpath("//a[text()='Add a line']"));
		lineSelection2.click();
		Thread.sleep(2000);
		// Start Array Using multiple item selection with loop
		String[] dropdownItems = { "04 Way Switch - (91E6100112)" };
		int[] quantities = { 4 }; 											// Corresponding quantities
		// Iterate through the dropdown items and quantities
		for (int i = 0; i < dropdownItems.length; i++) {
			WebElement dropdownElementProduct = driver.findElement(
					By.xpath("//*[@id='o_field_input_168']/div[2]/div/table/tbody/tr[2]/td[1]/div/div[1]/div/input"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement quantityInput = wait1
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='product_qty']")));
																			// Click the dropdown element
			dropdownElementProduct.click();
																			// Wait for the specific item in the dropdown to be clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement dropdownItem = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='04 Way Switch - (91E6100112)']")));
			dropdownItem.click();
			quantityInput.clear();
			quantityInput.sendKeys(String.valueOf(quantities[i]));

			Thread.sleep(2000);
			try {
				Thread.sleep(3000); // Wait for 1 second (1000 milliseconds)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// End Array Using multiple product item selection with loop

		///////////////////// Product Line input table End///////////////////
		
		
		///////////////////// ///	Approval work start ////////////////////////////////////

		// Pr Save button Pressed
		WebElement prSubmit = driver.findElement(By.xpath("//button[@title='Save record']"));
		prSubmit.click();
		Thread.sleep(3000);

		// Pr Hod Approval button Pressed
		WebElement PrHodApproval = driver.findElement(By.xpath("//button[@name='button_hod_approve']"));
		PrHodApproval.click();
		Thread.sleep(1000);

		// Pr pm Approval button Pressed
		WebElement PrPmApproval = driver.findElement(By.xpath("//button[@name='button_pm_approve']"));
		PrPmApproval.click();
		Thread.sleep(1000);

		// Pr pm Ops Approval button Pressed
		WebElement PrPmOpsApproval = driver.findElement(By.xpath("//button[@name='button_pm_ops_approve']"));
		PrPmOpsApproval.click();
		Thread.sleep(1000);

		// Pr SCM Approval button Pressed
		WebElement PrScmApproval = driver.findElement(By.xpath("//button[@name='button_scm_approve']"));
		PrScmApproval.click();
		Thread.sleep(1000);

		// Pr COO Approval button Pressed
		WebElement PrCooApproval = driver.findElement(By.xpath("//button[@name='button_coo_approved']"));
		PrCooApproval.click();
		Thread.sleep(1000);

		// Pr Final/Done Approval button Pressed
		WebElement PrFinalApproval = driver.findElement(By.xpath("//button[@name='button_done']"));
		PrFinalApproval.click();
		Thread.sleep(3000);

		System.out.println("Purchase requsition Successfully Completed!");
		Thread.sleep(3000);

		driver.quit();
		///////////////////// ///	Approval work end ////////////////////////////////////

	}

}
