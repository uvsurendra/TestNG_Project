package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioDemo {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void launchingBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		driver=new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.ajio.com/");
		wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	}
	@Test
	public void clickOnSignInLink() throws InterruptedException {
		String title="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		Assert.assertEquals(title, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title));
		
		driver.findElement(By.xpath("//span[@class='  login-form login-modal']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("9492257477");
		driver.findElement(By.className("login-btn")).click();
		
		
		
		driver.findElement(By.xpath("//input[@value='START SHOPPING']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
		
	}
	@Test
	public void cickOnJacketsAndCoats() throws InterruptedException {
		String title="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		Assert.assertEquals(title, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title));
		
		driver.findElement(By.linkText("Jackets & Coats")).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}
	@Test
	public void clickOnSignOut() {
		String title="Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		Assert.assertEquals(title, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title));
		

		driver.findElement(By.linkText("Sign Out")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		
	}
	
	

}
