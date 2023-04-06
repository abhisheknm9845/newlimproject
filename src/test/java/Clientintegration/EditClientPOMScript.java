package Clientintegration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;
import com.pomObjectRepository.ClientInformationPage;
import com.pomObjectRepository.DeleteandEditClientInformationPage;
import com.pomObjectRepository.HomePage;
import com.pomObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.GenericUtilities.ListenerImplimentationClass.class)
public class EditClientPOMScript extends BaseClass{
	@Test()//retryAnalyzer = com.GenericUtilities.RetryimpClass.class

	public void EditClient()throws Throwable {
		// TODO Auto-generated method stub
//		DatabaseUtilities dLib = new DatabaseUtilities();
//		FileUtilities fLib = new FileUtilities();
//		ExelUtilities eLib = new ExelUtilities();
//		Javautilities jLib = new Javautilities();
//		WebdriverUilities wLib = new WebdriverUilities();  
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		
//		String URL = fLib.readDataFromPropertyFile("url");
//		driver.get(URL);
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLoad(driver);
//		
//	LoginPage lp = new LoginPage(driver);
//	lp.login(fLib);
	HomePage hp = new HomePage(driver);
	hp.getClientlink().click();
	ClientInformationPage cip = new ClientInformationPage(driver);
	cip.EditClient(driver, "1670298080");
	driver.findElement(By.xpath("//input[@name='name']")).clear();
	
	DeleteandEditClientInformationPage DEI = new DeleteandEditClientInformationPage(driver);
	
	DEI.getClientnamefield().sendKeys("johncy");
	DEI.getUpdatebutton().click();
	hp.getClientlink().click();
	cip.clientstatuslink(driver,"1670298080" );
	//Assert.fail();
	String expected1="johncy";
	String actual = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
	System.out.println(actual);
	
	
	if(actual.contains(expected1))
		
	{
		System.out.println("data updated");
	}
	else
	{
		System.out.println("data not updated");
	}
	
	
	}
}

	
	


