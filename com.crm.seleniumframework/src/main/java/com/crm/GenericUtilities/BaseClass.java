package com.crm.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.Pomclass.HomePage;
import com.crm.Pomclass.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	@BeforeSuite(groups= {"Smoketest","RegressionTest"})
	public void BS()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups={"Smoketest","RegressionTest"})
	public void BT()
	{
		System.out.println("Execute in parllel mode");
	}
	
	@BeforeClass(groups= {"Smoketest","RegressionTest"})
	public void BC() throws Throwable {

	FilUility flib=new FilUility();
	String Browser=flib.getProperty("browser");
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
	sDriver=driver;
	{
		System.out.println("Lauching the Browser");
	}
	}
	@BeforeMethod(groups= {"Smoketest","RegressionTest"})
	
	public void BM() throws Throwable {
		
	FilUility flib=new FilUility();

	String URL = flib.getProperty("url");
	String username = flib.getProperty("un");
	String pswd = flib.getProperty("pw");
	
WebdriverUtility web=new WebdriverUtility();
web.waitForpageToLoad(driver);
driver.get(URL);
Loginpage login=new Loginpage(driver);
login.login(username, pswd);

		System.out.println("Login to the application");
	}
	@AfterMethod(groups= {"Smoketest","RegressionTest"})
	public void AM() throws Throwable
	{
		HomePage home=new HomePage(driver);
		home.Logout();
		System.out.println("Logout the application");
	}
	@AfterClass(groups= {"Smoketest","RegressionTest"})
	public void AC() throws Throwable
	{
		//driver.close();
		System.out.println("Close the Browser");
	}
	@AfterTest(groups= {"Smoketest","RegressionTest"})
	public void AT()  throws Throwable
	{
		System.out.println("Executed Successfully");
	}
	@AfterSuite(groups= {"Smoketest","RegressionTest"})
	public void AS()  throws Throwable
	{
		System.out.println("Databas closed");
	}
	}

