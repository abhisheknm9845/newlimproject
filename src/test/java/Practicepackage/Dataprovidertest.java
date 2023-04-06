package Practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovidertest {
	@Test(dataProvider = "data")
	public void getdata(String src,String dst,String loc)
	{
		System.out.println("   from--->"+src+"    to-->"+dst+"   location--->"+loc);
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0]="qspider";
		obj[0][1]="Testyantra";
		obj[0][2]="bangalore";
		
		obj[1][0]="testyantra";
		obj[1][1]="sony";
		obj[1][2]="us";
		
		obj[2][0]="tcs";
		obj[2][1]="infosys";
		obj[2][2]="mumbai";
		return obj;
				
	}

}
