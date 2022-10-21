package com.sample.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		extent.attachReporter(spark);
	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		test.fail(result.getName());
		try {
			test.addScreenCaptureFromPath(capturescreenshot());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.skip(result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public String capturescreenshot() throws IOException {
		Date currentdate = new Date();
		String time = currentdate.toString().replace(" ", "-").replace(":", "-");
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath = new File(".//ReportScreenShots//" + time + ".png");
		String absolutepath = destinationfilepath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationfilepath);
		return absolutepath;
	}

}
