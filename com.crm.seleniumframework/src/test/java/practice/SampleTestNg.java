package practice;

import org.testng.annotations.Test;

public class SampleTestNg {
	@Test(invocationCount = 3)
	public void creaecustomer() {
		System.out.println("cutomer details created");
	}
	
	@Test(priority=1)

	public void modifycustomer() {
		System.out.println("cutomer details modified");
	}
	@Test(dependsOnMethods="creaecustomer")

	public void deleteCstomer() {
		
		System.out.println("cutomer details deleted");
		
		
	}
	@Test
	public void CustomerName() {
		System.out.println("cutomer name");

	}


}

