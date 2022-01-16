package com.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	public BaseClass()
	{
		try {

			FileInputStream fis = new FileInputStream("./Resources/config.properties");
			prop.load(fis);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("File doesnot exist at mentioned path");
			
		}
	}
	
	
	public void initialize()
	{
		
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		/*	ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");   */
			driver = new ChromeDriver();
		}
		
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("Url"));
	}
	
	
	public static WebDriver returnDriver()
	{
		return driver;
	}
	
	

}
