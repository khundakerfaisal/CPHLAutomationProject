package CPHLMRRSite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPHLMRRLocal {

	public static void main(String[] args) throws InterruptedException{
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
		driver.findElement(By.xpath("//a[@data-menu-xmlid='stock.menu_stock_root']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@data-menu-xmlid='cphl_inventory.menu_qa_mrr_root']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_inventory.menu_qa_mrr']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		Thread.sleep(2000);

//		WebDriverWait MRRTypeWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//		WebElement MRRType = MRRTypeWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='purchase_type']")));
//		

		WebElement MRRType = driver.findElement(By.xpath("//select[@name='purchase_type']"));
		MRRType.click();
		Select MRRTypeSelection = new Select(MRRType);
		MRRTypeSelection.selectByVisibleText("Local Purchase");
		Thread.sleep(2000);
		
		WebElement SiteMrrSelection = driver.findElement(By.xpath("//div[@name='purchase_order_id']"));
		SiteMrrSelection.click();
		Thread.sleep(2000);

		WebDriverWait SiteMRRwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement SiteMRRValueSelect = SiteMRRwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-2']/li[1]/a")));
		SiteMRRValueSelect.click();
		Thread.sleep(2000);

		WebElement SiteMRRSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // CI final
		// submission
		SiteMRRSubmit.click();
		Thread.sleep(2000);

		WebElement MRRDraft = driver.findElement(By.xpath("//button[@states='mrr_draft']")); // CI final
		// submission
		MRRDraft.click();
		Thread.sleep(2000);

		WebElement MRRReview = driver.findElement(By.xpath("//button[@states='mrr_reviewed']")); // CI final
		// submission
		MRRReview.click();
		Thread.sleep(2000);

		System.out.println("Local MRR created successfully");

	}

}
