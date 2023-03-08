package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToggleSwitch {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.zkoss.org/zkdemo/input");
		wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	}
	@Test
	public void clickOnToggleSwitch() throws InterruptedException {
		String title ="ZK Live Demo - Input";
		Assert.assertEquals(title, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title));
		
		driver.findElement(By.linkText("Toggle Switch")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='switch']")).click();
		Thread.sleep(5000);
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		
		
	}
	
	
	
	

}
