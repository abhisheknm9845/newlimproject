package Clientintegration;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.GenericUtilities.ListenerImplimentationClass.class)
public class editclientsystem {

	public static void main(String[] args) throws Throwable {
		DatabaseUtilities dLib = new DatabaseUtilities();
		FileUtilities fLib = new FileUtilities();
		ExelUtilities eLib = new ExelUtilities();
		Javautilities jLib = new Javautilities();
		WebdriverUilities wLib = new WebdriverUilities();  
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		driver.get(URL);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		
		//driver.manage().window().maximize();
		//Random ran = new Random();
		//int ranname = ran.nextInt(300);
		//System.out.println(ranname);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		driver.findElement(By.xpath("//a[@href='editClient.php?client_id=1679037237']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		HashMap<String, String> map = eLib.readMultipleData("Sheet3");
		
		for(Entry<String, String> set:map.entrySet())
		{
			if(set.equals("name"))
			{
			
				String expected = set.getValue()+jLib.random();
				//System.out.println(set.getKey()+" "+set.getValue());
		System.out.println(set.getKey()+" "+set.getValue());
				
			
			
			driver.findElement(By.name(set.getKey())).sendKeys(expected);
			}
			else
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			
		}
		//driver.findElement(By.xpath("//input[@name='name']")).sendKeys("sindhu6");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		driver.findElement(By.xpath("//a[@href='clientStatus.php?client_id=1679037237']")).click();
		String expected1="sindhu6";
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
