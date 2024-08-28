package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondPage extends BasePage {

public WebDriver driver;

	public SecondPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='products']")
	WebElement product_table;
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	WebElement Btn_proceed;
	
	public boolean  previewOrder() {
		boolean flag=product_table.isDisplayed();
		return flag;
		
	}
	public void Proceed() {
		
		Btn_proceed.click();
	}
}
