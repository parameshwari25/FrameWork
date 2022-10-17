package com.crm.makemytrip;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Travelticketbooking {

	public static void main(String[] args) throws Throwable {
		//lauching the browser  fetching data from propeties file
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		FileInputStream fis = new FileInputStream("./MakeMytrip.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		driver.get(url);
		
		//fetchin data from excet sheet
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Flights']")).click();FileInputStream prod = new FileInputStream("./product.xlsx");
		FileInputStream cam = new FileInputStream("./Makemytip.xlsx");
		Workbook book1 = WorkbookFactory.create(cam);
		Sheet sh1 = book1.getSheet("Sheet1");
		Row ro1 = sh1.getRow(0);
		String from=ro1.getCell(0).getStringCellValue();
		String to=ro1.getCell(1).getStringCellValue();
		System.out.println(from);
		System.out.println(to);
		Actions ac=new Actions(driver);
		ac.moveByOffset(620, 180).click().perform();
		WebElement from_texfld=driver.findElement(By.id("fromCity"));
		from_texfld.sendKeys(from);
		ac.moveToElement(driver.findElement(By.xpath("//p[text()='"+from+"']"))).click().perform();
		WebElement to_texfld=driver.findElement(By.id("toCity"));
		to_texfld.sendKeys(to);
		ac.moveToElement(driver.findElement(By.xpath("//p[text()='"+to+"']"))).click().perform();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String dep_month="October 2022";
		String dep_date="11";
		//driver.findElement(By.xpath("//div[text()='"+dep_month+"']/ancestor::div[@class='DayPicker-Month']/
		

		
		
		
	}

}
