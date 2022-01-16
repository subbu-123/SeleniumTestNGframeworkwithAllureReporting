package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

import io.qameta.allure.Step;

public class ContactsPage extends BaseClass {

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 20);

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactPageHeader;

	@FindBy(xpath = "//*[text()='Create']")
	WebElement createContactsBtn;

	@FindBy(xpath = "//*[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//*[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//*[@name='company']/input")
	WebElement Company;

	@FindBy(xpath = "//*[@placeholder='Email address']")
	WebElement emailId;

	@FindBy(xpath = "//*[text()='Save']")
	WebElement saveBtn;
	

	@Step("To verify user has landed on contacts page after clicking on contacts link in home page")
	public boolean validateUserInContactsPage() {
		wait.until(ExpectedConditions.visibilityOf(contactPageHeader));
		return contactPageHeader.isDisplayed();
	}

	@Step("Creating a new contact details with firstname {0} lastname {1} company {2} email {3}")
	public boolean createNewContact(String firstname, String lastname, String company, String emailID) {

			createContactsBtn.click();
			wait.until(ExpectedConditions.visibilityOf(firstName));
			firstName.sendKeys(firstname);
			lastName.sendKeys(lastname);
			Company.sendKeys(company);
			emailId.sendKeys(emailID);
			saveBtn.click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ firstname + " " + lastname + "']")));
			return driver.findElement(By.xpath("//*[text()='"+ firstname + " " + lastname + "']")).isDisplayed();
		
	}

}
