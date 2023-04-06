package Clientintegration;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Deleteclientintigration {

	public static void main(String[] args) throws Throwable {
		DatabaseUtilities dLib = new DatabaseUtilities();
		FileUtilities fLib = new FileUtilities();
		ExelUtilities eLib = new ExelUtilities();
		Javautilities jLib = new Javautilities();
		WebdriverUilities wLib = new WebdriverUilities();  
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
     String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Random ran = new Random();
		//int ranname = ran.nextInt(300);
		//System.out.println(ranname);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		driver.findElement(By.xpath("//a[@href='editClient.php?client_id=1679037237']")).click();
		driver.findElement(By.xpath("//a[@href='deleteClient.php?client_id=1679037237']")).click();
		driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
		 List<WebElement> clientid = driver.findElements(By.xpath("//td[2]"));
		int count = clientid.size();
		
		for(int i=0;i<count;i++)
		{
			String text = clientid.get(i).getText();
			if(text.contains("1679037237"))
			{
		
		
		
	System.out.println("Client will be not deleted");
			}	
		
		else
		{
			System.out.println("Client deletedsuccessfully");
		}
			Thread.sleep(2000);
		
		driver.close();
		
		
		}
	}
}
	
		
		
		
		

	


