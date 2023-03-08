package testngbasicprograms;

import java.time.Duration;

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

public class LinkedTestDemo {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeClass
	public void launcingLinkedin() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
	
	}
	
  @Test
  public void doLogin() {
	  driver.get("https://www.linkedin.com/");
		String title="LinkedIn: Log In or Sign Up";
		wait.until(ExpectedConditions.titleContains(title));
		Assert.assertEquals(title, driver.getTitle());
		WebElement signinButton = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		wait.until(ExpectedConditions.visibilityOf(signinButton));
		signinButton.click();
  }
  
  @Parameters ({"useName","passWord"})
  @Test
  public void inputData(String useName,String passWord) throws InterruptedException {
  	String title="LinkedIn Login, Sign in | LinkedIn";
  	Assert.assertEquals(title, driver.getTitle());
  	WebElement input=driver.findElement(By.name("session_key"));
  	wait.until(ExpectedConditions.visibilityOf(input));
  	input.sendKeys(useName);
  	WebElement output=driver.findElement(By.id("password"));
  	wait.until(ExpectedConditions.visibilityOf(output));
  	output.sendKeys(passWord);
  	 driver.findElement(By.xpath("//button[@type='submit']")).click();
  	Thread.sleep(5000);
  }
  
  @Test
  public void signOut() throws InterruptedException{
  	
  	String title="(43) Feed | LinkedIn";
  	Assert.assertEquals(title, driver.getTitle());
  	
  	
  	//click on profilerealcard
  	driver.findElement(By.id("ember18")).click();
  	
  	
  	WebElement signOut=driver.findElement(By.xpath("//a[@class='global-nav__secondary-link mv1'][contains(.,'Sign Out')]"));
  	wait.until(ExpectedConditions.visibilityOf(signOut));
  	signOut.click();
  	Thread.sleep(5000);
  	Reporter.log("Excuted signOut Sucessfully ");
  	Thread.sleep(3000);
  	
  	driver.findElement(By.xpath("//span[text()='Sign out']")).click();
  	Thread.sleep(5000);
  	driver.close();
  	
  	
}
}
