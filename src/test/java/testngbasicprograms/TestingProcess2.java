package testngbasicprograms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestingProcess2 {
	 @Test(groups = "smokeTest")
	  public void smokeTest3() {
		  Reporter.log("excuted sucessfully smokeTest3");
	  }
	  @Test(groups = "smokeTest")
	  public void smokeTest4() {
		  Reporter.log("excuted sucessfully smokeTest4");
	  }
	  @Test(groups = "regressionTest")
	  public void regressionTest1() {
		  Reporter.log("excuted sucessfully regressionTest3");
	  }
	  @Test(groups = "regressionTest")
	  public void regressionTest2() {
		  Reporter.log("excuted sucessfully regressionTest4");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  Reporter.log("Excuted Sucessfully Before Method");
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  Reporter.log("Excuted Sucessfully AfterMethod");
		  
	  }

	  @BeforeClass
	  public void beforeClass() {
		  Reporter.log("Excuted Sucessfully Before class ");
	  }

	  @AfterClass
	  public void afterClass() {
		  Reporter.log("Excuted Sucessfully After Class");
	  }

	}

