package com.pomObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExelUtilities;

public class AddClientPage {

	@FindBy(xpath = "//input[@name='client_password']")
	private WebElement Clientpasswordfield;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement Clientnamefield;
	@FindBy(xpath = "//input[@name='fileToUpload']")
	private WebElement uplaodimagelink;
	@FindBy(xpath = "//input[@name='sex']")
	private WebElement sextextfield;
	@FindBy(xpath = "//input[@name='birth_date']")
	private WebElement dataandbithfield;
	@FindBy(xpath = "//input[@name='maritial_status']")
	private WebElement maritalstatusfield;
	@FindBy(xpath = "//input[@name='nid']")
	private WebElement NIDfield;
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement Phonenumbertextfield;
	@FindBy(xpath = "//input[@name='address']")
	private WebElement addersstextfield;
	@FindBy(xpath = "//input[@name='policy_id']")
	private WebElement policytextfield;
	@FindBy(xpath = "//input[@name='nominee_name']")
	private WebElement nomineenametextfield;
	@FindBy(xpath = "//input[@name='nominee_sex']")
	private WebElement nomineeSextextfield;
	@FindBy(xpath = "//input[@name='nominee_birth_date']")
	private WebElement nomineeBirthtextfield;
	@FindBy(xpath = "//input[@name='nominee_nid']")
	private WebElement nomineeNIDtextfield;
	@FindBy(xpath = "//input[@name='nominee_relationship']")
	private WebElement nomineeReltiontextfield;
	@FindBy(xpath = "//input[@name='priority']")
	private WebElement nomineePrioritytextfield;
	@FindBy(xpath = "//input[@name='nominee_phone']")
	private WebElement nomineePhonenotextfield;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//input[@name='client_id']")
	private WebElement Cid;
	
	public AddClientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClientpasswordfield() {
		return Clientpasswordfield;
	}

	public WebElement getClientnamefield() {
		return Clientnamefield;
	}

	public WebElement getUplaodimagelink() {
		return uplaodimagelink;
	}

	public WebElement getSextextfield() {
		return sextextfield;
	}

	public WebElement getDataandbithfield() {
		return dataandbithfield;
	}

	public WebElement getMaritalstatusfield() {
		return maritalstatusfield;
	}

	public WebElement getNIDfield() {
		return NIDfield;
	}

	public WebElement getPhonenumbertextfield() {
		return Phonenumbertextfield;
	}

	public WebElement getAddersstextfield() {
		return addersstextfield;
	}

	public WebElement getPolicytextfield() {
		return policytextfield;
	}

	public WebElement getNomineenametextfield() {
		return nomineenametextfield;
	}

	public WebElement getNomineeSextextfield() {
		return nomineeSextextfield;
	}

	public WebElement getNomineeBirthtextfield() {
		return nomineeBirthtextfield;
	}

	public WebElement getNomineeNIDtextfield() {
		return nomineeNIDtextfield;
	}

	public WebElement getNomineeReltiontextfield() {
		return nomineeReltiontextfield;
	}

	public WebElement getNomineePrioritytextfield() {
		return nomineePrioritytextfield;
	}

	public WebElement getNomineePhonenotextfield() {
		return nomineePhonenotextfield;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public String addclient(WebDriver driver,ExelUtilities elib) throws Throwable
	{
		HashMap<String, String> map = elib.readMultipleData("Sheet1");
		String id = Cid.getAttribute("value");
		
		for(Entry<String, String> clientlist:map.entrySet())
		{
			driver.findElement(By.name(clientlist.getKey())).sendKeys(clientlist.getValue());
		}
		submitbtn.click();
		return id;
	}
	
	
			
	}
		
	
	
	
	
	
	

