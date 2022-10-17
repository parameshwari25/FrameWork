package com.crm.GenericUtilities;

import java.util.Random;

public class JavaUtility {
	/*This method is used to avoid duplicate value
	 * @return
	 * @author parameshwari
	 * 
	 */
public int getRanDomNum() {
	Random ran=new Random();
	int RanNum=ran.nextInt(1000);
	return RanNum;
}
}
