package practice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

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
import org.testng.annotations.BeforeClass;

public class ZkDemoClass {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	  public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zkoss.org/zkdemo/input");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
		
	}
  @Test
  public void clickOnButton() {
	  String title = "ZK Live Demo - Input";
	  Assert.assertEquals(title, driver.getTitle());
	  wait.until(ExpectedConditions.titleContains(title));
	  
	  driver.findElement(By.linkText("Button")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	  
}
  @Test
  public void collectionSize() throws InterruptedException {
	  String title = "ZK Live Demo - Button";
	  Assert.assertEquals(title, driver.getTitle());
	  wait.until(ExpectedConditions.titleContains(title));
	  
	  List<WebElement> button=driver.findElements(By.className("z-button"));
	  for(WebElement eachbutton:button) {
		  Reporter.log("collection of size"+eachbutton.getText());
		  
	  }
	  Thread.sleep(5000);
	  
  }
  
  @Test
  public void verifyinfCheckBoxes() throws InterruptedException {
	  driver.findElement(By.linkText("Checkbox")).click();
	  Thread.sleep(5000);
	  
	  String title = "ZK Live Demo - Checkbox";
	  Assert.assertEquals(title, driver.getTitle());
	  wait.until(ExpectedConditions.titleContains(title));
	  
	  List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
	  for(WebElement eachcollection:checkbox) {
		  if(!eachcollection.isSelected()) {
			  eachcollection.click();
		  }
	  }
	  Reporter.log("collection of checkbox "+checkbox.size());
	  Thread.sleep(5000);
	  
  }
  @AfterClass
  public void closeBrowser() {
	  driver.close();
	  
	  
  }
  
  
}
