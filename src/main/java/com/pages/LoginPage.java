package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseTest;
import com.base.BasePage;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
/*	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement signupBtn;

	@FindBy(xpath="//*[@name='email']")
	WebElement username;

	@FindBy(xpath="//*[@name='password']")
	WebElement password;

	@FindBy(xpath="//*[text()='Login']")
	WebElement loginbtn;

	@FindBy(xpath="//*[@class='navbar-brand']")
	WebElement crmLogo;

*/	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By crmLogo = By.xpath("//*[@class='navbar-brand']");
	private By signupBtn = By.xpath("//*[text()='Sign Up']");
	private By username = By.xpath("//*[@name='email']");
	private By password = By.xpath("//*[@name='password']");
	private By loginbtn = By.xpath("//*[text()='Login']");
	
	public WebElement getCrmLogo() {
		return getElement(crmLogo);
	}


	public WebElement getSignupBtn() {
		return getElement(signupBtn);
	}

	public WebElement getUsername() {
		return getElement(username);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	
	public WebElement getLoginbtn() {
		return getElement(loginbtn);
	}
	

/*	@Step("Login page validation with the help of company logo")
	public boolean verifyLoginPage() {
		wait.until(ExpectedConditions.visibilityOf(crmLogo));
		return crmLogo.isDisplayed();
	}

	@Step("Login page title validation")
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("User logs in with username {0} and password {1}")   //{0} {1} will capture the username and password value passed during runtime and print it in reports
	public HomePage login(String Username, String Password) {
		
		wait.until(ExpectedConditions.visibilityOf(signupBtn));
		
		String parenthandle= driver.getWindowHandle();
		signupBtn.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it =handles.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			if(!s.equals(parenthandle))
			{
				driver.switchTo().window(s);
			}
		}
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginbtn.click();

		return new HomePage();
	}
*/
	
	
	@Step("Login page validation with the help of company logo")
	public boolean verifyLoginPage() {
		waitForElement(crmLogo);
		return getCrmLogo().isDisplayed();
	}

	@Step("Login page title validation")
	public String verifyLoginPageTitle() {
		return getPageTitle();
	}

	@Step("User logs in with username {0} and password {1}")   //{0} {1} will capture the username and password value passed during runtime and print it in reports
	public HomePage login(String Username, String Password) {
		
		waitForElement(signupBtn);
		WebDriver driver = returnDriver();
		String parenthandle= driver.getWindowHandle();
		getSignupBtn().click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it =handles.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			if(!s.equals(parenthandle))
			{
				driver.switchTo().window(s);
			}
		}
		getUsername().sendKeys(Username);
		getPassword().sendKeys(Password);
		getLoginbtn().click();

		return getInstance(HomePage.class);
	}


}
