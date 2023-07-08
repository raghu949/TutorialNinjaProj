package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	
	//WebDriver driver;
	
	@FindBy(name="email")
	private WebElement emailWE;
	@FindBy(name="password")
	private WebElement passwordWE;
	@FindBy(xpath="//input[@value=\"Login\"]")
	private WebElement loginWE;
	
	
	public LoginPage()
	{
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void emailWE(String emailTxt)
	{
		emailWE.sendKeys(emailTxt);
	}
	public void passwordWE(String passwordTxt)
	{
		passwordWE.sendKeys(passwordTxt);
	}

	
	public LoginSuccessPage clickOnContinueBtn()
	{
		loginWE.click();
		return new LoginSuccessPage();
	}
}
