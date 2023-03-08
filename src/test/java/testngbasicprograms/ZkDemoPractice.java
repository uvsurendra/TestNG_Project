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

public class ZkDemoPractice {
	public WebDriver driver;
	public WebDriverWait wait;
  @Test (description ="Verfying Buttons")
  public void verfiyingButtons() {
	  Reporter.log("click on buttons");
	  driver.findElement(By.linkText("Button")).click();
	  String title="ZK Live Demo - Button";
	  Assert.assertEquals(title, driver.getTitle());
	  wait.until(ExpectedConditions.titleContains(title));
	  List<WebElement> allButtons =driver.findElements(By.xpath("//button[@type='button']"));
	  for(WebElement eachButton:allButtons) {
		  Reporter.log("collection of size"+eachButton.getText());
		  
	  }
	  
  }
  @Test
  public void averfyingLinkTexts() {
	  Reporter.log("Verfying LinkCheckBoxes");
	  driver.findElement(By.linkText("Checkbox")).click();
	  String title="ZK Live Demo - Checkbox";
	  Assert.assertEquals(title, title);
	  List<WebElement>allLinkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
	  for(WebElement eachBoxes:allLinkBoxes) {
		  if(!eachBoxes.isSelected());
		  eachBoxes.click();
	  }
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Launching Url Using get()");
	  driver.get("https://www.zkoss.org/zkdemo/input");
	  String title="ZK Live Demo - Input";
	  wait.until(ExpectedConditions.titleContains(title));
	  driver.findElement(By.linkText("Button")).submit();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Excuting Button Program");
	  driver.manage().deleteAllCookies();
  }

  @BeforeClass
  public void beforeClass() {
	  Reporter.log("Startinh Launching Browser");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	  wait=new WebDriverWait (driver,Duration.ofSeconds(5000));
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
