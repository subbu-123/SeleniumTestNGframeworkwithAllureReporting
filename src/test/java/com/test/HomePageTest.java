package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;

	// here HomePageTest constructor calls its parent class constructor i.e of base
	// class so that config file is read without throwing any errors
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialize();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify user navigates to home page after logging in successfully")
	@Story("Home page functionality of CRM application")
	@Test
	public void validateHomePage()

	{
		Assert.assertTrue(hp.verifyUserInHomePage());
		
	}
	
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify user is able to click on contacts link in home page")
	@Story("Home page functionality of CRM application")
	@Test(priority=1)
	public void validateClickingOnContactsLink()

	{
		ContactsPage cp = hp.clickOnContactsLink();
		
	}
	

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
