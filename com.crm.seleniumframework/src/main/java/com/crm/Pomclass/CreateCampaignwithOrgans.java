package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignwithOrgans {
	//initialization
	public CreateCampaignwithOrgans(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(linkText="Products")
	private WebElement ClickOnProductlinkNew;
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement ProductPlusNew;
	@FindBy(name="productname")
	private WebElement ImpProductNameNew;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveProductNew;
	
	//navigate to campaign
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement ClickCampaignlinkNew;
	@FindBy(linkText="Campaigns")
	private WebElement ClickOnCampaignNew;
	@FindBy(xpath=("//img[@alt='Create Campaign...']"))
	private WebElement ClickCreateCampaignNew;
	@FindBy(name="campaignname")
	private WebElement CampExceldataNew;
	@FindBy(xpath="//img[@title='Select']")
	private WebElement CampSelectNew;
	
	//new window
	@FindBy(id="search_txt")
	private WebElement PassingproduValNew;
	@FindBy(name="search")
	private WebElement ClickSearchButtonNew;
	
	//dynamic
	//@FindBy (xpath=("//a[text()='"+productdata+"']")
	//tprivate WebElement ProductDataClick;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement ClickProductCamSaveNew;
	
	
	//getter method
	
	public WebElement getClickOnProductlinkNew() {
		return ClickOnProductlinkNew;
	}


	public WebElement getProductPlusNew() {
		return ProductPlusNew;
	}


	public WebElement getImpProductNameNew() {
		return ImpProductNameNew;
	}


	public WebElement getSaveProductNew() {
		return SaveProductNew;
	}


	public WebElement getClickCampaignlinkNew() {
		return ClickCampaignlinkNew;
	}


	public WebElement getClickOnCampaignNew() {
		return ClickOnCampaignNew;
	}


	public WebElement getClickCreateCampaignNew() {
		return ClickCreateCampaignNew;
	}


	public WebElement getCampExceldataNew() {
		return CampExceldataNew;
	}


	public WebElement getCampSelectNew() {
		return CampSelectNew;
	}


	public WebElement getPassingproduValNew() {
		return PassingproduValNew;
	}


	public WebElement getClickSearchButtonNew() {
		return ClickSearchButtonNew;
	}


	public WebElement getClickProductCamSaveNew() {
		return ClickProductCamSaveNew;
	}
	

	
	
	//Business logic
	public void productAndcamp(String Procamp)
	{
		ClickOnProductlinkNew.click();
		ProductPlusNew.click();
		ImpProductNameNew.sendKeys(Procamp);
		SaveProductNew.click();
		ClickCampaignlinkNew.click();
		
		
	}


	
	
	
	
	
	

}
