package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ThirdPage;
import testBase.BaseClass;

public class TC_003_AddressDets extends BaseClass {
	
	public ThirdPage tp;
	public HomePage hp;
	
	@Test(groups="Master")
	public  void verify() {
		tp=new ThirdPage(driver);
		tp.clickDropdown();
		tp.selectCountry();
		BaseClass.logger.info("******Country selected as India*******");
		tp.acceptTerms();
		BaseClass.logger.info("****Accepting terms and conditions*****");
		tp.clickProceed();
		BaseClass.logger.info("****Order Placed.*****");
		hp=new HomePage(driver);
		String logo_confirm=hp.checkLogo();
		Assert.assertEquals(logo_confirm, "GREENKART");
		

	}
	

}
