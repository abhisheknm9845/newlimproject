package Clientintegration;

import static org.testng.Assert.fail;

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
@Listeners(com.GenericUtilities.ListenerImplimentationClass.class)
public class DeleteclientPOMtext extends BaseClass {
@Test()//retryAnalyzer = com.GenericUtilities.RetryimpClass.class
	public void DeleteClient() throws Throwable {
		// TODO Auto-generated method stub
//		DatabaseUtilities dLib = new DatabaseUtilities();
//		FileUtilities fLib = new FileUtilities();
//		ExelUtilities eLib = new ExelUtilities();
		Javautilities jLib = new Javautilities();
//		WebdriverUilities wLib = new WebdriverUilities();  
		
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		String URL = fLib.readDataFromPropertyFile("url");
//		driver.get(URL);
//		wLib.waitForPageLoad(driver);
		LoginPage lp = new LoginPage(driver);
		//lp.login(fLib);
		
		HomePage hp = new HomePage(driver);
		hp.getClientlink().click();
		
		ClientInformationPage CIP = new ClientInformationPage(driver);
		String exp="1671253142";
		CIP.EditClient(driver,exp);
		Assert.fail();
		DeleteandEditClientInformationPage DEI = new DeleteandEditClientInformationPage(driver);
		DEI.deleteclient(driver,exp );
	hp.getClientlink().click();
	CIP.Verify_deleted_id(driver, exp);
	

		
		
		
		

	}

}
