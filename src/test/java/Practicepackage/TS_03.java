package Practicepackage;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_03 extends BaseClass {
	@Test(groups = "regression")
	public void Script5()
	{
		System.out.println("execute script5");
	}
	@Test(groups = {"smoke","regression"})
	public void Script6()
	{
		System.out.println("execute script6");
	}

}
