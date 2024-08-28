package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ThirdPage extends BasePage {
	
	public WebDriver driver;

	public ThirdPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='wrapperTwo']//div//select")
	WebElement select_dropdown;
	@FindBy(xpath="//select")
	WebElement countries;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath="//button[normalize-space()='Proceed']")
	WebElement proceed_Btn;
	
	public void selectCountry() {
		
		Select sel=new Select(countries);
		sel.selectByVisibleText("India");
	}
	public void clickDropdown() {
		select_dropdown.click();
	}
	public String checkCountry() {
		String val=countries.getText();
		return val;
		
	}
	public void acceptTerms() {
		checkBox.click();
	}
	public void clickProceed() {
		proceed_Btn.click();
	}
}
