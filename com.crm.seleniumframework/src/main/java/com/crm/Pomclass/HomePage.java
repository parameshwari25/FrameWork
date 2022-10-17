package com.crm.Pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Declaration
		@FindBy(linkText="Organizations")
		private WebElement organizationMenu;
		
		@FindBy(linkText="Products")
		private WebElement productmenu;
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignmenu;
		
		@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
		private WebElement  moremenu;
//getter method
		public WebElement getOrganizationMenu() {
			return organizationMenu;
		}
		
		
		public WebElement getProductmenu() {
			return productmenu;
		}

		public WebElement getCampaignmenu() {
			return campaignmenu;
		}

		public WebElement getMoremenu() {
			return moremenu;
		}
		/*Business logic for organization
		 * @ author parameshwari
		 */
		
		public void createOrganization()
		{
			organizationMenu.click();
		}
		public void createprouduct()
		{
			productmenu.click();
		}
		public void createCampaignmenu()
		{
			campaignmenu.click();
		}
		public void clickMoremenu() 
		{
			moremenu.click();
			
		}
		
		
		//for logout
		@FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
		private WebElement ClickonIcon;
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement ClickonLogout;
		public WebElement getClickonIcon()
		{
			return ClickonIcon;
		}
		public WebElement getClickonLogout() {
			return ClickonLogout;
		}
   public void Logout()
   	{
	   ClickonIcon.click();
	   ClickonLogout.click();
   	}

				

		
}

		
 