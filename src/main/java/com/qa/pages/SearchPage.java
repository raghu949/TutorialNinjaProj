package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class SearchPage extends BaseClass {
	
	//WebDriver driver;
	@FindBy(name="search")
	private WebElement searchWE;
	@FindBy(xpath="//button[@class=\"btn btn-default btn-lg\"]")
	private WebElement searchBtnWE;
	@FindBy(xpath="//div[@class=\"caption\"]//a")
	private WebElement samsungResultLinkWE;
	public SearchPage()
	{
		//this.driver=driver;
		
		PageFactory.initElements(getDriver(), this);
		
				
	}
	public void enterProductInSearch(String prdName)
	{
		searchWE.sendKeys(prdName);
	}
	public void clickOnSearchBtn()
	{
		searchBtnWE.click(); 
	}
	public SearchResultPage clickOnProductName()
	{
		samsungResultLinkWE.click();
		return new SearchResultPage();
	}
	public boolean statusOfSamsungLinkText()
	{
		return samsungResultLinkWE.isDisplayed();
	}

}
