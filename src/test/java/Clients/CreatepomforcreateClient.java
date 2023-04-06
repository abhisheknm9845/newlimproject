package Clients;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;
import com.pomObjectRepository.AddClientPage;
import com.pomObjectRepository.ClientInformationPage;
import com.pomObjectRepository.DeleteandEditClientInformationPage;
import com.pomObjectRepository.HomePage;
import com.pomObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatepomforcreateClient extends BaseClass {

	@Test 
	public void createClient() throws Throwable
	{
		
		Javautilities jLib = new Javautilities();
		
	HomePage HP = new HomePage(driver);
	HP.getClientlink().click();
ClientInformationPage cip = new ClientInformationPage(driver);
cip.getAddClientlink().click();
AddClientPage acp = new AddClientPage(driver);
String cust_Id = acp.addclient(driver, eLib);
HP.getClientlink().click();
List<WebElement> clientids = driver.findElements(By.xpath("//tbody/tr/td"));
boolean flag=false;
for(WebElement ids:clientids)
{
	String value = ids.getText();
	
	if(value.equalsIgnoreCase(cust_Id))
	{
		System.out.println(cust_Id+":  client created succesfully");
		flag=true;
		break;
	}
}
if(!flag)
{
	System.err.println(cust_Id+"not created");
}
	}
@Test
public void deleteclient()throws Throwable
{


	HomePage hp = new HomePage(driver);
	hp.getClientlink().click();
	
	ClientInformationPage CIP = new ClientInformationPage(driver);
	String exp="1671096185";
	CIP.EditClient(driver,exp);
	DeleteandEditClientInformationPage DEI = new DeleteandEditClientInformationPage(driver);
	DEI.deleteclient(driver,exp );
hp.getClientlink().click();
CIP.Verify_deleted_id(driver, exp);




	}


	}


