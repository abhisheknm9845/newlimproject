package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.pomObjectRepository.HomePage;
import com.pomObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public DatabaseUtilities dLib=new DatabaseUtilities();
	 public ExelUtilities eLib=new ExelUtilities();
	 public FileUtilities fLib=new FileUtilities();
	 public WebdriverUilities wLib=new WebdriverUilities();
	 public WebDriver driver;
	 public static WebDriver sdriver;
	 
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dLib.connectDb();
		System.out.println("---connecttodatabase---");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable//String BROWSER
	{
	String BROWSER = fLib.readDataFromPropertyFile("browser");
	String URL = fLib.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else
		{
			System.out.println("invalid browser");
		}
		sdriver=driver;
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver);
		
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(fLib);
		
	}
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		HomePage hp = new HomePage(driver);
		hp.getLogoutlink().click();
		
	}
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		dLib.closeDB();
	}

}
