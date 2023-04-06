package Payments;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makepayment {

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
		driver.findElement(By.xpath("//a[@href='payment.php']")).click();
		driver.findElement(By.xpath("//a[@href='addPayment.php']")).click();
		driver.findElement(By.xpath("//input[@name='client_id']")).sendKeys("1678780336");
		driver.findElement(By.xpath("//input[@name='month']")).sendKeys("15-03-2023");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("3000");
		driver.findElement(By.xpath("//input[@name='due']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='fine']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String expected="INSERT PAYMENT";
		String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
		if(actual.contains(expected))
		{
			System.out.println("payment done");
		}
		else
		{
			System.out.println("payment not done");
		}
		driver.close();
		
		
		
		
		
		
		

	}

}
