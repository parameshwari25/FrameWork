package com.crm.campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.GenericUtilities.Excelutiliy;
import com.crm.GenericUtilities.FilUility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Pomclass.CreateCampaignwithOrgans;
import com.crm.Pomclass.HomePage;
import com.crm.Pomclass.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignwithDynamicTest {

	public static void main(String[] args) throws Throwable {
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
			webdriver.waitForpageToLoad(driver);
			driver.manage().window().maximize();
			JavaUtility ju=new JavaUtility();
			int RanNum=ju.getRanDomNum();
			Excelutiliy ex=new Excelutiliy();
			String exceldata=ex.getDataFormatExcel("Sheet1", 0, 1)+RanNum;
			System.out.println(exceldata);
			driver.get(URL);
			
			Loginpage login=new Loginpage(driver);
			
			HomePage home=new HomePage(driver);
			login.login(username, pswd);		
			//CreateCampaignwithOrgans cam=new CreateCampaignwithOrgans (driver);
				driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

				
				FileInputStream fis2=new FileInputStream("./book1.xlsx");
				Workbook book1 = WorkbookFactory.create(fis2);
				Sheet sh1 = book1.getSheet("Sheet1");
				Row row1 = sh1.getRow(0);
				Cell cell = row1.getCell(0);
				String productdata = cell.getStringCellValue()+RanNum;
				driver.findElement(By.name("productname")).sendKeys(productdata);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				//Navigate to Campaign
				driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();

				driver.findElement(By.linkText("Campaigns")).click();
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();


				FileInputStream fis1=new FileInputStream("./product.xlsx");

				Workbook book=WorkbookFactory.create(fis1);
				Sheet sh = book.getSheet("Sheet1");
				Row row = sh.getRow(0);
				Cell cel = row.getCell(0);
				String data = cel.getStringCellValue()+RanNum;
				driver.findElement(By.name("campaignname")).sendKeys(data);

				driver.findElement(By.xpath("//img[@title='Select']")).click();
				//Window Switching

				Set<String> allId = driver.getWindowHandles();
				Iterator<String> it=allId.iterator();
				while(it.hasNext())
				{
				String wid = it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains("Products&action"))
				{
				break;
				}}


				driver.findElement(By.id("search_txt")).sendKeys(productdata);
				driver.findElement(By.name("search")).click();

				//Dynamic Xpath
				driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();

				//Switch back Window
				Set<String> allId1 = driver.getWindowHandles();
				Iterator<String> it1=allId1.iterator();
				//String tit = driver.getTitle();
				//System.out.println(tit);
				while(it1.hasNext())
				{
				String wid = it1.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains("Campaigns&action"))
				{
				break;
				}
				}
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				Thread.sleep(1000);

				String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();

				if(actData.contains(data))
				{
				System.out.println("pass");
				}
				else
				{
				System.out.println("fail");
				}
				//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				//driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
				home.Logout();

	}
	}
}
