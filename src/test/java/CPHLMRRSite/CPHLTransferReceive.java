package CPHLMRRSite;

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

public class CPHLTransferReceive {

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
		MRRTypeSelection.selectByVisibleText("Transfer/Loan");
		Thread.sleep(2000);
		
		WebElement TransferLoanMrrSelection = driver.findElement(By.xpath("//div[@name='slt_request_id']"));
		TransferLoanMrrSelection.click();
		Thread.sleep(2000);

		WebDriverWait TransferMRRwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement TransferLoanMRRValueSelect = TransferMRRwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-5']/li[1]/a")));
		TransferLoanMRRValueSelect.click();
		Thread.sleep(2000);
		

		WebElement budgetDropdownSelect = driver.findElement(By.xpath("//div[@name='budget_id']"));
		budgetDropdownSelect.click();
		Thread.sleep(3000);

		WebDriverWait waitBudget = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
		WebElement Transferbudgetselect = waitBudget
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-10']/li[1]/a")));
		Transferbudgetselect.click();
		Thread.sleep(2000);

		WebElement TransferMRRSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // CI final
		// submission
		TransferMRRSubmit.click();
		Thread.sleep(2000);

		WebElement TransferMRRDraft = driver.findElement(By.xpath("//button[@states='mrr_draft']")); // CI final
		// submission
		TransferMRRDraft.click();
		Thread.sleep(2000);

		WebElement TransferMRRReview = driver.findElement(By.xpath("//button[@states='mrr_reviewed']")); // CI final
		// submission
		TransferMRRReview.click();
		Thread.sleep(2000);

		System.out.println("Transfer/Loan MRR created successfully");
	}

}
