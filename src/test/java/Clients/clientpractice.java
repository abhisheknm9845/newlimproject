package Clients;

import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtilities;
import com.GenericUtilities.ExelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.Javautilities;
import com.GenericUtilities.WebdriverUilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class clientpractice {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) throws Throwable {
			
			
			DatabaseUtilities dLib = new DatabaseUtilities();
			FileUtilities fLib = new FileUtilities();
			ExelUtilities eLib = new ExelUtilities();
			Javautilities jLib = new Javautilities();
			WebdriverUilities wLib = new WebdriverUilities();  
			
			
			
			
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().create();
			ChromeDriver driver = new ChromeDriver();
			//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
			//Properties pobj = new Properties();
			//pobj.load(fis);
			//String BROWSER = pobj.getProperty("browser");
			//String URL = pobj.getProperty("url");
			//String USERNAME = pobj.getProperty("username");
			//String PASSWORD = pobj.getProperty("password");
			
			String URL = fLib.readDataFromPropertyFile("url");
			String USERNAME = fLib.readDataFromPropertyFile("username");
			String PASSWORD = fLib.readDataFromPropertyFile("password");
			
			driver.get(URL);
			HashMap<String, String> map = eLib.readMultipleData("Sheet1");
			//FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\newthings.xlsx");
			//Workbook wb = WorkbookFactory.create(fi);
			//Sheet sh = wb.getSheet("Sheet1");
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			wLib.maximizeWindow(driver);
			Random ran = new Random();
			int ranname = ran.nextInt(300);
			System.out.println(ranname);

		
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//button[.='login']")).click();
			//HashMap<String, String> map = new HashMap<String,String>();//create empty hashmap
			//for(int i=0;i<=sh.getLastRowNum();i++)
			//{
				//String key = sh.getRow(i).getCell(0).getStringCellValue();
				//String value = sh.getRow(i).getCell(1).getStringCellValue();
				//map.put(key, value);
				
			//}
			driver.findElement(By.xpath("//a[@href='client.php']")).click();
			driver.findElement(By.xpath("//a[@href='addClient.php']")).click();
			for(Entry<String, String> set:map.entrySet())
			{
				System.out.println(set.getKey()+" "+set.getValue());
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			
			
			
			//driver.findElement(By.xpath("//input[@name='client_password']")).sendKeys("1234");
			//driver.findElement(By.xpath("//input[@name='name']")).sendKeys("abhi"+ranname);
			//driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys("C:\\Users\\Dell\\Downloads\\IMG_20210812_204257.jpg");
			//driver.findElement(By.xpath("//input[@name='sex']")).sendKeys("male");
			//driver.findElement(By.xpath("//input[@name='sex']")).sendKeys("male");
			//driver.findElement(By.xpath("//input[@name='birth_date']")).sendKeys("14-03-1996");
			//driver.findElement(By.xpath("//input[@name='maritial_status']")).sendKeys("single");
			//driver.findElement(By.xpath("//input[@name='nid']")).sendKeys("89989989");
			//driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("89989989234");
			//driver.findElement(By.xpath("//input[@name='address']")).sendKeys("bangalore");
			//driver.findElement(By.xpath("//input[@name='policy_id']")).sendKeys("8888");
			//driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys("manju");
			//driver.findElement(By.xpath("//input[@name='nominee_sex']")).sendKeys("male");
			//driver.findElement(By.xpath("//input[@name='nominee_birth_date']")).sendKeys("14-4-1990");
			//driver.findElement(By.xpath("//input[@name='nominee_nid']")).sendKeys("12345678");
			//driver.findElement(By.xpath("//input[@name='nominee_relationship']")).sendKeys("father");
			//driver.findElement(By.xpath("//input[@name='priority']")).sendKeys("1");
			//driver.findElement(By.xpath("//input[@name='nominee_phone']")).sendKeys("987654321");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			 String exp = "INSERT CLIENT";
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


