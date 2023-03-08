package testngbasicprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropAndDown {
    public WebDriver driver;
    public WebDriverWait wait;
    
    @Parameters ({"browser"})
    @BeforeClass
    public void launchingBrowser(String browser) {
    	if(browser.equalsIgnoreCase("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    		
    	}
    	if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
    		
    	}
    	if(browser.equalsIgnoreCase("ie")) {
    		WebDriverManager.iedriver().setup();
    		driver=new InternetExplorerDriver();
    		
    	}
    	driver.get("https://jqueryui.com/droppable/");
    	driver.manage().window().maximize();
    	wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
    }
    @Test
    public void dragDropTest() throws InterruptedException {
    	String title ="Droppable | jQuery UI";
    	Thread.sleep(5000);
    	Assert.assertEquals(title, driver.getTitle());
    	Thread.sleep(10000);
    	//wait.until(ExpectedConditions.titleContains(title));
    	//Thread.sleep(5000);
    	//Assert.assertEquals(title, );;
    	WebElement mouseClick= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
    	driver.switchTo().frame(mouseClick);
    	Thread.sleep(10000);
    	
    	WebElement src=driver.findElement(By.id("draggable"));
    	Assert.assertEquals(true, src.isDisplayed());
    	Thread.sleep(10000);
    	WebElement target=driver.findElement(By.id("droppable "));
    	Thread.sleep(10000);
    	Actions ac=new Actions(driver);
    	Thread.sleep(10000);
    	ac.dragAndDrop(src, target).perform();
    	Thread.sleep(10000);
    	Thread.sleep(5000);
    	driver.close();
    }
}
