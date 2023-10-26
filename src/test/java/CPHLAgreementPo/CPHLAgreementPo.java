package CPHLAgreementPo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CPHLAgreementPo {

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

	}

}
