package com.qa.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.qa.baseclass.BaseClass;
import com.qa.pages.HomePage;
import com.qa.utilities.Log;

public class HomePageTests extends BaseClass {
	
	//WebDriver driver;
	HomePage homePage;
	List <WebElement>allLinkElements;
	

	@Parameters("browser")
	@BeforeMethod
	public void StartTest(@Optional String browser)
	{
		initializeBrowser(browser);
	}
	@AfterMethod
	public void closeBrowserInstances()
	{
		System.out.println("I am closing");
		getDriver().quit();
	}
	@Test(priority=1)
	public void noofLinksInHomePage()
	{
		Log.startTestCase("No of Links in Website");
		readDataFromList();
		System.out.println(allLinkElements.size());
		Log.endTestCase("The total links are= "+allLinkElements.size());
	}
	public void readDataFromList()
	{
		homePage=new HomePage();
		allLinkElements = homePage.allLinksInHomePageFun();
		
	}
	@Test(priority=2)
	public void brokenLinksInHomePage() throws Exception
	{
		Log.startTestCase("Broken Links Test");
		int count=0;
		HttpURLConnection httpURLConnection=null;
		readDataFromList();
		for(int i=0;i<allLinkElements.size();i++)
		{
			WebElement link=allLinkElements.get(i);
			String url=link.getAttribute("href");
			URL urlLink=new URL(url);
			URLConnection urlConnection;
			
			try {
				urlConnection=urlLink.openConnection();
				httpURLConnection= (HttpURLConnection)urlConnection;
				httpURLConnection.connect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(httpURLConnection.getResponseCode()==200) {
							System.out.println(url+" - "+httpURLConnection.getResponseMessage());
							count++;
			}
			else {
				System.out.println(url+" - "+httpURLConnection.getResponseCode()+" - "+httpURLConnection.getResponseMessage());
			}
		}
		System.out.println("No of valid links are= "+count);
		httpURLConnection.disconnect();
		Log.endTestCase("Broken Links completed");
	}

}
