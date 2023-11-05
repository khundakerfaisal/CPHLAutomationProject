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

		WebElement VendorDropdownSelect = driver.findElement(By.xpath("//div[@name='partner_id']"));
		VendorDropdownSelect.click();
		Thread.sleep(2000);

		WebElement VendorDropdownValueSelect = driver.findElement(By.xpath("//a[text()='Chowdhury Motors']"));
		VendorDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement PoDropdownSelect = driver.findElement(By.xpath("//div[@name='purchase_order_ids']"));
		PoDropdownSelect.click();


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement PoDropdownValueSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-5']/li[1]/a")));
		PoDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement CurrencyDropdownSelect = driver.findElement(By.xpath("//div[@name='currency_id']"));
		CurrencyDropdownSelect.click();
		Thread.sleep(3000);

		WebElement CurrencyDropdownValueSelect = driver.findElement(By.xpath("//a[text()='USD']"));
		CurrencyDropdownValueSelect.click();
		Thread.sleep(2000);
		
		WebElement piColumn = driver.findElement(
				By.xpath("//input[@class='o_field_char o_field_widget o_quick_editable o_input o_required_modifier']"));
		piColumn.sendKeys("Pi-2023-00001");
		Thread.sleep(2000);


		
//		AutoGenerateNumber function= new AutoGenerateNumber(driver);
//		function.generateUniqueProformaNumber();
//		Thread.sleep(2000);



		WebElement ProformaSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
																									// submission
		ProformaSubmit.click();
		Thread.sleep(2000);


		
		System.out.println("Pi created successfully");
	}

}
