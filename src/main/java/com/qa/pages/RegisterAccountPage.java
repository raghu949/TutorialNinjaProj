package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class RegisterAccountPage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(name="firstname")
	private WebElement firstnameWE;
	@FindBy(name="lastname")
	private WebElement lastnameWE;
	@FindBy(name="email")
	private WebElement emailWE;
	@FindBy(name="telephone")
	private WebElement telephoneWE;
	@FindBy(name="password")
	private WebElement passwordWE;
	@FindBy(name="confirm")
	private WebElement confirmWE;
	@FindBy(xpath="//input[@name=\"newsletter\"][@value=\"1\"]")
	private WebElement yesWE;
	@FindBy(xpath="//input[@name=\"newsletter\"][@value=\"0\"]")
	private WebElement NoWE;
	@FindBy(name="agree")
	private WebElement agreeWE;
	@FindBy(xpath="//input[@value=\"Continue\"]")
	private WebElement btnLoginWE;
	
	public RegisterAccountPage()
	{
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void firstname(String firstNameTxt)
	{
		firstnameWE.sendKeys(firstNameTxt);
	}
	public void lastname(String lastNameTxt)
	{
		lastnameWE.sendKeys(lastNameTxt);
	}
	public void email(String emailTxt)
	{
		emailWE.sendKeys(emailTxt);
	}
	public void telephone(String telephoneText)
	{
		telephoneWE.sendKeys(telephoneText);
	}
	public void password(String passwordText)
	{
		passwordWE.sendKeys(passwordText);
	}
	public void confirm(String confirmTxt)
	{
		confirmWE.sendKeys(confirmTxt);
	}
	public void yes(String yesNewsletter)
	{
		if(yesNewsletter.equalsIgnoreCase("Yes"))
		yesWE.click();
		else
			NoWE.click();
	}
	public void agree(String agreeText)
	{
		if(agreeText.equalsIgnoreCase("Yes"))
		agreeWE.click();
	}
	public AccRegisterSuccessPage clickOnContinueBtn()
	{
		btnLoginWE.click();
		return new AccRegisterSuccessPage();
	}
}
