package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class AccRegisterSuccessPage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(linkText="Success")
	private WebElement SuccessWE;
	/*@FindBy(name="selaccount")
	private WebElement selectAccountWE;
	@FindBy(name="inideposit")
	private WebElement intialDepositWE;
	@FindBy(name="button2")
	private WebElement newAccountSubmittBtnWE;
	@FindBy(id="message14")
	private WebElement customerIdErrorMsgWE;
	@FindBy(id="message19")
	private WebElement intialDepositErrorMsgWE;
	
	
	*/
	AccRegisterSuccessPage()
	{
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean SuccessPageStatus()
	{
		return SuccessWE.isDisplayed();
	}
	/*public WebElement selectAccountWE()
	{
		return selectAccountWE;
	}
	public WebElement intialDepositWE()
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
