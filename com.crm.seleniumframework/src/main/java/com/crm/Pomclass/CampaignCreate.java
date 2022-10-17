package com.crm.Pomclass;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


	public class CampaignCreate
 {	
		
		public CampaignCreate (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
		@FindBy(name="Campaigns")
		private WebElement newcampaigns;
		
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	     private WebElement createcampaigns;
		@FindBy(name="campaignname")
		private WebElement campaignname ;
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement FetchtheTitleofthepage;
		@FindBy(name="button")
		private WebElement savebutton ;

		public WebElement getNewcampaigns() {
			return newcampaigns;
		}


		public WebElement getCreatecampaigns() {
			return createcampaigns;
		}
		public WebElement getCampaignname() {
			return campaignname;
		}
		public WebElement getSavebutton() {
			return savebutton;
		}
		public WebElement getFetchtheTitleofthepage() {
			return FetchtheTitleofthepage;
		}

		public void campaign()
		{
			newcampaigns.click();
			createcampaigns.click();
		}
		public void entercampaign(String data)
		{
			campaignname.sendKeys(data);
			savebutton.click();
			FetchtheTitleofthepage.click();

		



		}

		}
	


