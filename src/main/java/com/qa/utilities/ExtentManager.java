package com.qa.utilities;
/*
 * This Extent Manager class is used to prepare html reports for Project
 */
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlReporter.config().setDocumentTitle("Page Object Model Report");
		htmlReporter.config().setReportName("Automation Report of Page Object Model");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "Page Object Model");
		extent.setSystemInfo("Tester", "Raghu Ram N");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}

}
