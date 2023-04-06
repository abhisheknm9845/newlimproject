package com.GenericUtilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//execution start from here
		String methodname = result.getMethod().getMethodName();
	 test = report.createTest(methodname);
		Reporter.log(methodname+"------>test case execution Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"---->Passed");
		Reporter.log(methodname+"----->testscript execution successful");
	}

	public void onTestFailure(ITestResult result) 
	{
//		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		File dst = new File("./Screenshot/FailedScript.png");
//		try {
//			FileUtils.copyFile(src, dst);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			String screenshotname = WebdriverUilities.getScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("testscript execution failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"----->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("testcase Execution Skipped ");
		
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtntReport/report.html");
		htmlreport.config().setDocumentTitle("Life Insurence Management");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("LIM");
		
		
	 report = new ExtentReports();
	 report.attachReporter(htmlreport);
	 report.setSystemInfo("Base_Browser", "chrome");
	 report.setSystemInfo("os", "Windows");
	 report.setSystemInfo("BaseURL", "https://localhost:3306");
	 report.setSystemInfo("Reporter_name", "Abhishek N M");
	
	}

	public void onFinish(ITestContext context) 
	{
		report.flush();
		
	}
	

}
