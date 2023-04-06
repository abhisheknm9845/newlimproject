package Practicepackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TS_01 extends BaseClass{
//	@Test(groups = "smoke")
//	public void Script1()
//	{
//		System.out.println("execute script1");
//	}
	@Test(retryAnalyzer = com.GenericUtilities.RetryimpClass.class)
	public void Script2()
	{
		System.out.println("execute script2");
		Assert.fail();
		
	}
	
	
	
	

}
