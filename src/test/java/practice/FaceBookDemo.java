package practice;

import java.time.Duration;

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

public class FaceBookDemo {
      public WebDriver driver;
      public WebDriverWait wait;
      
      @BeforeClass
      public void launchingBrowser() {
    	  WebDriverManager.chromedriver().setup();
    	  driver=new ChromeDriver();
    	  driver.manage().window().maximize();
    	  driver.get("https://www.facebook.com/");
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    	  wait=new WebDriverWait (driver,Duration.ofSeconds(5000));
    }
      @Parameters({"userName","passWord"})
      @Test
      public void loginFaceBook(String userName,String passWord) throws InterruptedException {
    	  String title="Facebook – log in or sign up";
    	  Assert.assertEquals(title, driver.getTitle());
    	  wait.until(ExpectedConditions.titleContains(title));
    	  
    	  WebElement emailId=driver.findElement(By.name("email"));
    	  emailId.sendKeys(userName);
    	  Thread.sleep(5000);
    	  WebElement passId=driver.findElement(By.name("pass"));
    	  passId.sendKeys(passWord);
    	  
    	  Thread.sleep(5000);
    	  
    	  driver.findElement(By.name("login")).click();
    	  
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    	  Thread.sleep(5000);
    	  driver.close();
    	  
      }
      
      
	
}
