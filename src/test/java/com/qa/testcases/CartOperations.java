package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.LoginSuccessPage;
import com.qa.pages.RegisterAccountPage;
import com.qa.pages.SearchResultPage;
import com.qa.utilities.Log;

public class CartOperations extends BaseClass{
	
	//WebDriver driver;
	

	@Parameters("browser")
	@BeforeMethod
	public void startCartOperations(@Optional String browser)
	{
		initializeBrowser(browser);
		HomePage homePage=new HomePage();
		homePage.myAccountWE();
		LoginPage loginPage = homePage.loginLinkWE();
		loginPage.emailWE(testProp.getProperty("validUserName"));
		loginPage.passwordWE(testProp.getProperty("validPassword"));
		LoginSuccessPage loginSuccessPage = loginPage.clickOnContinueBtn();
		SearchResultPage searchResultPage=new SearchResultPage();
		searchResultPage.clickOnCartBtn();
		searchResultPage.clickOnGotoCart();
	}
	@AfterMethod
	public void closeBrowserInstances()
	{
		getDriver().quit();
	}
	@Test(priority=1, dependsOnMethods="searchAProduct()")
	public void removeProductFromCart() throws Exception
	{
		Log.startTestCase("Remove Product from Cart");
		//String str1="//a[text()=";
		String str2=testProp.getProperty("deleteProductName");
		//String str3="]/ancestor::tr//td[4]//button[@class=\"btn btn-danger\"]";
		getDriver().findElement(By.xpath("//table[@class=\"table table-bordered\"]//a[text()="+"\""+str2+"\"]/ancestor::tr//td[4]//button[@class=\"btn btn-danger\"]")).click();
		Log.endTestCase("Removed a Product from Cart");
		
	}

}
