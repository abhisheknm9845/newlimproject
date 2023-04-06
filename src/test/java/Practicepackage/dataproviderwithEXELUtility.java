package Practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExelUtilities;

public class dataproviderwithEXELUtility {
	
	@Test(dataProvider = "setofdata")
	public void getdata(String src,String dec,String loc)
	{
		System.out.println("from    "+src+"   to"+dec+"loc"+loc);
	}
	
	
	
	@DataProvider
	public Object[][]  setofdata() throws Throwable
	
	{
		ExelUtilities elib = new ExelUtilities();
		Object[][] value = elib.readmultiplesetdata("DP");
		return value;
		
	}
	
		
	

}
