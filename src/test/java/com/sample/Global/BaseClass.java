package com.sample.Global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public WebDriver driver;
	public ExtentReports extent = new ExtentReports();
    public ExtentTest test;
    @BeforeClass
	public void launchbrowser(String browsername) {
		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
	}
    @AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	public void click(By element) {
		driver.findElement(element).click();
	}
	
	public void sendKeys(By element) {
		driver.findElement(element).sendKeys();
	}
	
	public void select() {
		
	}
	
	
	

}
