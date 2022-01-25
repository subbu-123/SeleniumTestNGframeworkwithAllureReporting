package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By Locator) {
		WebElement element = null;
		
		try {
			
			element = driver.findElement(Locator);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return element;
	}

	@Override
	public void waitForElement(By Locator) {
		
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public  WebDriver returnDriver()
	{
		return driver;
	}
	
	
}
