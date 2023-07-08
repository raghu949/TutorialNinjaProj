package com.qa.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;
import com.qa.pages.SearchPage;
import com.qa.pages.SearchResultPage;
import com.qa.utilities.Log;

public class LoginAndSearchPrd extends BaseClass {
	
	//WebDriver driver;
	AddAddress addAddress;
	

	@Parameters("browser")
	@BeforeMethod
	public void startLoginAndSearch(@Optional String browser)
	{
		initializeBrowser(browser);
		addAddress=new AddAddress();
		addAddress.homePageToLogin();
		
	}
	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
	}
	@Test(priority=1)
	public void searchAProduct() throws Exception
	{
		Log.startTestCase("Search Product Test started");
		SearchPage searchPage=new SearchPage();
		searchPage.enterProductInSearch(testProp.getProperty("prd1"));
		searchPage.clickOnSearchBtn();
		SearchResultPage searchPageResult=searchPage.clickOnProductName();
		searchPageResult.clickOnfirstImage();
		List<WebElement> allImageso=searchPageResult.allImages();
		for(int i=1;i<allImageso.size();i++)
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));
			searchPageResult.clickOnNextImageBtn();
		}
		searchPageResult.imageCloseBtnWithoutMouse();
		searchPageResult.clickOnAddcartBtn();
		//Actions act=new Actions(driver);
		//act.click(searPageResult.imageCloseBtn()).build().perform();
		searchPageResult.clickOnCartBtn();
		searchPageResult.clickOnGotoCart();
		Thread.sleep(5000);
		//Assert.assertTrue(searchPage.statusOfSamsungLinkText(),"No Product on this Text");
		Log.endTestCase("Search a Product is completed");
	}

}
