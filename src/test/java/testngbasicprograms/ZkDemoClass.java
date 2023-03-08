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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class ZkDemoClass {
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test
  public void verfiyingButtons() throws InterruptedException {
	  Reporter.log("Verfiying Buttons");
	  driver.findElement(By.linkText("Button")).click();
	  String title="ZK Live Demo - Button";
	  Assert.assertEquals(title, driver.getTitle());
	  List<WebElement> allButtons=driver.findElements(By.className("z-button"));
	  for(WebElement eachButton:allButtons) {
		  Reporter.log("collection of size "+eachButton.getText());
	  }
	  Reporter.log("Verfiying buttons close");
	  
	  Thread.sleep(5000);
  }
  @Test
  public void verfiyingCheckBoxLink() throws InterruptedException {
	  Reporter.log("Verfiying CheckBoxes ");
	  driver.findElement(By.linkText("Checkbox")).click();
	  String title="ZK Live Demo - Checkbox";
	  Assert.assertEquals(title, driver.getTitle());
	 List<WebElement> allCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
	 Reporter.log("Checkboxes Sizes "+allCheckboxes.size());
	 for(WebElement eachCheckBoxes:allCheckboxes) {
		 if(!eachCheckBoxes.isSelected()) {
			 eachCheckBoxes.click();
		 }
	 }
	 Thread.sleep(5000);
  }
  
  
  @BeforeMethod
  public void launchingUrl() {
	  Reporter.log("Starting Launching Browser url using get method");
	  driver.get("https://www.zkoss.org/zkdemo/input");
	  String title="ZK Live Demo - Input";
	  Assert.assertEquals(title, driver.getTitle());
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Excuting buttons");
	  driver.manage().deleteAllCookies();
  }

  @BeforeClass
  public void launchingBrowser() {
	  Reporter.log("Starting Launching Browser");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
