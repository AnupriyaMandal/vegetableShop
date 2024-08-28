package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.SecondPage;
import testBase.BaseClass;

public class TC_002_FinalCart extends BaseClass{
	
	public SecondPage sp;
	
	@Test(groups="Master")
	public void verifyCart() {
	sp=new SecondPage(driver);
	BaseClass.logger.info("****opening page****");
	logger.info("****Preview of orders*****");
	boolean val=sp.previewOrder();
	Assert.assertEquals(val, true);
	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	sp.Proceed();
	BaseClass.logger.info("****Going to next page*****");
	
	}

}
