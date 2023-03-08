package testngbasicprograms;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaExcuteConcept {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	
@BeforeClass
public void launchingBrowser() {
	//How to disable the notifications while automation our application
	  ChromeOptions cd = new ChromeOptions();
	  cd.addArguments("--disable-notifications");
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver(cd);
      driver.manage().window().maximize();
      driver.get("https://www.instagram.com/");
     
     
}
@Test
public void searchKeyWord() throws InterruptedException {
	js = (JavascriptExecutor)driver;
	wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	String title = "Instagram";
	Assert.assertEquals(title, driver.getTitle());
	wait.until(ExpectedConditions.titleContains(title));
	//refresh the page using Java script executor
	js.executeScript("location.reload()");
	Thread.sleep(5000);
	WebElement loginFaceBook=driver.findElement(By.xpath("//span[text()='Log in with Facebook']"));
	wait.until(ExpectedConditions.visibilityOf(loginFaceBook));
	//click on log in with face book link using JavaScript Executor
	js.executeScript("arguments[0].click()", loginFaceBook);
	
	WebElement emailEditBox=driver.findElement(By.id("email"));
	js.executeScript("arguments[0].value='surendravenkat5@gmail.com'", emailEditBox);
	Thread.sleep(5000);
	
	WebElement passEditBox=driver.findElement(By.id("pass"));
	js.executeScript("arguments[0].setAttribute('style','background:yellow;border:solid 5px Green')",passEditBox );
	js.executeScript("arguments[0].value='Surendra@577'", passEditBox);
	Thread.sleep(5000);
	
	WebElement loginButton = driver.findElement(By.name("login"));
	js.executeScript("arguments[0].click()", loginButton);
	Thread.sleep(5000);
	
	 //scroll down and up using java script executor based on pixel size
	js.executeScript("window.scrollBy(0,3500)", "");
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,-2500)", "");
	Thread.sleep(5000);
	
	
	driver.quit();
	
}
}
