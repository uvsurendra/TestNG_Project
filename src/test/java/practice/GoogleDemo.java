package practice;

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
import org.testng.annotations.AfterClass;

public class GoogleDemo {
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test
  public void searchKeyWord() throws InterruptedException {
	  driver.get("https://www.google.com/");
	  String title="Google";
	  Assert.assertEquals(title, driver.getTitle());
	  WebElement search = driver.findElement(By.name("q"));
	  search.sendKeys("redbus");
	  Thread.sleep(5000);
	  //String expSuggetion="redbus customer care number";
	  Thread.sleep(3000);
	  List<WebElement>redCollection=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	  
	  for(WebElement eachCollection:redCollection) {
		// String suggestion=eachCollection.getText();
		 if(eachCollection.getText().equalsIgnoreCase("redbus customer care number")) {
			 Thread.sleep(3000);
			 eachCollection.click();
			 break;
		 }
		 Thread.sleep(5000);
		 driver.close();
	 }
	 
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	 
	 }
      
  }


  
 
