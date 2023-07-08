package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class LoginSuccessPage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountWE;
	@FindBy(linkText="Address Book")
	private WebElement addressBookLinkWE;
	/*@FindBy(name="inideposit")
	private WebElement intialDepositWE;
	@FindBy(name="button2")
	private WebElement newAccountSubmittBtnWE;
	@FindBy(id="message14")
	private WebElement customerIdErrorMsgWE;
	@FindBy(id="message19")
	private WebElement intialDepositErrorMsgWE;
	
	
	*/
	LoginSuccessPage()
	{
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean editAccSuccessPageStatus()
	{
		return editAccountWE.isDisplayed();
	}
	public AddressBookHomePage clickOnAddAdressBookLinkWE()
	{
		addressBookLinkWE.click();
		return new AddressBookHomePage();
	}
	/*public WebElement intialDepositWE()
	{
		return intialDepositWE;
	}
	public void clickOnSubmittBtn()
	{
		newAccountSubmittBtnWE.click();;
	}
	public WebElement customerIdErrorMsgWE()
	{
		return customerIdErrorMsgWE;
	}
	public WebElement intialDepositErrorMsgWE()
	{
		return intialDepositErrorMsgWE;
	}
	*/
}
