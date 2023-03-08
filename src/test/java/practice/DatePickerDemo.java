package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {
    public WebDriver driver;
    public WebDriverWait wait;
    
    @BeforeClass
    public void launchingBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://jqueryui.com/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    	wait= new WebDriverWait (driver,Duration.ofSeconds(5000));
    	
   }
    @Test
    public void clickOnDatePicker() {
    	String title="jQuery UI";
    	Assert.assertEquals(title, driver.getTitle());
    	wait.until(ExpectedConditions.titleContains(title));
    	
    	driver.findElement(By.linkText("Datepicker")).click();
    	
    }
    
    @Test
    public void clickOnDates() {
    	String title="Datepicker | jQuery UI";
    	Assert.assertEquals(title, driver.getTitle());
    	wait.until(ExpectedConditions.titleContains(title));
    	
    	driver.findElement(By.id("datepicker")).click();
    	
    }
    
}
