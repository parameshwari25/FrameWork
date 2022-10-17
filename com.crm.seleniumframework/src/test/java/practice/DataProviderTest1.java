package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
	@Test(dataProvider="dataprovider_Test")
	public void leadDetails(String lastname,String email,String country) throws Throwable
	
	{
		
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys(country);
		Thread.sleep(2000);
		driver.quit();
		

	}
	@DataProvider
	public Object[][] dataprovider_Test()
	{
		Object[][]data=new Object[3][3];
		data[0][0]="Muhil";
		data[0][1]="pioj@gmail.com";
		data[0][2]="india";
		
		data[1][0]="MuhilArasi";
		data[1][1]="muhil19@gmail.com";
		data[1][2]="india";
		
		
		data[2][0]="Thalir";
		data[2][1]="thalirkannan@gmail.com";
		data[2][2]="UK";
		
		
				return data;
	}
	
		
	}

