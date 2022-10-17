package com.crm.organsation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseClass;
import com.crm.GenericUtilities.Excelutiliy;
import com.crm.GenericUtilities.FilUility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.Pomclass.HomePage;
import com.crm.Pomclass.OganizationCreate;

@Listeners(com.crm.GenericUtilities.Listener.class)

public class organisationTest extends BaseClass {
	@Test(groups= {"Smoketest"})
	
	public void Organisation() throws   Throwable  
	 {
		
		
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
//		String URL = flib.getProperty("url");
//		String username = flib.getProperty("un");
//		String pswd = flib.getProperty("pw");
//		
//		
//		
//		
//		WebdriverUtility webdriver=new WebdriverUtility();
//		webdriver.waitForpageToLoad(driver);
//		driver.manage().window().maximize();
		JavaUtility ju=new JavaUtility();
		int RanNum=ju.getRanDomNum();
		Excelutiliy ex=new Excelutiliy();
	String exceldata=ex.getDataFormatExcel("Sheet1", 0, 1)+RanNum;
//		System.out.println(exceldata);
//	driver.get(URL);
//		
//		Loginpage login=new Loginpage(driver);
		
		HomePage home=new HomePage(driver);
		OganizationCreate org=new OganizationCreate(driver);
		
		//login.login(username, pswd);
		home.createOrganization();
			org.createorganization(exceldata);
			//Assert.assertEquals(true, false);
			//SoftAssert soft= new SoftAssert();
			//soft.assertEquals("A", "B");
			
		
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(exceldata);
//		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		/*String actualData =org.getFetchtheTit().getText();
		if(actualData.contains(exceldata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		home.Logout();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		
	}

		
	}





















































































































