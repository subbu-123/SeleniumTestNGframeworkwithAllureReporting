package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseClass {
	
	LoginPage lp; 
	
	// here LoginPageTest constructor calls its parent class constructor i.e of base class so that config file is read without throwing any errors
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeSuite
	public void allureDirectoryEmpty() throws IOException
	{
		FileUtils.deleteDirectory(new File("./allure-results"));
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		lp = new LoginPage(); 
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify user lands on login page after entering the url")
	@Story("Login functionality of CRM application")
	@Test
	public void validateUserInLoginPageOfCRMApplication()

	{
		boolean flag = lp.verifyLoginPage();
		Assert.assertTrue(flag);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify login page title")
	@Story("Login functionality of CRM application")
	@Test(priority=1)
	public void validateLoginPageTitle()

	{
		String title = lp.verifyLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify user logs in successfully into application")
	@Story("Login functionality of CRM application")
	@Test(priority=2)
	public void validateUserLogin()

	{
		HomePage hp =lp.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
