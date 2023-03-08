package test.ng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestingDemo {
	public WebDriver driver=null;
	public WebDriverWait wait=null;
	//@BeforeSuite
	 // public void beforeSuite() {
		 // Reporter.log("Stared Demo");
		 // Reporter.log("this method excuted start");
	  //}                            
	//@BeforeTest
	  //public void beforeTest() {
		 // Reporter.log("Report");
	 // }
	 @BeforeClass
	  public void beforeClass() {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
	  }
	 @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
		 //WebDriverManager.chromedriver().setup();
		// WebDriver driver=new ChromeDriver();
		 driver.get("https://www.google.co.in/");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 driver.manage().window().minimize();
		 Thread.sleep(3000);
		 driver.manage().window().maximize();
	  }
	 @DataProvider //(name="dataDemo")
	  public Object[][] mutipleSetData() {
	   Reporter.log("creating twodimesional array");
	   Object[][] data=new Object[3][1];
	   data[0][0]="java";
	   data[1][0]="selenium";
	   data[2][0]="java selenium";
	   return data;
	   
	  }



	
  @Test(dataProvider = "mutipleSetData()")
  public void searchKeyWord(String s) {
	  WebElement textBox =driver.findElement(By.xpath("//input[@maxlength='2048']"));
	  textBox.sendKeys(s);
	  textBox.click();
	  
	  //actual output application behaviour
	  // expected output keyword to verify using asseration concept
	  Reporter.log("adding hard assertions");
	 // Assert.assertEquals(s+"- Google Search", driver.getTitle());
	  
	  String result = driver.findElement(By.id("result-stats")).getText();
	  Reporter.log("result for");
	  
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.manage().deleteAllCookies();
  }


 
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  



}
