package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassDemo {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
	}
	@Test
	public void emailChec() throws InterruptedException {
		String title="Facebook – log in or sign up";
		wait.until(ExpectedConditions.titleContains(title));
		Assert.assertEquals(title, driver.getTitle());
		
		driver.findElement(By.id("email")).sendKeys("surendravenkat5@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Surendra@577");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		Thread.sleep(5000);
		
	}
	@Test
	public void loginFacebook() throws InterruptedException {
		String title1="(1) Facebook";
		Assert.assertEquals(title1, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title1));
		
		WebElement dy=driver.findElement(By.xpath("//input[@aria-label='Search Facebook']"));
		Thread.sleep(5000);
		dy.click();
		Thread.sleep(5000);
		dy.sendKeys("surendra");
		Actions action =new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	

}
