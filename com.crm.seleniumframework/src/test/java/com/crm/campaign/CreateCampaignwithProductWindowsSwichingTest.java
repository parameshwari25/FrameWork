package com.crm.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericUtilities.Excelutiliy;
import com.crm.GenericUtilities.FilUility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Pomclass.CampaignCreate;
import com.crm.Pomclass.CampaignCreationFinal;
import com.crm.Pomclass.HomePage;
import com.crm.Pomclass.Loginpage;
import com.crm.Pomclass.ProductCreate;
import com.crm.Pomclass.ProductinNewWindow;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProductWindowsSwichingTest {
	public static void main(String[] args) throws Throwable  {

		FilUility flib=new FilUility();
		String Browser=flib.getProperty("browser");
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
 		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		{
		
			String URL = flib.getProperty("url");
			String username = flib.getProperty("un");
			String pswd = flib.getProperty("pw");
			
			WebdriverUtility webdriver=new WebdriverUtility();
			//FilUility file=new FilUility();
			JavaUtility ju=new JavaUtility();
			int RanNum=ju.getRanDomNum();
			Excelutiliy ex=new Excelutiliy();
			
			webdriver.waitForpageToLoad(driver);
			driver.manage().window().maximize();
			driver.get(URL);
			
			String exceldata=ex.getDataFormatExcel("Sheet1", 0, 1)+RanNum;
			System.out.println(exceldata);
			
			Loginpage login=new Loginpage(driver);
			login.login(username, pswd);
			HomePage home=new HomePage(driver);
			home.createprouduct();
			ProductCreate product=new ProductCreate(driver);
			product.createPodct(exceldata);
			//String actualdata=product.getFetchtheTitleOfthePage().getText();
			//home.clickMoremenu();
			CampaignCreationFinal crea=new CampaignCreationFinal(driver);
			crea.clickOnCreateCampaign();
			home.createCampaignmenu();
			
		    
		    //campaign name input

			Excelutiliy elib1=new Excelutiliy();
			String data=elib1.getDataFormatExcel("Sheet1", 0, 1)+RanNum;
			System.out.println(data);
			
			
			
			//send data in campaign textbox
			
			crea.createCampaign(data);
			
			//click on new product in campaign page
			 crea.clickOnProductInCamp();
			
	         //driver focus to new window
			 webdriver.SwitchtoWindow(driver,"Products&action");
	   
	     //search product name in new window
	     ProductinNewWindow newpPage=new ProductinNewWindow(driver);
	     newpPage.newWindowPageAction(exceldata);
	     
	     
	    // select product using dynamic xpath
	     driver.findElement(By.xpath("//a[text()='"+exceldata+"']")).click();
	   
	   //window switching and focus to mainpage
	     webdriver.SwitchtoWindow(driver,"Campaigns&action");
	        
	       crea.saveCampaign();
	      String camp_msg=crea.getFetchText().getText();
	    System.out.println(camp_msg);
	    
	       if(camp_msg.contains(data)) {
			System.out.println("pass");
		}
		else {
			System.out.println("not pass");
		}
	    
	       home.Logout();
	 
		
		}

	}
}


