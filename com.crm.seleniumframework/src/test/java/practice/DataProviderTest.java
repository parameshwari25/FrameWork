package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="datProvider_test")
	public void bookTicket(String src,String ds)
	{
		System.out.println("Book Tickets from"+src+"to"+ds+"");
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Delhi";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Kerala";
		
		return objArr;



	}

}
