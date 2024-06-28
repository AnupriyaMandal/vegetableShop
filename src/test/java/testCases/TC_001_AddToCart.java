package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AddToCart extends BaseClass {

	public HomePage hp;
	
	@Test(groups="Master")
	public void verify_productAdded() {
		
		try {
		logger.info("******Adding vegetables to the cart******");
		hp=new HomePage(driver);
		hp.addVegetable1();
		hp.addVegetable2();
		hp.checkCart();
		boolean value=hp.checkItems();
		Assert.assertEquals(value, true);}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
