package Practicepackage;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///notification popups
 ChromeOptions options = new ChromeOptions();
 options.addArguments("--disable-notifications");
 WebDriverManager.chromedriver().setup();
 ChromeDriver driver = new ChromeDriver();
 //urlto app
 driver.get("https://www.makemytrip.com/");
 //maximize thebrowser
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
 driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
 driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Bangalore");
 driver.findElement(By.xpath("//a[@class='close']")).click();
 driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
 driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("manglore");
 driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
 //Date cdate=new Date(0);
// String[] d = cdate.toString().split(" ");
Date cdate = new Date();
 String[] d = cdate.toString().split(" ");
 String day = d[0];
 String month = d[1];
 String date=d[2];
 String year=d[5];
 String traveldate=day+""+month+""+date+""+year;
 driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
 //pasing returndate
 
 String rday = "thu";
 String rmonth = "jan";
 String rdate="15";
 String ryear="2023";
 String returndate=rday+" "+rmonth+" "+rdate+" "+ryear;
 for(; ;)
 {
	try { 
 driver.findElement(By.xpath("//div[aria-label='"+returndate+"']")).click();
 break;
	}
 catch(Exception e)
	{
	 driver.findElement(By.xpath("//span[aria-lable]='Next Month']")).click();
	 
	}
		 
	
 }
 
 
 
 
 
 
 
	}

}
