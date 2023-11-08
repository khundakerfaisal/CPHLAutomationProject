package CPHLCI;

import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLCI {

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

		driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_foreign_purchase.menu_cphl_commercial_invoice']"))
				.click();
		Thread.sleep(2000);

		WebElement CICreated = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		CICreated.click();
		Thread.sleep(3000);

		WebElement lcNoDropdownSelect = driver.findElement(By.xpath("//div[@name='lc_details_id']"));
		lcNoDropdownSelect.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement LcNoDropdownValueSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item'][1]/a")));
//		WebElement PoDropdownValueSelect = driver.findElement(By.xpath("//ul[@id='ui-id-5']/li[1]/a"));
		LcNoDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement CIAutoNumberColumn = driver.findElement(
				By.xpath("//input[@class='o_field_char o_field_widget o_quick_editable o_input o_required_modifier']"));

		CIAutoNumberColumn.clear();
		CIAutoNumberColumn.click();
		
		Set<String> generatesNumbers =new HashSet<>();
		Random random = new Random();
//		Set<String> generatedNumbers = new HashSet<>();
//		Random random = new Random();

		while (generatesNumbers.size() < 1) {
			// Generate a random number			
			String newNumber = generateCIFormatNumber(2023, random.nextInt(1000000));

			// Check for duplicates
			if (!generatesNumbers.contains(newNumber)) {
				// Add the unique number to the set
				generatesNumbers.add(newNumber);

				// Perform actions with the generated number, e.g., input it into a text field
				WebElement numberInput = driver.findElement(By.xpath("//input[@name='name']"));
				numberInput.sendKeys(newNumber);

				// Press Enter to submit the value (modify as needed)
				numberInput.sendKeys(Keys.RETURN);
			}

		}

		Thread.sleep(2000);

		WebElement CISubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // CI final
																								// submission
		CISubmit.click();
		Thread.sleep(2000);

		System.out.println("CI created successfully");

	}

	public static String generateCIFormatNumber(int year, int sequence) {
		String formattedYear = String.format("%04d", year);
		String formattedSequence = String.format("%06d", sequence);
		return "CI-" + formattedYear + "-" + formattedSequence;
	}

}
