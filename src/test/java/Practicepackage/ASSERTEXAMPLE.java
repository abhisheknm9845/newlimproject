package Practicepackage;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ASSERTEXAMPLE {
	@Test
	public void Sample1()
	{
		System.out.println("abhishek");
		System.out.println("rajev");
		System.out.println("naheem");
		assertEquals("bangalore", "mangalore"," actual should match with expected");
		System.out.println("manju");
	}
	@Test
	public void Sample2()
	{
		int q=3;
		System.out.println("abhishek1");
		System.out.println("rajev1");
		System.out.println("naheem1");
		assertNull(q);
		System.out.println("manju1");	
	}

}
