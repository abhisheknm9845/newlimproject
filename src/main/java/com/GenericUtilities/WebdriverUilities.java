package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUilities {
	

	/**
	 * This method used to maximize window
	 * @author Dell
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	
	{
		
	driver.manage().window().maximize();

	}
	/**
	 *This method used to wait for the page load
	 * @param driver
	 */
			
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void elementToBeVisible(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOf(element));
    		
    }
				
	
	public void select(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public void select (WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
		
	}
	public void select(String visibleText,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
		
	}
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
		
	}
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
		
	}
	public void enterKeyPress(WebDriver driver)
    {
    	Actions a=new Actions(driver);
    	a.sendKeys(Keys.ENTER).perform();
    }
    public void enterKey(WebDriver driver) throws Throwable 
    {
    	Robot r=new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    }
    public void enterRelease(WebDriver driver) throws AWTException
    {
    	Robot r=new Robot();
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    
    public void switchToFrame(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
    
    public void switchToFrame(WebDriver driver,String nameOrId)
    {
    	driver.switchTo().frame(nameOrId);
    }
    
    public void switchToFrame(WebDriver driver,WebElement address)
    {
    	driver.switchTo().frame(address);
    }
    
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    
    public void cancelAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    public void switchToWindow(WebDriver driver,String partialTitle)
    {
    	//1.use get window handles to capture all window id's
    	Set<String> windows = driver.getWindowHandles();
    	
    	//2.iterate through the windows
    	Iterator<String> it = windows.iterator();
    	
        //3.check whether there is next window
    	while(it.hasNext())
    	{
    		//4.capture current window id
    		String winID=it.next();
    		
    		//5.switch to current window and capture title
    		String currentWinTitle=driver.switchTo().window(winID).getTitle();
    		
    		//6.check whether current window is expected
    		if(currentWinTitle.contains(partialTitle))
    		{
    			break;
    		}
    	}
    }
    
    public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
    {
    	Date d=new Date();
    	String date = d.toString();
    	String cdate = date.replace(":", "-");
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	String path=".\\screenshot\\"+screenShotName+cdate+".png";
    	File dst=new File(path);
    	FileUtils.copyFile(src, dst);
    	return path;
    	
    }
    
    public void scrollBarAction(WebDriver driver)
    {
    	JavascriptExecutor j=(JavascriptExecutor)driver;
    	j.executeScript("window.scrollBy(0,800)", "");
    }
    
    public void scrollAction(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor j=(JavascriptExecutor)driver;
    	int y=element.getLocation().getY();
    	j.executeScript("window.scrollBy(0,"+y+")", element);
        //j.executeScript("argument[0].scrollIntoView()", element);
    }  
}


