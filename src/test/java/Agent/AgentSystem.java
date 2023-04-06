package Agent;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AgentSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().create();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Random ran = new Random();
		//int ranname = ran.nextInt(300);
		//System.out.println(ranname);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("555");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("666");
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.xpath("//a[@href='agent.php']")).click();
		driver.findElement(By.xpath("//a[@href='client.php']")).click();
		driver.findElement(By.xpath("//a[@href='addClient.php']")).click();
		driver.findElement(By.xpath("//a[@href='policy.php']")).click();
		driver.findElement(By.xpath("//a[@href='payment.php']")).click();
		driver.findElement(By.xpath("//a[@href='nominee.php']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		String expected="LOGIN";
		String actual = driver.findElement(By.xpath("//button[.='login']")).getText();
		if(actual.contains(expected))
		{
			System.out.println("logon page displayed");
		}
		else
		{
			System.out.println("logon page not displayed");
		}
		driver.close();
		
		
		
		
		
		

	}

}
