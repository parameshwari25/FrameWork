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

import com.crm.GenericUtilities.FilUility;

public class CampaingnwithProduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		FilUility flib=new FilUility();
		String URL = flib.getProperty("url");
		String username = flib.getProperty("un");
		String pswd = flib.getProperty("pw");
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		FileInputStream prod = new FileInputStream("./product.xlsx");
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		Workbook book = WorkbookFactory.create(prod);
		Sheet sh = book.getSheet("Sheet1");
		Row ro = sh.getRow(0);
		Cell cel = ro.getCell(1);
		String data = cel.getStringCellValue();
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		//driver.findElement(By.id("more")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream cam = new FileInputStream("./campaign.xlsx");
		Workbook book1 = WorkbookFactory.create(cam);
		Sheet sh1 = book1.getSheet("Sheet1");
		Row ro1 = sh1.getRow(0);
		Cell cel1 = ro1.getCell(0);
		String data1 = cel1.getStringCellValue()+ranDomNum;
		System.out.println(data1);
		Thread.sleep(2000);
		driver.findElement(By.name("campaignname")).sendKeys(data1);
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String actualData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actualData.contains(data1))
		{
			
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();


		}
	

}

