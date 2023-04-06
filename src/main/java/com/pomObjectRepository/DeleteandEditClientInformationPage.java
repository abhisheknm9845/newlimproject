package com.pomObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteandEditClientInformationPage {
	@FindBy(linkText = "Delete Client")
	private WebElement DeleteClientlink;
	@FindBy(xpath ="//input[@value='UPDATE']" ) 
	private WebElement Updatebutton;
	@FindBy(xpath = "//input[@name='client_password']")
	private WebElement Clientpasswordfield;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement Clientnamefield;
	
	
	public WebElement getClientpasswordfield() {
		return Clientpasswordfield;
	}


	public WebElement getClientnamefield() {
		return Clientnamefield;
	}


	public DeleteandEditClientInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getDeleteClientlink() {
		return DeleteClientlink;
	}


	public WebElement getUpdatebutton() {
		return Updatebutton;
	}
	public void deleteclient(WebDriver driver,String id)
	{
		driver.findElement(By.xpath("//a[@href='deleteClient.php?client_id="+id+"']")).click();
	}
	{
		
	}

}
