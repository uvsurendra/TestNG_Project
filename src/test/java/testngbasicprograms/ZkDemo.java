package testngbasicprograms;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
//import java.util.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class ZkDemo {
	public LaunchingBrowser ld;
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test(description = "Verfiying Buttons")
  public void verfiyingButtons() {
	  Reporter.log("click on ButtonLink");
	  String title="ZK Live Demo - Date and Time Picker";
      Assert.assertEquals(title, driver.getTitle());
      driver.findElement(By.linkText("Button")).click();
     // String title="ZK Live Demo - Date and Time Picker";
     // Assert.assertEquals(title, driver.getTitle());
    List<WebElement> allButtons = driver.findElements(By.className("z-button"));
    for(WebElement eachTags:allButtons) {
    	Reporter.log("collection List"+eachTags.getText());
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }
	  
 }
  @Test(description="verfiyingCheckbox")
   public void verfiyingCheckBoxex() {
	  Reporter.log("Verfiying the Checkboxex");
	  String title="ZK Live Demo - Date and Time Picker";
	  Assert.assertEquals(title, driver.getTitle());
	  driver.findElement(By.linkText("Checkbox")).click();
	  Reporter.log("Verfiying page title");
	  //String title="ZK Live Demo - Date and Time Picker";
	 // Assert.assertEquals(title, driver.getTitle());
	List<WebElement> allCheckbox= driver.findElements(By.cssSelector("input[type='checkbox']"));
	Reporter.log("Checkboxes Size"+allCheckbox.size());
	for(WebElement eachBoxes:allCheckbox) {
		if(!eachBoxes.isSelected()) {
			eachBoxes.click();
		}
	}
	 Reporter.log("sucessfully click on checkboxes"); 
	String selCheckBoxes= driver.findElement(By.xpath("(//span[@id='t5MUg']/following::div/span)[1]")).getText();
	Reporter.log("clicking checkboxes"+selCheckBoxes);
  }
  
  
  
  
  
  
  
  public void launchingUrl() {
	Reporter.log("launching Url using get method");
	driver.get("https://www.zkoss.org/zkdemo/input");
	String title="ZK Live Demo - Date and Time Picker";
	wait.until(ExpectedConditions.titleContains(title));
	Reporter.log("verfiying page title");
	Assert.assertEquals(title, driver.getTitle());
	
	
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Excuting After Method");
	  driver.manage().deleteAllCookies();
	  //Reporter.log("Excuting AfterMethod on checkboxes");
	 // driver.manage().deleteAllCookies();
  }


  
  @BeforeClass
  public void launchingBrowser() {
	  Reporter.log("starting launching browser");
	 //ld.browserLaunching("chrome");
	  WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	 wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
	  driver.quit();
  }

}
