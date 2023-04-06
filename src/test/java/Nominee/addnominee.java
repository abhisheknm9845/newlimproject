package Nominee;

import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addnominee {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		DatabaseUtilities dLib = new DatabaseUtilities();
		FileUtilities fLib = new FileUtilities();
		ExelUtilities eLib = new ExelUtilities();
		Javautilities jLib = new Javautilities();
		WebdriverUilities wLib = new WebdriverUilities();  
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		driver.get(URL);
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wLib.waitForPageLoad(driver);
		//driver.manage().window().maximize();
		wLib.maximizeWindow(driver);
		
		//Random ran = new Random();
		//int ranname = ran.nextInt(300);
		//System.out.println(ranname);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
		driver.findElement(By.xpath("//a[@href='addNominee.php']")).click();
		HashMap<String, String> map = eLib.readMultipleData("Sheet2");
		for(Entry<String, String> set:map.entrySet())
		{
			System.out.println(set.getKey()+" "+set.getValue());
		
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		//driver.findElement(By.xpath("//input[@name='client_id']")).sendKeys("1678780336");
		//driver.findElement(By.xpath("//input[@name='name']")).sendKeys("vidhi");
		//driver.findElement(By.xpath("//input[@name='sex']")).sendKeys("female");
		//driver.findElement(By.xpath("//input[@name='birth_date']")).sendKeys("8-3-2000");
		//driver.findElement(By.xpath("//input[@name='nid']")).sendKeys("89989989333");
		//driver.findElement(By.xpath("//input[@name='relationship']")).sendKeys("relative");
		//driver.findElement(By.xpath("//input[@name='priority']")).sendKeys("2");
		//driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("89989989");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
		String exp = "INSERT NOMINEE";
		String  actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
		if(actual.contains(exp))
		{
			System.out.println("Client is created"+actual);
			
		}
		else
		{
			System.out.println("Clientis notcreated");
		}
		
		
		}

}

