package Practicepackage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Annotations {
	@BeforeSuite
	public void connectdatabase()
	{
		System.out.println("connect database");
	}
	@AfterSuite
	
public void disconnectdatabase()
		{
			System.out.println("disconnect thedatabase");
		}
	@BeforeClass
	public void openthebrowser()
	{
		System.out.println("");
	}
	
	}



