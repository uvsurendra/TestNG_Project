package testngbasicprograms;

import java.time.Duration;
import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	public WebDriver driver;
	public WebDriverWait wait;
  
	@BeforeClass
	public void launchingBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
		
	}
	@Test
	public void clickOnDatePicker() throws InterruptedException {
		String title = "jQuery UI";
		Assert.assertEquals(title, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title));
		
		driver.findElement(By.linkText("Datepicker")).click();
		Thread.sleep(5000);
		
	}
	@Test
	public void datePicker() {
		String title = "Datepicker | jQuery UI";
		Assert.assertEquals(title, driver.getTitle());
		wait.until(ExpectedConditions.titleContains(title));
		
		//WebElement iframe = driver.findElement(By.className("demo-frame"));
		//driver.switchTo().frame(iframe);
		
		driver.findElement(By.id("datepicker")).click();
	    By dataElement = By.id("ui-datepicker-div");
		wait.until(ExpectedConditions.presenceOfElementLocated(dataElement));
		
		//String expectedDate= "29";
		
		//List<WebElement> allDates = driver.findElements(By.xpath("//a[@aria-current=\"false\"]"));
		//for(WebElement eachDate:allDates) {
		//	if(eachDate.getText().equalsIgnoreCase(expectedDate)) {
				//eachDate.click();
			//}
		//}
		
		
	}
	@Parameters({"day","month","year"})
	@Test
	public void searchKeyWord(String day,String month,String year) throws InterruptedException {
		
		driver.findElement(By.id("datepicker")).click();
		By dataElement = By.id("ui-datepicker-div");
		wait.until(ExpectedConditions.presenceOfElementLocated(dataElement));
		
		String currentYear= driver.findElement(By.className("ui-datepicker-title")).getText();
		Thread.sleep(5000);
		String expectedMonthYear=month+" "+year;
		while(true){
			currentYear= driver.findElement(By.className("ui-datepicker-title")).getText();
			if(!(expectedMonthYear.equalsIgnoreCase(currentYear))) {
			
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			
			}
			else{
				break;
			}
			
			
		}
		//String str="ididb";
		//int k=000123;
		//String ifsc="ididb0"+k+"00123";
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
