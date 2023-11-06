package CPHLQC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLQC {

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

		// Inventory menu selection
		driver.findElement(By.xpath("//a[@data-menu-xmlid='stock.menu_stock_root']")).click();
		Thread.sleep(2000);

		// operation menu selection
		driver.findElement(By.xpath("//button[@data-menu-xmlid='cphl_inventory.menu_qa_mrr_root']")).click();
		Thread.sleep(2000);

		// QA menu selection
		driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_inventory.menu_qc']")).click();
		Thread.sleep(2000);
		// Order Root menu End

		// QC Create Button
		WebElement QcCreated = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		QcCreated.click();
		Thread.sleep(3000);

		// MRR Type selection Button
		WebElement MRRTypeDropdownSelect = driver.findElement(By.xpath("//Select[@name='purchase_type']"));
		MRRTypeDropdownSelect.click();
		Thread.sleep(2000);

		WebElement MRRTypeDropdownValueSelect = driver.findElement(By.xpath("//option[text()='Site Purchase']"));
		MRRTypeDropdownValueSelect.click();
		Thread.sleep(2000);

		// MRR Type selection Button
		WebElement PoDropdownSelect = driver.findElement(By.xpath("//div[@name='purchase_order_id']"));
		PoDropdownSelect.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement PoDropdownValueSelect = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item'][1]/a")));
		PoDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement QCSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // QC final
																								// submission
		QCSubmit.click();
		Thread.sleep(2000);

		WebElement QCReview = driver.findElement(By.xpath("//button[@name='button_send_for_qa_review']")); // QCReview 
																											// submission
		QCReview.click();
		Thread.sleep(2000);
		
		WebElement QCApprove = driver.findElement(By.xpath("//button[@name='button_qa_approve']")); // QCApprove 
																									// submission
		QCApprove.click();
		Thread.sleep(2000);
		
		WebElement SendForMRR = driver.findElement(By.xpath("//button[@name='button_send_for_mrr']")); // SendForMRR 
																										// submission
		SendForMRR.click();
		Thread.sleep(2000);

		System.out.println("QC created successfully");
	}

}
