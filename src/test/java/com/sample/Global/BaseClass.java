package com.sample.Global;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports extent = new ExtentReports();
	public ExtentTest test;

}
