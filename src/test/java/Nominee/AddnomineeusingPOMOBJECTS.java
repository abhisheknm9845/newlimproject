package Nominee;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;
import com.pomObjectRepository.AddNomineePage;
import com.pomObjectRepository.HomePage;
import com.pomObjectRepository.LoginPage;
import com.pomObjectRepository.Nomineeinformationpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddnomineeusingPOMOBJECTS extends BaseClass {
	@Test(retryAnalyzer = com.GenericUtilities.RetryimpClass.class)

	public void addnominee() throws Throwable {
//		Javautilities jLib = new Javautilities();
//		WebdriverUilities wLib = new WebdriverUilities();
//		FileUtilities fLib = new FileUtilities();
//		ExelUtilities eLib = new ExelUtilities();
//	
//		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver driver= new ChromeDriver();
//		String URL = fLib.readDataFromPropertyFile("url");
//				driver.get(URL);
//				wLib.maximizeWindow(driver);
//				wLib.waitForPageLoad(driver);
//		LoginPage ln = new LoginPage(driver);
//		ln.login(fLib);
	HomePage hp = new HomePage(driver);
	hp.getNomineelink().click();
	Nomineeinformationpage nip = new Nomineeinformationpage(driver);
	nip.getAddnomineeLink().click();
	
	AddNomineePage anp = new AddNomineePage(driver);
	anp.addnomineepage(driver, eLib);
	
	String expected = "INSERT NOMINEE";
	Thread.sleep(2000);
	String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
		if(actual.contains(expected))
		{
			System.out.println("nomineeinserted");
		}
		else {
			System.out.println("Nomineenotinserted");
		}

	}

}
