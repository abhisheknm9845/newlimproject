package Practicepackage;

import org.testng.annotations.Test;

public class TESTNGPRACTIES {
	@Test(dependsOnMethods = "edit")
	public void create()
	{
		System.out.println("create");
	}
	@Test(invocationCount =0,priority = -1 )
	public void edit()
	{
		System.out.println("edit");
		
	}
	@Test
	public void delete()
	{
		System.out.println("delete");
	}
	

}
