package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.BaseClass;

import io.qameta.allure.Step;

public class HomePage extends BaseClass{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	@FindBy(xpath="//*[@class='user-display']")
	WebElement userDisplay;
	
	@FindBy(xpath="//*[@class='users icon']")
	WebElement contactsLink;
	
	@Step("To verify user is present in home page")
	public boolean verifyUserInHomePage()
	{
		/*
		 * Alert a = driver.switchTo().alert(); a.dismiss();
		 */
		wait.until(ExpectedConditions.visibilityOf(userDisplay));
		if(userDisplay.getText().equalsIgnoreCase(prop.getProperty("user"))) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Step("To verify user is able to click on contacts link in home page")
	public ContactsPage clickOnContactsLink()
	{
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(contactsLink));
		a.moveToElement(contactsLink).click().build().perform();
		
		return new ContactsPage();
	}
	
}
