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

public class ZkClassName {
	public WebDriver driver;
	public WebDriverWait wait;
  @Test
  public void verfiyingButtons() throws InterruptedException {
	  Reporter.log("click on button link");
	  driver.findElement(By.linkText("Button")).click();
	  String title="ZK Live Demo - Button";
	  Assert.assertEquals(title, driver.getTitle());
	 List<WebElement> allButtons=driver.findElements(By.className("z-button"));
	 for(WebElement eachButton:allButtons) {
		 Reporter.log("Collection of Size "+eachButton.getText());
		 
	 }
	 Thread.sleep(5000);
	 
	  
  }
  @Test
  public void verfiyLinkCheckBox() throws InterruptedException {
	  Reporter.log("Verfiying CheckBoxes");
	  driver.findElement(By.linkText("Checkbox")).click();
	  String title= "ZK Live Demo - Checkbox";
	  Assert.assertEquals(title, driver.getTitle());
	  List<WebElement> allCheckBoxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
	  for(WebElement eachCheckbox:allCheckBoxes) {
		  if(!eachCheckbox.isSelected()) {
			  eachCheckbox.click();
			  Reporter.log("Collection of EachCheckBox "+eachCheckbox.getText());
		  }
	  }
	  Reporter.log("Excuted CheckBox Program");
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void launchingUrl() {
	  Reporter.log("Launching URL using get() ");
	  driver.get("https://www.zkoss.org/zkdemo/input");
	  String title = "ZK Live Demo - Input";
	  wait.until(ExpectedConditions.titleContains(title));
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Excuting VerfiyButton Programm ");
	  driver.manage().deleteAllCookies();
  }

  @BeforeClass
  public void launchingBrowser() {
	  Reporter.log("Launching Browser Only");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
