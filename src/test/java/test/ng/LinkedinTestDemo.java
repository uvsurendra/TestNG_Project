package test.ng;





import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.time.Duration;

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

public class LinkedinTestDemo {
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
		AssertJUnit.assertEquals(title, driver.getTitle());
		WebElement signinButton = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		wait.until(ExpectedConditions.visibilityOf(signinButton));
		signinButton.click();
		
	}
	
@Parameters ({"useName","passWord"})
@Test
public void inputData() throws InterruptedException {
	String title="LinkedIn Login, Sign in | LinkedIn";
	AssertJUnit.assertEquals(title, driver.getTitle());
	WebElement input=driver.findElement(By.name("session_key"));
	wait.until(ExpectedConditions.visibilityOf(input));
	input.sendKeys("userName");
	WebElement output=driver.findElement(By.id("password"));
	wait.until(ExpectedConditions.visibilityOf(output));
	output.sendKeys("passWord");
	 driver.findElement(By.linkText("Sign in")).click();
	Thread.sleep(5000);
}


	

@Test
public void signOut() throws InterruptedException{
	driver.findElement(By.id("ember18")).click();
	String title="(43) Feed | LinkedIn";
	Assert.assertEquals(title, driver.getTitle());
	
	WebElement signOut=driver.findElement(By.xpath("//a[@class='global-nav__secondary-link mv1'][contains(.,'Sign Out')]"));
	wait.until(ExpectedConditions.visibilityOf(signOut));
	signOut.click();
	Reporter.log("Excuted signOut Sucessfully ");
	
	
	
	driver.close();
	
	
}





}
