package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Checkout")
	private WebElement checkoutLinkText;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCheckoutLinktext()
	{
		checkoutLinkText.click();
	}

}
