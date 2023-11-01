package CPHLMultipleTypePR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

//import CPHLCombinedPR.ForeignPo;
//import CPHLCombinedPR.LocalPOApprover;
//import CPHLCombinedPR.SitePoApprover;

public class CPHLPRTypeWisePR {

	public static void main(String[] args) throws InterruptedException {
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
		WebElement createRecored = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		createRecored.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@name='budget_line_id']")).click();
		Thread.sleep(2000);

		List<WebElement> dropdownOptions = driver
				.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
		int count = dropdownOptions.size();
		System.out.println(count);
		dropdownOptions.get(count - 3).click();

		// using Requisition date selection start

		WebElement datePicker = driver.findElement(By.xpath("//input[@name='requisition_date']"));
		datePicker.click();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		WebElement dateTimeInput = driver.findElement(By.xpath("//div[@name='requisition_date']/input")); // locator
		dateTimeInput.clear();
		dateTimeInput.sendKeys(formattedDateTime);
		Thread.sleep(2000);

		// End Requisition date selection

		WebElement prioritySelect = driver.findElement(By.xpath("//select[@name='priority']"));
		prioritySelect.click();
		Select select = new Select(prioritySelect);
		select.selectByVisibleText("High");
		Thread.sleep(2000);

		WebElement requirement_forSelect = driver.findElement(By.xpath("//select[@name='requirement_for']"));
		prioritySelect.click();
		Select requirement_forselectoptions = new Select(requirement_forSelect);
		requirement_forselectoptions.selectByVisibleText("Operation");
		Thread.sleep(2000);

		WebElement purchase_typeSelect = driver.findElement(By.xpath("//select[@name='purchase_type']"));
		prioritySelect.click();
		Select purchase_typeselectoptions = new Select(purchase_typeSelect);
		purchase_typeselectoptions.selectByVisibleText("New Purchase");
		Thread.sleep(2000);

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

//		String[] requisitionTypeSelection = { "Local" };
//		String[] requisitionTypeSelection = { "Foreign" };
		String[] requisitionTypeSelection = { "Site Purchase" };
//		String[] requisitionTypeSelection = { "Local","Foreign","Site Purchase" };

		for (int i = 0; i < requisitionTypeSelection.length; i++) {
			WebElement requisition_typeSelect = driver.findElement(By.xpath("//select[@name='requisition_type']"));
			requisition_typeSelect.click();
			Thread.sleep(200);

			Select requisition_typeselectoptions = new Select(requisition_typeSelect);
			requisition_typeselectoptions.selectByVisibleText(requisitionTypeSelection[i]);
			Thread.sleep(2000);

			if (requisitionTypeSelection[i].equals("Local")) {
				WebElement lineSelection = driver.findElement(By.xpath("//a[text()='Add a line']"));
				lineSelection.click();
				Thread.sleep(2000);

				// Start Using Singel item selection with out loop //

				WebElement dropdownElementProduct1 = driver.findElement(By.xpath("//td[@name='product_id']"));
				dropdownElementProduct1.click();
				Thread.sleep(2000);

				WebElement itemToSelect = driver
						.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
				itemToSelect.click();
				Thread.sleep(2000);

				WebElement prQty = driver.findElement(By.xpath("//input[@name='product_qty']"));
				prQty.clear();
				prQty.sendKeys("5.000");
				Thread.sleep(2000);

				// Invisible Modal comming for this reason it is need to close [Windows Modal OK
				// button pressed]

				WebElement okButton = driver.findElement(By.xpath("//button[text()='Ok']"));
				// Click the "Ok" button
				okButton.click();
				Thread.sleep(2000);

				LocalPR function = new LocalPR(driver); // Create an instance of the class
				function.LocalPRApprover();

				System.out.println("Purchase requsition Successfully Completed!");
				Thread.sleep(3000);

				driver.quit();

			} else if (requisitionTypeSelection[i].equals("Site Purchase")) {
				WebElement lineSelection = driver.findElement(By.xpath("//a[text()='Add a line']"));
				lineSelection.click();
				Thread.sleep(2000);

				// Start Using Singel item selection with out loop //

				WebElement dropdownElementProduct1 = driver.findElement(By.xpath("//td[@name='product_id']"));
				dropdownElementProduct1.click();
				Thread.sleep(2000);

				WebElement itemToSelect = driver
						.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
				itemToSelect.click();
				Thread.sleep(2000);

				WebElement prQty = driver.findElement(By.xpath("//input[@name='product_qty']"));
				prQty.clear();
				prQty.sendKeys("5.000");
				Thread.sleep(2000);

				// Invisible Modal comming for this reason it is need to close [Windows Modal OK
				// button pressed]

				WebElement okButton = driver.findElement(By.xpath("//button[text()='Ok']"));
				// Click the "Ok" button
				okButton.click();
				Thread.sleep(2000);

				SitePR function = new SitePR(driver); // Create an instance of the class
				function.SitePRApprover();

				System.out.println("Site Purchase requsition Successfully Completed!");
				Thread.sleep(3000);
				driver.quit();

			} else if (requisitionTypeSelection[i].equals("Foreign")) {
				WebElement lineSelection = driver.findElement(By.xpath("//a[text()='Add a line']"));
				lineSelection.click();
				Thread.sleep(2000);

				// Start Using Singel item selection with out loop //

				WebElement dropdownElementProduct1 = driver.findElement(By.xpath("//td[@name='product_id']"));
				dropdownElementProduct1.click();
				Thread.sleep(2000);

				WebElement itemToSelect = driver
						.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
				itemToSelect.click();
				Thread.sleep(2000);

				WebElement prQty = driver.findElement(By.xpath("//input[@name='product_qty']"));
				prQty.clear();
				prQty.sendKeys("5.000");
				Thread.sleep(2000);

				// Invisible Modal comming for this reason it is need to close [Windows Modal OK
				// button pressed]

				WebElement okButton = driver.findElement(By.xpath("//button[text()='Ok']"));
				// Click the "Ok" button
				okButton.click();
				Thread.sleep(2000);

				ForeignPR function = new ForeignPR(driver); // Create an instance of the class
				function.ForeignPRApprover();

				System.out.println("Foreign requsition Successfully Completed!");
				Thread.sleep(3000);
				driver.quit();

			}

		}

	}

}
