package testngbasicprograms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestingProcess {
  @Test(groups = "smokeTest")
  public void smokeTest1() {
	  Reporter.log("excuted sucessfully smokeTest1");
  }
  @Test(groups = "smokeTest")
  public void smokeTest2() {
	  Reporter.log("excuted sucessfully smokeTest2");
  }
  @Test(groups = "regressionTest")
  public void regressionTest1() {
	  Reporter.log("excuted sucessfully regressionTest1");
  }
  @Test(groups = "regressionTest")
  public void regressionTest2() {
	  Reporter.log("excuted sucessfully regressionTest2");
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
	  Reporter.log("Excuted Sucessfully Before Class");
  }

  @AfterClass
  public void afterClass() {
	  Reporter.log("Excuted Sucessfully Afterclass");
  }

}
