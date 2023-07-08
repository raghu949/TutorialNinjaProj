package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class CartPage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(linkText="Checkout")
	private WebElement checkoutLinkText;
	
	public CartPage()
	{
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnCheckoutLinktext()
	{
		checkoutLinkText.click();
	}

}
