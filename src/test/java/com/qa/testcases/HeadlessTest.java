package com.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.baseclass.BaseClass;

public class HeadlessTest extends BaseClass {
	
	
	WebDriver driver;
	
	public HeadlessTest()
	{
		super();
	}
	
	@BeforeTest
	public void Start()
	{
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(true);
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://stackoverflow.com/");
	}
	@AfterTest
	public void CloseBrowserInstance()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void didplayTitleHeadless()
	{
		System.out.println(driver.getTitle());
	}

}
