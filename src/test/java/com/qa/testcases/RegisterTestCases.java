package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.AccRegisterSuccessPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.LoginSuccessPage;
import com.qa.pages.RegisterAccountPage;
import com.qa.utilities.Log;
import com.qa.utilities.Utility;

public class RegisterTestCases extends BaseClass {
	
	//WebDriver driver;
	RegisterAccountPage registerAccountPage;
	AccRegisterSuccessPage accountSuccessPage;
	LoginPage loginPage;
	LoginSuccessPage loginSuccessPage;
	
	//@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void startWithRegister()//String browser)
	{
		initializeBrowser("Chrome");
		HomePage homePage=new HomePage();
		homePage.myAccountWE();
		registerAccountPage=new RegisterAccountPage();
		registerAccountPage=homePage.registerLinkWE();
		System.out.println("The test started");
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().close();
	}
	
	@Test(priority=1,dataProvider="supplyRegistrationData")
	public void registerAccountWithManadatoryFields(String fName,String lName,String email,String tele,String pwd,String cnfrpwd,String newsletter,String privacyPolicy)
	{
		Log.startTestCase("Registration Test");
		registerAccountPage.firstname(fName);
		registerAccountPage.lastname(lName);
		registerAccountPage.email(email);
		registerAccountPage.telephone(tele);
		registerAccountPage.password(pwd);
		registerAccountPage.confirm(cnfrpwd);
		registerAccountPage.yes(newsletter);
		registerAccountPage.agree(privacyPolicy);
		accountSuccessPage=registerAccountPage.clickOnContinueBtn();
		Assert.assertTrue(accountSuccessPage.SuccessPageStatus(), "Login Failed");
		Log.endTestCase("Registration Test");
	}
	
	@DataProvider(name="supplyRegistrationData")
	public Object[][] supplyRegisterPageData()
	{
		Object myRegData[][]=Utility.readRegisterDataFromExcel("RegisterData");
		return myRegData;
	}
	

}
