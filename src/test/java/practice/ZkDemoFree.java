package practice;

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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZkDemoFree {
      public  WebDriver driver;
      public WebDriverWait wait;
      
      @BeforeClass
      public void launchingbrowser() {
    	  WebDriverManager.chromedriver().setup();
    	  driver=new ChromeDriver();
    	  driver.get("https://www.zkoss.org/zkdemo/input");
    	  driver.manage().window().maximize();
    	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    	  wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
    }
      @Test
      public void clickOnButton() throws InterruptedException {
    	  String title="ZK Live Demo - Input";
    	  Assert.assertEquals(title, driver.getTitle());
    	  wait.until(ExpectedConditions.titleContains(title));
    	  
    	  driver.findElement(By.linkText("Button")).click();
    	  Thread.sleep(5000);
      }
      @Test
      public void verfiyingButtons() {
    	  String title="ZK Live Demo - Button";
    	  Assert.assertEquals(title, driver.getTitle());
    	  wait.until(ExpectedConditions.titleContains(title));
    	  
    	 List<WebElement> buttonsList= driver.findElements(By.xpath("//button[@type='button']"));
    	 for(WebElement eachButton:buttonsList) {
    		 Reporter.log("Collection of Size"+eachButton.getText());
    	 }
      }
      
      @Test
      public void verfiyingCheckBoxes() throws InterruptedException {
    	  driver.findElement(By.linkText("Checkbox")).click();
    	  
    	 String title="ZK Live Demo - Checkbox";
    	  Assert.assertEquals(title, driver.getTitle());
    	 wait.until(ExpectedConditions.titleContains(title));
    	  
    	 List<WebElement> checkBoxesList= driver.findElements(By.xpath("//input[@type='checkbox']"));
    	 for(WebElement eachCheckBox:checkBoxesList) {
    		 if(!(eachCheckBox.isSelected()));
    		 eachCheckBox.click();
    		 Reporter.log("Collection of Size"+eachCheckBox.getText());
    	 }
    	 Thread.sleep(5000);
    	 driver.close();
      }
      
      
     
}
