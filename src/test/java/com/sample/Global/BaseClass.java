package com.sample.Global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

<<<<<<< HEAD
	public static WebDriver driver;

	public static WebDriver launchbrowser(String browsername) {
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void closeBrowser() {
		driver.close();
	}
	
	public static void click(By element) {
		driver.findElement(element).click();
	}
	
	public static void sendKeys(By element) {
		driver.findElement(element).sendKeys();
	}
	
	public static void select() {
		
	}
	
	
	
	
	
	
	
	
=======
	public WebDriver driver;
	public ExtentReports extent = new ExtentReports();
	public ExtentTest test;
>>>>>>> master

}
