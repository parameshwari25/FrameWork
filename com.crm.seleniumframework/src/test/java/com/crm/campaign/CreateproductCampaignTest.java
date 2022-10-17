package com.crm.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseClass;
import com.crm.GenericUtilities.Excelutiliy;
import com.crm.GenericUtilities.FilUility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Pomclass.CampaignCreate;
import com.crm.Pomclass.HomePage;
import com.crm.Pomclass.Loginpage;
import com.crm.Pomclass.OganizationCreate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateproductCampaignTest extends BaseClass{
@Test
	public void createproduct() throws Throwable {
		FilUility flib=new FilUility();
		/*String Browser=flib.getProperty("browser");
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
		webdriver.waitForpageToLoad(driver);
		driver.manage().window().maximize();*/
		JavaUtility ju=new JavaUtility();
		int RanNum=ju.getRanDomNum();
		Excelutiliy ex=new Excelutiliy();
		String exceldata=ex.getDataFormatExcel("Sheet1", 0, 1)+RanNum;
		System.out.println(exceldata);
		//driver.get(URL);
		
		Loginpage login=new Loginpage(driver);
		
		HomePage home=new HomePage(driver);
		//login.login(username, pswd);
			home.clickMoremenu();
		CampaignCreate crea=new CampaignCreate(driver);
		crea.campaign();
		crea.entercampaign(exceldata);
		
		/*driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(exceldata);
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);*/
		String actualdata=crea.getFetchtheTitleofthepage().getText();
						
		if(actualdata.contains(exceldata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		home.Logout();

		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/



	}


}
