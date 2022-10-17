package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationFinal {
	public  CampaignCreationFinal(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement clickCreatePageC;
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement sendTextOrgName;
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement clickOnSave;
	public WebElement getClickCreatePageC() {
		return clickCreatePageC;
	}
	public WebElement getSendTextOrgName() {
		return sendTextOrgName;
	}
	public WebElement getClickOnSave() {
		return clickOnSave;
	}
	public void clickOnCreateCampaign() {
		clickCreatePageC.click();
	}
	public void createCampaign(String camp) {
		sendTextOrgName.sendKeys(camp);
		
		
		}
	public void saveCampaign() {
		clickOnSave.click();
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement fetchText;

	public WebElement getFetchText() {
		return fetchText;
	}
	/**
	 * click on product in campaign page
	 */
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement clickOnProduct;
	public WebElement getClickOnProduct() {
		return clickOnProduct;
	}
	public void clickOnProductInCamp(){
		clickOnProduct.click();
	}
}
