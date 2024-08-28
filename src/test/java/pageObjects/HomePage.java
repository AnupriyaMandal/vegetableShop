package pageObjects;


import java.util.ArrayList;
import java.util.Iterator;
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
	@FindBy(xpath="//button[@type='button'][normalize-space()='ADD TO CART']")
	List<WebElement> allVegetables;
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cart;
	@FindBy(xpath="//div[@class='cart-preview active']//div//div//ul[@class='cart-items']")
	List<WebElement> items;
	@FindBy(xpath="//button[normalize-space()='PROCEED TO CHECKOUT']")
	WebElement btn_Checkout;
	@FindBy(xpath="//div[@class='brand greenLogo']")
	WebElement logo;
	
	
	
	public void addVegetbales() {
		ArrayList<WebElement> myList=new ArrayList<WebElement>();
		myList.addAll(allVegetables);
		Iterator<WebElement> it=myList.iterator();
		while(it.hasNext()) {
			it.next().click();
		}
		
	}
	public void checkCart() {
		cart.click();
	}
	public boolean checkItems() {
		boolean result=items.isEmpty();
		return result;
	}
	public void checkout() {
		btn_Checkout.click();
	}
	public String checkLogo() {
		String image=logo.getText();
		return image;
	}
}
