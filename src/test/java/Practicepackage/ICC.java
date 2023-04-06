package Practicepackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = WebDriverManager.chromedriver().create();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		
		List<WebElement> country = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		 List<WebElement> match = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		 List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		 List<WebElement> rateings = driver.findElements(By.xpath("//tbody/tr/td[5]"));
		 
		 for(int i=0;i<country.size();i++)
		 {
			 System.out.println(country.get(i).getText()+" "+match.get(i).getText()+" "+points.get(i).getText()+" "+rateings.get(i).getText());
		 }
		 
		 
		 //" "+match.get(i).getText()+" "+points.get(i).getText()+" "+rateings.get(i).getText());
	}

}


