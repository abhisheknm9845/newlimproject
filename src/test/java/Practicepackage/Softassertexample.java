package Practicepackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassertexample {
	SoftAssert sa = new SoftAssert();
	@Test
	public void Sample1()
	
	{
		
		System.out.println("abhishek");
		System.out.println("rajev");
		System.out.println("naheem");
		sa.assertEquals("bangalore", "mangalore"," actual should match with expected");
		System.out.println("manju");
		sa.assertAll();
	}
	@Test
	public void Sample2()
	{
		int q=3;
		System.out.println("abhishek1");
		System.out.println("rajev1");
		System.out.println("naheem1");
		sa.assertNull(q);
		System.out.println("manju1");	
	}


}
