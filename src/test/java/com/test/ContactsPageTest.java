package com.test;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.codoid.products.exception.FilloException;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.utilityClass;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ContactsPageTest extends BaseTest{

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;    
	utilityClass uc;

	
	
	// here HomePageTest constructor calls its parent class constructor i.e of base
	// class so that config file is read without throwing any errors
	public ContactsPageTest() {
		super();
	}

/*	@BeforeMethod
	public void setup() {
		initialize();
		uc = new utilityClass();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("Username"), prop.getProperty("Password"));
		cp = hp.clickOnContactsLink();
	}
*/	
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify user is navigated to contacts page from home page")
	@Story("Contacts page functionality of CRM application")
	@Test
	public void validateUserOnContactsPage()

	{
		lp = page.getInstance(LoginPage.class);
		hp = lp.login(prop.getProperty("Username"), prop.getProperty("Password"));
		cp= hp.clickOnContactsLink();
		Assert.assertTrue(cp.validateUserInContactsPage());
		
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify user is able to create new contact details in contacts page")
	@Story("Contacts page functionality of CRM application")
	@Test(priority=1, dataProvider="testData")
	public void validateUserIsAbleToCreateANewContact(String firstname, String lastname, String company, String emailID)

	{
		lp = page.getInstance(LoginPage.class);
		hp = lp.login(prop.getProperty("Username"), prop.getProperty("Password"));
		cp= hp.clickOnContactsLink();
		Assert.assertTrue(cp.createNewContact(firstname, lastname, company, emailID));
		
	}
	
	@DataProvider(name="testData")
	public Iterator<Object[]> getdata() throws FilloException {
		List<Object[]> data = uc.getDataFromExcel("./Resources/TestData.xlsx", "Data");
		return data.iterator();
	}
	
/*
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
*/	
}
