package com.crm.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FilUility {
	/*
	 * his method is used to launch the application
	 * @param key
	 * @return
	 * @throws throwable
	 * @author Parameshwari
	 */
	public String getProperty(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
	String value=pro.getProperty(key);
	return value;
	
		
	}

}
