package Practicepackage;

import org.testng.annotations.Test;

public class DB_Test {
	@Test(dataProviderClass =EXeltoDataProviderdataFetch.class,dataProvider = "data" )
	public void getData(String src,String dst,String loc)
	{
		System.out.println("   from--->"+src+"    to-->"+dst+"   location--->"+loc);
	}
}
