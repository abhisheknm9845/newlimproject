package com.pomObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.FileUtilities;

public class LoginPage {
	//declaration
	@FindBy(xpath = "//input[@name='username']")
	private WebElement Usernameedt;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement Passwordedt;
	@FindBy(xpath = "//button[.='login']")
	private WebElement Loginbtn;
	//intilization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsernameedt() {
		return Usernameedt;
	}
	public WebElement getPasswordedt() {
		return Passwordedt;
	}
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
	
//	public void login(String username, String password)
//	{
//		Usernameedt.sendKeys(username);
//		Passwordedt.sendKeys(password);
//		Loginbtn.click();
//	}
	public void login(FileUtilities Flib) throws Throwable	
	{
		Usernameedt.sendKeys(Flib.readDataFromPropertyFile("username"));
		Passwordedt.sendKeys(Flib.readDataFromPropertyFile("password"));
		Loginbtn.click();
	}
	
}


