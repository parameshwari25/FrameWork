package com.crm.product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.crm.Pomclass.HomePage;
import com.crm.Pomclass.Loginpage;
import com.crm.Pomclass.OganizationCreate;
import com.crm.Pomclass.ProductCreate;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CreateProductTest extends BaseClass {
	@Test

	public void  CreateProduct()throws Throwable  {

		FilUility flib=new FilUility();
//		String Browser=flib.getProperty("browser");
//		WebDriver driver;
//		if(Browser.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
// 		}
//		else if(Browser.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//			
//		}
//		else if(Browser.equalsIgnoreCase("edge"))
//		{
//
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
//		{
//		
//			String URL = flib.getProperty("url");
//			String username = flib.getProperty("un");
//			String pswd = flib.getProperty("pw");
			
		WebdriverUtility webdriver=new WebdriverUtility();
		webdriver.waitForpageToLoad(driver);
		driver.manage().window().maximize();
		JavaUtility ju=new JavaUtility();
		int RanNum=ju.getRanDomNum();
		Excelutiliy ex=new Excelutiliy();
		String exceldata=ex.getDataFormatExcel("Sheet1", 0, 1)+RanNum;
		System.out.println(exceldata);
		//driver.get(URL);
		//Loginpage login=new Loginpage(driver);
		//login.login(username, pswd);
		HomePage home=new HomePage(driver);
		home.createprouduct();
		ProductCreate product=new ProductCreate(driver);
		product.createPodct(exceldata);
		String actualdata=product.getFetchtheTitleOfthePage().getText();
		
		//Thread.sleep(1000);
		//validating the actual data
		//String actualData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if(actualdata.contains(exceldata))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		
			home.Logout();
			//driver.close();



	}

	}




















































































































