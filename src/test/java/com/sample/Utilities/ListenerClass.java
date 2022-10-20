package com.sample.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sample.Global.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener {

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("Reports/index.html");
		spark.config().setDocumentTitle("My Report");
		spark.config().setReportName("Sample Report");
		spark.config().setTheme(Theme.DARK);
//		extent.attachReporter(spark);
	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onFinish(ITestContext context) {

	}

}
