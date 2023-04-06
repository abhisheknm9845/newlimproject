package Practicepackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCVERIFY {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = WebDriverManager.chromedriver().create();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		String teamname="India";
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		boolean flag=false;
		for(WebElement name :teams)
		{
			String text = name.getText();
			if(text.equals(teamname))
			{
				System.out.println("Present");
				flag=true;
				break;
				
			}
		}
		if(!flag)
		{
			System.out.println("notpresent");
		}
		
		
	}

}
