package com.qa.testcases;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.AddAddressPage;
import com.qa.pages.AddressBookHomePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.LoginSuccessPage;
import com.qa.pages.ModifyAddressBookPage;
import com.qa.utilities.Log;
import com.qa.utilities.Utility;

public class AddAddress extends BaseClass {
	
	//WebDriver driver;
	LoginPage loginPage;
	LoginSuccessPage loginSuccessPage;
	AddressBookHomePage addressBookHomePage;
	AddAddressPage addAddressPage;
	ModifyAddressBookPage modifyAddressBookPage;
	

	@Parameters("browser")
	@BeforeMethod
	public void startTesting(@Optional String browser)
	{
		initializeBrowser(browser);
		homePageToLogin();
	}
	public void homePageToLogin()
	{
		HomePage homePage=new HomePage();
		homePage.myAccountWE();
		homePage.loginLinkWE();
		loginPage=new LoginPage();
		loginPage.emailWE(testProp.getProperty("validUserName"));
		loginPage.passwordWE(testProp.getProperty("validPassword"));
		loginSuccessPage=loginPage.clickOnContinueBtn();
	}
	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
	}
	@Test(priority=1)
	public void verifyAddAddress() throws Exception
	{
		Log.startTestCase("Verify and Add Address");
		addressBookHomePage=loginSuccessPage.clickOnAddAdressBookLinkWE();
		addAddressPage=addressBookHomePage.clickOnNewAddressBtn();
		addAddressPage.firstnameWE(testProp.getProperty("firstName1"));
		addAddressPage.lastnameWE(testProp.getProperty("lastName1"));
		addAddressPage.companyWE(testProp.getProperty("company"));
		addAddressPage.address_1WE(testProp.getProperty("Address1"));
		addAddressPage.address_2WE(testProp.getProperty("Address2"));
		addAddressPage.cityWE(testProp.getProperty("City"));
		addAddressPage.postcodeWE(testProp.getProperty("pin"));
		Utility.selectOptionFromDropDown(addAddressPage.countryWE(), "India");
		Utility.selectOptionFromDropDown(addAddressPage.regionWE(), "Andhra Pradesh");
		addAddressPage.defaultWE();
		modifyAddressBookPage=addAddressPage.clickOnContinueBtn();
		Assert.assertTrue(modifyAddressBookPage.statusOfEditBtn(), "Contact not Saved on AddressBook");
		Log.endTestCase("Address added");
	}
	

}
