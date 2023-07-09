package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
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

public class LoginTestCase extends BaseClass {
	
	//WebDriver driver;
	RegisterAccountPage registerAccountPage;
	AccRegisterSuccessPage accountSuccessPage;
	LoginPage loginPage;
	LoginSuccessPage loginSuccessPage;
	
	@Parameters("browser")
	@BeforeMethod()
	public void startWithRegister(@Optional String browser)
	{
		initializeBrowser(browser);
		HomePage homePage=new HomePage();
		homePage.myAccountWE();
		homePage.loginLinkWE();
	}
	@AfterMethod
	public void tearDown()
	{
		
		getDriver().quit();
	}
	
	@Test(priority=1)//,dataProvider="supply Login Data")
	public void verifyLoginWithExcel()//String email,String pwd)
	{
		Log.startTestCase("Login Test Started");
		loginPage=new LoginPage();
		Log.info("Enter valid Email");
		loginPage.emailWE(prop.getProperty("validEmail"));
		Log.info("Enter valid Password");
		loginPage.passwordWE(prop.getProperty("validPassword"));
		Log.info("Click on Login Button");
		loginSuccessPage=loginPage.clickOnContinueBtn();
		Assert.assertTrue(loginSuccessPage.editAccSuccessPageStatus(), "Login Failed");
		Log.endTestCase("Login Test Compeleted");
	}
	
	@Test(priority=2)//,dataProvider="supply Login Data")
	public void verifyLoginWithInvalidPassword()//String email,String pwd)
	{
		Log.startTestCase("Login Test with Invalid Password Started");
		loginPage=new LoginPage();
		Log.info("Enter valid Email");
		loginPage.emailWE(prop.getProperty("validEmail"));
		Log.info("Enter valid Password");
		loginPage.passwordWE(prop.getProperty("inValidPassword"));
		Log.info("Click on Login Button");
		loginSuccessPage=loginPage.clickOnContinueBtn();
		Assert.assertTrue(loginPage.warningMessage(), testProp.getProperty("loginFailedMessage"));
		Log.endTestCase("Login Test Compeleted");
	}

	/*@DataProvider(name="supply Login Data")
	public Object[][] supplyLoginData()
	{
		Object myLoginData[][]=Utility.readLoginDataFromExcel("LoginData");
		return myLoginData;
	}*/

}
