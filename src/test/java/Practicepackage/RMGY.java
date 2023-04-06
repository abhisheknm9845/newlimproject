package Practicepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;
import com.mysql.cj.jdbc.Driver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGY {
	
	

	public static void main(String[] args)throws IOException, Throwable {
		DatabaseUtilities dLib = new DatabaseUtilities();
		FileUtilities fLib = new FileUtilities();
		ExelUtilities eLib = new ExelUtilities();
		Javautilities jLib = new Javautilities();
		WebdriverUilities wLib = new WebdriverUilities();
		
		
		
		
		
		
		Connection con=null;
		ResultSet result=null;
		String expectedproject="gmh4";
		
		
		FileInputStream	fis =new FileInputStream("./src/test/resources/commondata.properties");
	     Properties	obj =new Properties();
	     obj.load(fis);
	String b=obj.getProperty("browser");
	String ul =obj.getProperty("url");
	 String un =obj.getProperty("username");
	  String pw=obj.getProperty("password");
	  
		WebDriverManager.chromedriver().create();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ul);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("gmh4");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("abhishek");
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='status']"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		 String query = "select *from project";
 result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actproj =result.getString(4);
			System.out.println(actproj);
			if(actproj.equalsIgnoreCase(expectedproject))
			{
				flag=true;
				break;
				
			}
			
		}
		
		if(flag)
		{
			System.out.println("project is created");
		}
		else
		{
			System.out.println("project is not created");
		}
		

		
		
	}

		
		

}


