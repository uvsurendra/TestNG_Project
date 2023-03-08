package test.ng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExicutor {
     public WebDriver driver;
     public WebDriverWait wait;
     public JavascriptExecutor js;
     @BeforeMethod
     public void launchinfBrowser() {
    	 
    	 ChromeOptions cd=new ChromeOptions();
    	 cd.addArguments("--disable-notification");
    	 
    	 WebDriverManager.chromedriver().setup();
    	 driver=new ChromeDriver(cd);
    	 
    	 driver.get("https://www.instagram.com/");
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    	 
   }
     @Test
     public void loginButton() throws InterruptedException {
    	 js=(JavascriptExecutor)driver;
    	 String title = "Instagram";
    	 Assert.assertEquals(title,driver.getTitle());
    	 wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
    	 wait.until(ExpectedConditions.titleContains(title));
    	 js.executeScript("location.reload()");
    	 Thread.sleep(5000);
    	 WebElement loginFaceBook= driver.findElement(By.xpath("//span[text()='Log in with Facebook']"));
    	
    	 wait.until(ExpectedConditions.visibilityOf(loginFaceBook));
    	 js.executeScript("arguments[0].click()", loginFaceBook);
    	 
    	 //String title2="pageTitle";
    	//wait.until(ExpectedConditions.titleContains(title2));
    	//Assert.assertEquals(title2,driver.getTitle());
    	 
    	 WebElement loginMail=driver.findElement(By.id("email"));
    	 //js.executeScript("argument[0].setAttribute('style','background:red;border:solid 5px Green')", loginMail);
    	 js.executeScript("arguments[0].value='surendravenkat5@gmail.com'", loginMail);
    	 
    	 WebElement loginPass=driver.findElement(By.id("pass")); 
    	 js.executeScript("arguments[0].setAttribute('style','background:red;border:solid 5px Green')", loginPass);
    	 js.executeScript("arguments[0].value='Surendra@577'", loginPass);
    	 
    	 WebElement login=driver.findElement(By.name("login")); 
    	 js.executeScript("arguments[0].click()", login);
    	 
    	 Thread.sleep(5000);
    	 
    	 
    	 
    	 driver.quit();
   }
    
}
