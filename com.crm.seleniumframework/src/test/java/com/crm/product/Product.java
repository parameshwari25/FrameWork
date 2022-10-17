package com.crm.product;

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

public class Product {

	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		FileInputStream fis = new FileInputStream("./commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String username = pro.getProperty("un");
		String pswd = pro.getProperty("pw");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		FileInputStream xl = new FileInputStream("./book1.xlsx");
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		Workbook book = WorkbookFactory.create(xl);
		Sheet sh = book.getSheet("Sheet1");
		 Row row = sh.getRow(0);
		Cell cel = row.getCell(1);
		String data = cel.getStringCellValue()+ranDomNum;
		System.out.println(data);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
		System.out.println(data);
		driver.findElement(By.id("productcode")).sendKeys(data);
		Thread.sleep(1000);
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String Actual_msg=driver.findElement(By.xpath("//input[@name='productname']")).getText();
		if(Actual_msg.contains(data))
		{
			System.out.println("pass");
		}
			else
			{
			System.out.println("fail");

		}
		System.out.println(Actual_msg);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		
		
		


	}

}
