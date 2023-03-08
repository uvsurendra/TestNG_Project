package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPrime {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://www.primevideo.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
	    
	  }
	//@Parameters({"userName","passWord"})
	@Test
	public void amazonPrimeLogin() throws InterruptedException {
		 String title = "Welcome to Prime Video";
		 Assert.assertEquals(title, driver.getTitle());
		 //wait.until(ExpectedConditions.titleContains(title));
		 
		 driver.findElement(By.xpath("//span[text()='Sign in to join Prime']")).click();
		 Thread.sleep(5000);
		
		 WebElement emailId=driver.findElement(By.id("ap_email"));
		 emailId.sendKeys("subbu09090@gmail.com");
		 
		 WebElement passId=driver.findElement(By.id("ap_password"));
		 passId.sendKeys("subbu@8426R");
		 
		 driver.findElement(By.className("a-button-input")).click();
		 
		 Thread.sleep(5000);
		 
		 driver.close();
		 
		
		
		
		
	}

}
