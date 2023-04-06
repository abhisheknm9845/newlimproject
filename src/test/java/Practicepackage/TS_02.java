package Practicepackage;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_02 extends BaseClass{
	@Test(groups = "smoke")
	public void Script3()
	{
		System.out.println("execute script3");
	}
	@Test(groups = "regression")
	public void Script4()
	{
		System.out.println("execute script4");
	}
	@Test(groups = {"regression","smoke"})
	public void Script9()
	{
		System.out.println("execute script9");
	}

}
