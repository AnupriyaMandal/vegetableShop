package testCases;





import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SecondPage;
import testBase.BaseClass;

public class TC_001_AddToCart extends BaseClass {

	public HomePage hp;
	
	
	@Test(groups="Master")
	public void verify_productAdded() {
		
		hp=new HomePage(driver);
		logger.info("******Adding vegetables to the cart******");
		hp.addVegetbales();
		logger.info("*****All Vegetables added******");
		hp.checkCart();
		boolean value=hp.checkItems();
		Assert.assertEquals(value, false);
		hp.checkout();
		
		
		
	}

}
