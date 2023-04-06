package Payments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;
import com.pomObjectRepository.ADDPAYMENTPAGE;
import com.pomObjectRepository.HomePage;
import com.pomObjectRepository.LoginPage;
import com.pomObjectRepository.PaymentInformationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakepaymentPOM extends BaseClass{
	@Test
	public void makepayment() throws Throwable
	{
//		DatabaseUtilities dLib = new DatabaseUtilities();
//		FileUtilities fLib = new FileUtilities();
//		ExelUtilities eLib = new ExelUtilities();
//		Javautilities jLib = new Javautilities();
//		WebdriverUilities wLib = new WebdriverUilities();
//		
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver=new ChromeDriver();
//		
//		String URL = fLib.readDataFromPropertyFile("url");
//		driver.get(URL);
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLoad(driver);
//		LoginPage LP = new LoginPage(driver);
//		LP.login(fLib);
		HomePage HP = new HomePage(driver);
		HP.getPaymentlink().click();
		PaymentInformationpage PIF = new PaymentInformationpage(driver);
		PIF.getAddpaymentlink().click();
		ADDPAYMENTPAGE AP = new ADDPAYMENTPAGE(driver);
		AP.addpayment(driver, eLib);
		String expected="INSERT PAYMENT";
		String actual = driver.findElement(By.xpath("//div/h1[@class='page-head-line']")).getText();
		if(actual.contains(expected))
		{
			System.out.println("payment is done");
		}
		else
		{
			System.out.println("payment notdone");
		}
		
		
	}

}
