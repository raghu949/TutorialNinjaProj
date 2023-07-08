package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class AddAddressPage extends BaseClass{
	
	//WebDriver driver;
	
	@FindBy(name="firstname")
	private WebElement firstnameWE;
	@FindBy(name="lastname")
	private WebElement lastnameWE;
	@FindBy(name="company")
	private WebElement companyWE;
	@FindBy(name="address_1")
	private WebElement address_1WE;
	@FindBy(name="address_2")
	private WebElement address_2WE;
	@FindBy(name="city")
	private WebElement cityWE;
	@FindBy(name="postcode")
	private WebElement postcodeWE;
	@FindBy(id="input-country")
	private WebElement countryWE;
	@FindBy(id="input-zone")
	private WebElement regionWE;
	@FindBy(name="default")
	private WebElement defaultWE;
	@FindBy(xpath="//input[@value=\"Continue\"]")
	private WebElement addAddressContinueBtn;
	
	
	
	AddAddressPage()
	{
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void firstnameWE(String fn)
	{
		firstnameWE.sendKeys(fn);
		
	}

	public void lastnameWE(String ln)
	{
		lastnameWE.sendKeys(ln);
		
	}
	public void companyWE(String cmpname)
	{
		companyWE.sendKeys(cmpname);
		
	}
	public void address_1WE(String address1)
	{
		address_1WE.sendKeys(address1);
		
	}
	public void address_2WE(String address2)
	{
		address_2WE.sendKeys(address2);
		
	}
	public void cityWE(String city)
	{
		cityWE.sendKeys(city);
		
	}
	public void postcodeWE(String pin)
	{
		postcodeWE.sendKeys(pin);
		
	}
	public WebElement countryWE()
	{
		return countryWE;
		
	}
	public WebElement regionWE()
	{
		return regionWE;
		
	}
	public void defaultWE()
	{
		defaultWE.click();
		
	}
	public ModifyAddressBookPage clickOnContinueBtn()
	{
		addAddressContinueBtn.click();
		return new ModifyAddressBookPage();
	}
	
	
}
