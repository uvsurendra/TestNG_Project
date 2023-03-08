package testngbasicprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookDemo {
	public WebDriver driver;
	public WebDriverWait wait;
	
     
	@BeforeClass
	public void faceBook() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.facebook.com/");
		wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	}
	@Test
	public void loginFaceBook() {
		String title ="pageTitle";
		wait.until(ExpectedConditions.titleContains(title));
		//Assert.assertEquals(title, driver.getTitle(), "Login Page is not Avaiable");
		WebElement emailEditBox=driver.findElement(By.name("email"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		
		Actions ac=new Actions(driver);
		ac.click(emailEditBox).perform();
		ac.keyDown(Keys.SHIFT).perform();
		ac.sendKeys(emailEditBox,"surendravenkat5@gmail.com").perform();
		ac.keyUp(Keys.SHIFT).perform();
		//Action vi = ac.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
		WebElement passWordBox=driver.findElement(By.name("pass"));
		ac.click(passWordBox).perform();
		ac.sendKeys(passWordBox,"Surendra@577").perform();
		driver.findElement(By.xpath("//button[@id='u_0_9_MZ']")).click();
		
		driver.close();
	}
}
