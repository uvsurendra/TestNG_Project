package testngbasicprograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {
	private WebDriver driver;
    public void browserLaunching(String browserName) {
    	if(browserName.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
    		
    	}
    	else if(browserName.equalsIgnoreCase("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    	}
    	else if(browserName.equalsIgnoreCase("ie")) {
    		WebDriverManager.iedriver().setup();
    		driver=new InternetExplorerDriver();
    	}
    }
}
