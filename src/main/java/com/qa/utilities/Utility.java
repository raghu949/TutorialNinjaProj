package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int Page_Load_TIMEOUT=15;
	public static final int WEBELEMENTWAITTIME=30;
	
	public static void waitImplementation(WebDriver driver,WebElement ele, Duration waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	public static String readWarningMessage(WebElement ele)
	{
		String strErrorMessage=ele.getText();
		return strErrorMessage;
	}
	public static void waitImplementationVisible(WebDriver driver,WebElement ele, Duration waitTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public static Object[][] readRegisterDataFromExcel(String sheetName)
	{
		File excelFile=new File(System.getProperty("user.dir")+"//src//main//java//com//qa//testdata//TutorialNinjaRegisterData.xlsx");
		FileInputStream fisexcel;
		XSSFWorkbook wrkb=null;
		try {
			fisexcel=new FileInputStream(excelFile);
			wrkb=new XSSFWorkbook(fisexcel);
		} catch (Exception e) {
						e.printStackTrace();
		}
		XSSFSheet wrksheet=wrkb.getSheet(sheetName);
		XSSFCell cell;
		int rows=wrksheet.getLastRowNum();
		int cols=wrksheet.getRow(0).getLastCellNum();
		Object REData[][] =new Object[rows][cols] ;
		System.out.println(rows+"  "+cols);
		for(int i=0;i<rows;i++)
		{
			XSSFRow row=wrksheet.getRow(i+1);
			for(int j=0;j<cols;j++)
			{
				cell=row.getCell(j);
				
				switch(cell.getCellType())
				{
					case STRING:
						REData[i][j]=cell.getStringCellValue();
						break;
					case NUMERIC:
						REData[i][j]=Integer.toString((int)cell.getNumericCellValue());
						break;
					case BOOLEAN:
						REData[i][j]=cell.getBooleanCellValue();
						break;
				}
			}
		}
		
		
		return REData;
	}
	public static void selectOptionFromDropDown(WebElement ele, String opt)
	{
		Select selOpt=new Select(ele);
		selOpt.selectByVisibleText(opt);
		
	}
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = filename + "_" + dateName + ".png";//"http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				//+ dateName + ".png";
		return newImageString;
	}

}
