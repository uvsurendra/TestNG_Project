package test.ng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestingClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test(dataProvider = "data")
  public void sendKeys(String s) {
	  driver.findElement(By.className("gLFyf")).sendKeys(s);
	  
	  //Assert.assertEquals(s, driver.getTitle());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Launching the URL");
	  driver.get("https://www.google.co.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Excute the Program");
	  driver.manage().deleteAllCookies();
	  
  }


  @DataProvider(name="data")
  public Object[][] dp() throws InterruptedException {
    Object[][] data=new Object[4][1];
    data[0][0]="java";
    Thread.sleep(5000);
    data[1][0]="java Selenium";
    Thread.sleep(5000);
    data[2][0]="TestNG";
    Thread.sleep(5000);
    data[3][0]="Selenium";
    Thread.sleep(5000);
    return data;
  }
  @BeforeClass
  public void beforeClass() {
	  Reporter.log("Excuted started from beforeClass()");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	  
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
