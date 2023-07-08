package com.qa.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.baseclass.BaseClass;

public class ListenerClass extends ExtentManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		test.log(Status.PASS, "Pass Test Case is: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" -Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" -Test Case Failed", ExtentColor.RED));
			String imgPath=Utility.screenShot(BaseClass.getDriver(), result.getName());
			test.fail("ScreenShot is Attached",MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP)
			test.log(Status.SKIP, "Skipped Test Case is: "+result.getName());
	}

	

	
	
}
