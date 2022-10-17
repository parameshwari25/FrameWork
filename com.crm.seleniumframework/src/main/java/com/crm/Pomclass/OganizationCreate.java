package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OganizationCreate  {
	//initialization
		public OganizationCreate(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Declaration
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement clickCreatePage;
		@FindBy(xpath="//input[@name='accountname']")
		private WebElement sendTexOrgname;
		@FindBy(name="button")
		private WebElement clickOnSave;
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement FetchtheTit;
		
		public WebElement getFetchtheTit() {
			return FetchtheTit;
		}
		//getter method
		public WebElement getClickCreatePage() {
			return clickCreatePage;
		}
		public WebElement getSendTexOrgname() {
			return sendTexOrgname;
		}
		public WebElement getClickOnSave() {
			return clickOnSave;
		}
		 
		public void  createorganization(String org) {
			clickCreatePage.click();
			sendTexOrgname.sendKeys(org);
			clickOnSave.click();
			FetchtheTit.click();
		}
		
	
		

		

		
		

}
