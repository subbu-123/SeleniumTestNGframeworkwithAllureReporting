package com.listeners;

import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BasePage;
import com.base.BaseTest;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {
	

	public static String getTestMethodName(ITestResult result)
	{
		return result.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] getScreenshot(WebDriver driver)
	{
		return (((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
	}
	
	@Attachment
	public static String saveTextLog(String message)
	{
		return message;
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//page = new BasePage(driver);
		//WebDriver driver = page.returnDriver();

		getScreenshot(BaseTest.getDriver());  
		saveTextLog(getTestMethodName(result) + " is failed and following exception occured: " +result.getThrowable().toString().replaceAll(",", "<br>"));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
