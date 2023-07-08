package com.qa.baseclass;
/*
 * This class will provide web driver for all other classes and
 * ptovide properties to other files
 */

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.pages.RegisterAccountPage;
import com.qa.utilities.ExtentManager;
import com.qa.utilities.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static Properties prop;// prop can be accessed from any other class 
	//Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	public static Properties testProp;// testProp can be accessed from any other class 
	
	//loadConfig method is to load the configuration
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig()
	{
		ExtentManager.setExtent();//Starting Report Class
		DOMConfigurator.configure("log4j.xml");
		propReadData();// Read Data from property Files
	}
	
	public void propReadData()
	{
		prop=new Properties();
		testProp=new Properties();
		File propFile =new File(System.getProperty("user.dir")+"//src//main//java//com//qa//impdata//ImpData.properties");
		File testFile=new File(System.getProperty("user.dir")+"//src//main//java//com//qa//testdata//testData.properties");
		try {
		FileInputStream fis=new FileInputStream(propFile);
		FileInputStream testFis=new FileInputStream(testFile);
		prop.load(fis);
		testProp.load(testFis);
		}catch(Exception e){e.printStackTrace();}
	}
	public static WebDriver getDriver() {
		//Get Driver from threadLocalmap
		return driver.get();
	}
	public void initializeBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//Set browser to ThradlocalMap
			driver.set(new ChromeDriver());
		}
			else if(browserName.equalsIgnoreCase("Edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver());
			}
			
			else if(browserName.equalsIgnoreCase("Safari"))
			{
				WebDriverManager.safaridriver().setup();
				driver.set(new SafariDriver());
			}
			else if(browserName.equalsIgnoreCase("FireFox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
			}
				
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICIT_WAIT_TIME));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.Page_Load_TIMEOUT));
		
		getDriver().get(prop.getProperty("url"));
			
		
		//return driver;
			
	}

	/*
	 * public void logintoApplication() { IndexPage indexPage=new IndexPage(driver);
	 * Utility.waitImplementationVisible(driver, indexPage.loginUidFun(),
	 * Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
	 * indexPage.loginUidFun().sendKeys(prop.getProperty("LoginUserId"));
	 * Utility.waitImplementationVisible(driver, indexPage.passwordFun(),
	 * Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
	 * indexPage.passwordFun().sendKeys(prop.getProperty("LoginPassword"));
	 * Utility.waitImplementation(driver, indexPage.btnLoginFun(),
	 * Duration.ofSeconds(Utility.WEBELEMENTWAITTIME));
	 * indexPage.btnLoginFun().click();
	 * 
	 * }
	 */
	@AfterSuite(groups= {"Smoke","Sanity","Regression"})
	public void closeBrowser()
	{
		ExtentManager.endReport();
	}

}
