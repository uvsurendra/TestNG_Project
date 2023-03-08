package test.ng;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataPickerDemo {
   public WebDriver driver;
   public WebDriverWait wait;
   
   @BeforeClass
   public void launchingBrowser() {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://jqueryui.com/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	 }
   @Test
   public void clickDataPicker() throws InterruptedException {
	   String title="jQuery UI";
	   Assert.assertEquals(title, driver.getTitle());
	   wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	   wait.until(ExpectedConditions.titleContains(title));
	   
	   driver.findElement(By.linkText("Datepicker")).click();
	   Thread.sleep(5000);
   }
   @Parameters({"month","year","day"})
   @Test
   public void clickOnDateMonthYear(String month,String year,String day) throws InterruptedException {
	   String title="Datepicker | jQuery UI";
	   Assert.assertEquals(title, driver.getTitle());
	   wait.until(ExpectedConditions.titleContains(title));
	   
	   WebElement iframe= driver.findElement(By.className("demo-frame"));
	   driver.switchTo().frame(iframe);
	   
	   driver.findElement(By.id("datepicker")).click();
	   By dataElement = By.id("ui-datepicker-div");
	   wait.until(ExpectedConditions.presenceOfElementLocated(dataElement));
	   
	  String currentMonthYear= driver.findElement(By.className("ui-datepicker-title")).getText();
	  
	   String expectedMonthYear= month+" "+year;
	   
	   while(true) {
		   currentMonthYear= driver.findElement(By.className("ui-datepicker-title")).getText();
		   if(!(expectedMonthYear.equalsIgnoreCase(currentMonthYear))) {
			   driver.findElement(By.xpath("//span[text()='Prev']")).click();
			   
		   }
		   else {
			   break;
		   }
	   }
	   
	   
	   String expectedDay="29";
	   List<WebElement> dataCollection=driver.findElements(By.xpath("//a[@href='#']"));
	   for(WebElement eachCollection:dataCollection) {
		   if(eachCollection.getText().equalsIgnoreCase(expectedDay)) {
			   eachCollection.click();
		   }
		   
	   }
	   Thread.sleep(5000);
	   driver.close();
	   
	   
   }
}
