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

public class CPHL_C_TReceiveMRR {

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
		MRRTypeSelection.selectByVisibleText("Clip & Touch Receive");
		Thread.sleep(2000);
		
		WebElement CAndTMrrSelection = driver.findElement(By.xpath("//div[@name='c_and_t_id']"));
		CAndTMrrSelection.click();
		Thread.sleep(2000);

		WebDriverWait CAndTMRRwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement CAndTMRRValueSelect = CAndTMRRwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-3']/li[1]/a")));
		CAndTMRRValueSelect.click();
		Thread.sleep(2000);

		WebElement CAndTMRRSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // CI final
		// submission
		CAndTMRRSubmit.click();
		Thread.sleep(2000);

		WebElement CAndTMRRDraft = driver.findElement(By.xpath("//button[@states='mrr_draft']")); // CI final
		// submission
		CAndTMRRDraft.click();
		Thread.sleep(2000);

		WebElement CAndTMRRReview = driver.findElement(By.xpath("//button[@states='mrr_reviewed']")); // CI final
		// submission
		CAndTMRRReview.click();
		Thread.sleep(2000);

		System.out.println("C&T MRR created successfully");


	}

}
