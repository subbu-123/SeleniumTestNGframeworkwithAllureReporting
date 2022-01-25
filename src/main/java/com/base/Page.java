package com.base;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
	}
	
	
	public abstract String getPageTitle();
	
	public abstract WebElement getElement(By Locator);
	
	public abstract void waitForElement(By Locator);
	
	public <T extends BasePage> T getInstance(Class<T> pageclass)
	{
		try {
			
			return pageclass.getConstructor(WebDriver.class).newInstance(this.driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
