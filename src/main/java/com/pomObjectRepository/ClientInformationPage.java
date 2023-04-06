package com.pomObjectRepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebdriverUilities;

public class ClientInformationPage {

	@FindBy(xpath = "//a[@href='addClient.php']")
private WebElement AddClientlink;
	@FindBy(linkText = "Client Status")
	private WebElement Clientstatuslink;
	@FindBy(linkText = "Edit")
	private WebElement EditLink;
	@FindBy(linkText = "Delete Client")
	private WebElement DeleteClientlink;
	
	public ClientInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
		
	}

	public WebElement getDeleteClientlink() {
		return DeleteClientlink;
	}

	public WebElement getClientstatuslink() {
		return Clientstatuslink;
	}

	public WebElement getEditLink() {
		return EditLink;
	}

	public WebElement getAddClientlink() {
		return AddClientlink;
	}
	
	public void EditClient(WebDriver driver,String id)
	{
	driver.findElement(By.xpath("//table/tbody/tr/td[.='"+id+"']/..//td[8]/a")).click();
	
	}
	public void deleteClient(WebDriver driver)
	{
		int count=23;
		for(int i=23;i<=count;i++)
		{
		List<WebElement> clientid = driver.findElements(By.xpath("//tbody/tr/td[.='1666075647']"));
		 count = clientid.size();
		 System.out.println(count);
		String id1 = clientid.get(i).getText();
		System.out.println(id1);
	
		driver.findElement(By.xpath("//tbody/tr/td[.='"+id1+"']/../td[8]/a[.='Edit']")).click();
		getDeleteClientlink();
		
	}
	}
		
	public void clientstatuslink(WebDriver driver, String id)
	{
		driver.findElement(By.xpath("//tbody/tr/td[.='"+id+"']/../td[7]/a")).click();
	}
	
	public void Verify_deleted_id(WebDriver driver,String id)
	{
	List<WebElement> Idlist = driver.findElements(By.xpath("//tr//td[1]"));
	boolean flag=false;
	for(WebElement list:Idlist)
	{
		String actual = list.getText();
		if(actual.equals(id))
		{
			System.out.println("not deleted");
			flag=true;
		}
	}
	if(!flag)
	{
		System.out.println("deleted");
	}
	
	
	}
}
	

