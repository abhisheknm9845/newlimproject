package com.pomObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExelUtilities;

public class AddNomineePage {

	@FindBy(xpath = "//input[@name='client_id']")
	private WebElement Clienetidtextfield;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement Nomineenametextfield;
	@FindBy(xpath ="//input[@name='sex']")
	private WebElement Nomineesextextfield;
	@FindBy(xpath ="//input[@name='birth_date']")
	private WebElement Birthdatetextfield;
	@FindBy(xpath ="//input[@name='nid']")
	private WebElement NIDtetextfield;
	@FindBy(xpath ="//input[@name='relationship']")
	private WebElement Relationshiptextfield;
	@FindBy(xpath ="//input[@name='priority']")
	private WebElement Prioritytextfield;
	@FindBy(xpath ="//input[@name='phone']")
	private WebElement Phonetextfield;
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement Submitbtn;
	@FindBy(xpath = "//input[@name='nominee_id']")
	private WebElement nomineedField;
	
	public AddNomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getNomineedField() {
		return nomineedField;
	}


	public WebElement getClienetidtextfield() {
		return Clienetidtextfield;
	}

	public WebElement getNomineenametextfield() {
		return Nomineenametextfield;
	}

	public WebElement getNomineesextextfield() {
		return Nomineesextextfield;
	}

	public WebElement getBirthdatetextfield() {
		return Birthdatetextfield;
	}

	public WebElement getNIDtetextfield() {
		return NIDtetextfield;
	}

	public WebElement getRelationshiptextfield() {
		return Relationshiptextfield;
	}

	public WebElement getPrioritytextfield() {
		return Prioritytextfield;
	}

	public WebElement getPhonetextfield() {
		return Phonetextfield;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	public String addnomineepage(WebDriver driver,ExelUtilities eLib) throws Throwable
	{
		HashMap<String, String> map = eLib.readMultipleData("Sheet2");
		String id = nomineedField.getAttribute("value");
		for( Entry<String, String> set : map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		Submitbtn.click();
		return id;
	}
	
	
	
	
	
	
	
	
	

}
