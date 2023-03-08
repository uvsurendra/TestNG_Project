package testngbasicprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardClass {
   public WebDriver driver;
   public WebDriverWait wait;
   
  @Parameters({"browser"})
   @BeforeClass
   public void searchKeyWords(String browser) {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get("https://jqueryui.com/");
	   driver.manage().window().maximize();
	   driver.manage().window().minimize();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	 }
   
   @Test(priority=1)
   public void clickOnDroppable() {
	   String title = "jQuery UI";
	   Assert.assertEquals(title, driver.getTitle());
	   driver.findElement(By.linkText("Droppable")).click();
	   wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
	   
   }
  
  
   @Test(priority=2)
   public void clickMouse() throws InterruptedException {
	   String title = "Droppable | jQuery UI";
	   Assert.assertEquals(title, driver.getTitle());
	  WebElement frame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	   driver.switchTo().frame(frame);
	   //frame.click();
	   WebElement src= driver.findElement(By.id("draggable"));
	   WebElement target= driver.findElement(By.id("droppable"));
	   Actions ac=new Actions(driver);
	   ac.dragAndDrop(src, target).perform();
	   Thread.sleep(5000);
	   driver.close();
	   
	   
   }
}
