package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class AddressBookHomePage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(linkText="New Address")
	private WebElement newAddressLinkWE;
	
	
	AddressBookHomePage()
	{
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddAddressPage clickOnNewAddressBtn()
	{
		newAddressLinkWE.click();
		return new AddAddressPage();
	}
	
	
}
