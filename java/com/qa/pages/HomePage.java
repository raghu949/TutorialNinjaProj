package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()=\"My Account\"]")
	private WebElement myAccountWE;
	@FindBy(linkText="Register")
	private WebElement registerLinkWE;
	@FindBy(linkText="Login")
	private WebElement loginLinkWE;
	@FindBy(xpath="//a")
	private List<WebElement> allLinksInHomePage;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void myAccountWE()
	{
		myAccountWE.click();;
	}
	public RegisterAccountPage registerLinkWE()
	{
		registerLinkWE.click();
		return new RegisterAccountPage(driver);
	}
	public LoginPage loginLinkWE()
	{
		loginLinkWE.click();
		return new LoginPage(driver);
	}
	public List allLinksInHomePageFun()
	{
		return allLinksInHomePage;
	}
	
}
