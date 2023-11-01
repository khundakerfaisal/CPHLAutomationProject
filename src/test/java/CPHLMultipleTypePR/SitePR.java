package CPHLMultipleTypePR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SitePR {
	private WebDriver driver;
	public SitePR(WebDriver driver) {
		this.driver = driver;
	}

	public void SitePRApprover()throws InterruptedException {
		// Pr Save button Pressed
		WebElement prSubmit = driver.findElement(By.xpath("//button[@title='Save record']"));
		prSubmit.click();
		Thread.sleep(3000);

		// Site Pr Hod Approval button Pressed
		WebElement PrHodApproval = driver.findElement(By.xpath("//button[@name='button_hod_approve']"));
		PrHodApproval.click();
		Thread.sleep(1000);

		// Site Pr pm Approval button Pressed
		WebElement PrPmApproval = driver.findElement(By.xpath("//button[@name='button_pm_approve']"));
		PrPmApproval.click();
		Thread.sleep(1000);

		// Site Pr pm Ops Approval button Pressed
		WebElement PrPmOpsApproval = driver.findElement(By.xpath("//button[@name='button_pm_ops_forward']"));
		PrPmOpsApproval.click();
		Thread.sleep(1000);

		// Site Pr Forward Approval button Pressed
		WebElement PrScmApproval = driver.findElement(By.xpath("//button[@name='button_forward']"));
		PrScmApproval.click();
		Thread.sleep(1000);

		// Site Pr Done Approval button Pressed
		WebElement PrCooApproval = driver.findElement(By.xpath("//button[@name='button_done']"));
		PrCooApproval.click();
		Thread.sleep(1000);


	}

}
