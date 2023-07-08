package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class ModifyAddressBookPage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(linkText="Edit")
	private WebElement editAddressLinkWE;
	
	
	ModifyAddressBookPage()
	{
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	public boolean statusOfEditBtn()
	{
		return editAddressLinkWE.isDisplayed();
	}
	
	public void clickOnEditAddressBtn()
	{
		editAddressLinkWE.click();
		//return new AddAddressPage(driver);
	}
	
	
}
