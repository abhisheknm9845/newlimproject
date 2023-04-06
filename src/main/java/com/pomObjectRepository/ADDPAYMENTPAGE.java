package com.pomObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExelUtilities;

public class ADDPAYMENTPAGE {
	@FindBy(xpath = ("//input[@name='client_id']"))
			private WebElement Clientidtextfield;
	@FindBy(xpath = ("//input[@name='month']"))
	private WebElement monthtextfield;
	@FindBy(xpath = ("//input[@name='amount']"))
	private WebElement amounttextfield;
	@FindBy(xpath = ("//input[@name='due']"))
	private WebElement duetextfield;
	@FindBy(xpath = ("//input[@name='fine']"))
	private WebElement Finetextfield;
	@FindBy(xpath = ("//input[@type='submit']"))
	private WebElement submitbutton;
	
	
	public ADDPAYMENTPAGE(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getClientidtextfield() {
		return Clientidtextfield;
	}


	public WebElement getMonthtextfield() {
		return monthtextfield;
	}


	public WebElement getAmounttextfield() {
		return amounttextfield;
	}


	public WebElement getDuetextfield() {
		return duetextfield;
	}


	public WebElement getFinetextfield() {
		return Finetextfield;
	}


	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	public void addpayment(WebDriver driver,ExelUtilities elib) throws Throwable
	{
		HashMap<String, String> map = elib.readMultipleData("Sheet4");
		for(Entry<String, String> set:map.entrySet())
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		submitbutton.click();
			
	}
	
	
	

}
