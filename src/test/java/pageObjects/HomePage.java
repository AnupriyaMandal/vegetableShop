package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@placeholder='Search for Vegetables and Fruits']")
	WebElement search;
	@FindBy(xpath="//div[@class='products']//div[1]//div[3]//button[1]")
	WebElement add_brocoli;
	@FindBy(xpath="//div[@class='products']//div[1]//div[3]//button[1]")
	WebElement add_cauliflower;
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cart;
	@FindBy(xpath="//div[@class='cart-preview active']//div//div//ul[@class='cart-items']")
	WebElement items;
	
	
	public void addVegetable1() {
		add_brocoli.click();
	}
	public void addVegetable2() {
		add_cauliflower.click();
	}
	public void checkCart() {
		cart.click();
	}
	public boolean checkItems() {
		List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class='cart-preview active']//div//div//ul[@class='cart-items']"));
		boolean result=cartItems.isEmpty();
		return result;
	}
}
