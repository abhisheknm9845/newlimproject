package com.pomObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nomineeinformationpage {

@FindBy(xpath="//a[@href='addNominee.php']")
private WebElement AddnomineeLink;
public Nomineeinformationpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getAddnomineeLink() {
	return AddnomineeLink;
}
public boolean flag=false;
public String verify_nomineeadded(WebDriver driver,String exp)
{
	List<WebElement> nomineeids = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	int count = nomineeids.size();
	for(WebElement ids:nomineeids)
	{
		String id = ids.getText();
		if(id.equalsIgnoreCase(id))
		{
			System.out.println("nomineeadded");
			flag=true;
			break;
		}
		
	}
	if(!flag)
	{
		System.out.println("nominee notadded");
		
	}
	return exp;
	
			
}
private void get(int i) {
	// TODO Auto-generated method stub
	
}


}

