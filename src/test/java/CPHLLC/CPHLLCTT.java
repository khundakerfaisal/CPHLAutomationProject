package CPHLLC;

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

		driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_foreign_purchase.menu_cphl_lc_details']")).click();
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
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-5']//li[1]/a")));
//		WebElement PoDropdownValueSelect = driver.findElement(By.xpath("//ul[@id='ui-id-5']/li[1]/a"));
		LcDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement LcAutoNumberColumn = driver.findElement(
				By.xpath("//input[@class='o_field_char o_field_widget o_quick_editable o_input o_required_modifier']"));
		LcAutoNumberColumn.clear();
		LcAutoNumberColumn.click();
//		LcAutoNumberColumn.sendKeys("LC/TT-2023-00002");
		Set<String> generatesLCTTNumbers = new HashSet<>();
		Random random = new Random();

		while (generatesLCTTNumbers.size() < 1) {
			String newNumber = generateLCTTFormatNumber(2023, random.nextInt(1000000));
			if (!generatesLCTTNumbers.contains(newNumber)) {
				generatesLCTTNumbers.add(newNumber);
				WebElement numberInput = driver.findElement(By.xpath("//input[@name='name']"));
				numberInput.sendKeys(newNumber);
				// Press Enter to submit the value (modify as needed)
				numberInput.sendKeys(Keys.RETURN);
			}
		}
		Thread.sleep(2000);

		WebElement LCttSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
		// submission
		LCttSubmit.click();
		Thread.sleep(2000);

		System.out.println("LC created successfully");

	}

	public static String generateLCTTFormatNumber(int year, int sequence) {
		String formattedYear = String.format("%04d", year);
		String formattedSequence = String.format("%06d", sequence);
		return "LC/TT-" + formattedYear + "-" + formattedSequence;
	}

}
