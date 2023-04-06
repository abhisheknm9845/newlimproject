package com.pomObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[@href='client.php']")
	private WebElement Clientlink;
	@FindBy(xpath = "//a[@href='agent.php']")
	private WebElement Agentlink;
	@FindBy(xpath = "//a[@href='policy.php']")
	private WebElement Policylink;
	@FindBy(xpath="//a[@href='nominee.php']")
	private WebElement Nomineelink;
	@FindBy(xpath="//a[@href='payment.php']")
	private WebElement Paymentlink;
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement Logoutlink;
	
	
	public WebElement getLogoutlink() {
		return Logoutlink;
	}


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getClientlink() {
		return Clientlink;
		
	}


	public WebElement getAgentlink() {
		return Agentlink;
	}


	public WebElement getPolicylink() {
		return Policylink;
	}


	public WebElement getNomineelink() {
		return Nomineelink;
	}


	public WebElement getPaymentlink() {
		return Paymentlink;
	}


	
	
	

}
