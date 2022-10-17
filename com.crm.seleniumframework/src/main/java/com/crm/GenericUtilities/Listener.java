package com.crm.GenericUtilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String data=result.getMethod().getMethodName();
		EventFiringWebDriver edrive= new EventFiringWebDriver(BaseClass.sDriver);
		File src=edrive.getScreenshotAs(OutputType.FILE);
		try
		{
			File des=new File("./cm.crm.seleniumframework/Screenshot/"+data+".png");
			FileUtils.copyFile(src, des);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}


}
