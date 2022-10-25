package com.sample.Global;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sample.Utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports extent = new ExtentReports();
	public ExtentTest test;
	public WebDriverWait wait;
	
	ReadConfig readconfig = new ReadConfig();
	public int timeout = readconfig.getTimeout();

	public void click(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void sendKeys(By element, String text) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
	}

}
