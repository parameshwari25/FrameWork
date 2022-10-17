package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) throws IOException {
		String key="webdriver.chrome.driver";
		String value= "./chromedriver.exe";
		System.setProperty(key, value);
		
		FileInputStream fis=new FileInputStream("./commondata.properties.txt");
		Properties p=new Properties();
		p.load(fis);
		
	String url = p.getProperty("url");
	String un = p.getProperty("key");
	String pwd = p.getProperty("value");
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		



	}

}
