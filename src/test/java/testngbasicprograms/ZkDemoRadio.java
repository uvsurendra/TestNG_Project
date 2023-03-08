package testngbasicprograms;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
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

public class ZkDemoRadio {
	public LaunchingBrowser lb;
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test(description = "VerfyingRadioButton")
  public void verfyingRadioButtons() throws InterruptedException {
	  Reporter.log("VerfyingRadioButton");
	  driver.findElement(By.linkText("Radio Button")).click();
	  String title="ZK Live Demo - Radio Button";
	  wait.until(ExpectedConditions.titleContains(title));
	  Assert.assertEquals(title, driver.getTitle());
	 // driver.findElement(By.name("_pgu50jsn1")).click();
	//  driver.findElement(By.name("_pg0ln3ee")).click();
	//  driver.findElement(By.name("_pg48ov9f1")).click();
	  
	  List<WebElement> allRadioButtons=driver.findElements(By.xpath("//input[@type='radio']"));
	  for(WebElement eachButton:allRadioButtons) {
		 if(!eachButton.isSelected()) {
			  eachButton.click();
			  Reporter.log("collection of esch element "+eachButton.getText());
	}
	  }
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void launchingUrl() {
	  Reporter.log("launching url using get()");
	  driver.get("https://www.zkoss.org/zkdemo/input");
	  String title="ZK Live Demo - Input";
	  Assert.assertEquals(title, driver.getTitle());
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	  wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Excuted RadioButtons");
	  driver.manage().deleteAllCookies();
  }

  @BeforeClass
  public void launchingBrowser() {
	  lb=new LaunchingBrowser();
	  Reporter.log("launching Browser only");
	  lb.browserLaunching("chrome");
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
  }

  @AfterClass
  public void afterClass() {
	  driver.quit(); 
  }

}
