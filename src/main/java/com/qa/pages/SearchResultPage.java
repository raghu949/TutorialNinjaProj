package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.BaseClass;

public class SearchResultPage extends BaseClass{
	
	//WebDriver driver;
	
	@FindBy(xpath="(//a[@class=\"thumbnail\"])[1]")
	private WebElement firstImageWE;
	@FindBy(xpath="//button[contains(@class,\"mfp-arrow mfp-arrow-right mfp-prevent-close\")]")
	private WebElement nextImageBtnWE;
	@FindBy(xpath="//a[@class=\"thumbnail\"]")
	private List<WebElement> allImagesWE;
	@FindBy(xpath="//button[@class=\"mfp-close\"]")
	private WebElement closeBtnWE;
	@FindBy(id="button-cart")
	private WebElement cartBtnWE;
	@FindBy(xpath="//span[@id=\"cart-total\"]")
	private WebElement checkCartBtn;
	@FindBy(xpath="(//i[@class=\"fa fa-shopping-cart\"])[3]")
	private WebElement gotoCartPage;
	
	public SearchResultPage()
	{
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	public void clickOnfirstImage()
	{
		firstImageWE.click();
	}
	public List<WebElement> allImages()
	{
		return allImagesWE;
	}
	public WebElement imageCloseBtn()
	{
		return closeBtnWE;
	}
	public void imageCloseBtnWithoutMouse()
	{
		closeBtnWE.click();
	}
	public void clickOnNextImageBtn()
	{
		nextImageBtnWE.click();
	}
	public void clickOnAddcartBtn()
	{
		cartBtnWE.click();
	}
	public void clickOnCartBtn()
	{
		checkCartBtn.click();
	}
	public void clickOnGotoCart()
	{
		gotoCartPage.click();
	}
}
