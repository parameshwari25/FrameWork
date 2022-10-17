package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreate {
	public ProductCreate (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement clickOnProductPage;
	@FindBy(className="detailedViewTextBox")
	private WebElement sendTexPoduct;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSave;
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement FetchtheTitleOfthePage;
	@FindBy(name="Delete")
	private WebElement ClickonDeletebutton;
	
	
	//getter method
	public WebElement getClickonDeletebutton() {
		return ClickonDeletebutton;
	}
	public WebElement getFetchtheTitleOfthePage() {
		return FetchtheTitleOfthePage;
	}
	public WebElement getClickOnProductPage() {
		return clickOnProductPage;
	}
	public WebElement getSendTexPoduct() {
		return sendTexPoduct;
	}
	public WebElement getClickOnSave() {
		return clickOnSave;
	}
	public void createPodct(String product) {
		clickOnProductPage.click();
		sendTexPoduct.sendKeys(product);
		clickOnSave.click();
		ClickonDeletebutton.click();
	
	
		
	}

}
