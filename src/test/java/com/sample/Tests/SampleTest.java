package com.sample.Tests;

import org.testng.annotations.Test;

import com.sample.Global.BaseClass;
import com.sample.PageObjects.ByObjects;

public class SampleTest extends BaseClass {

	@Test(retryAnalyzer = com.sample.Utilities.RetryAnalyzer.class)
	public void sampleTest() {
		test = extent.createTest("sampleTest").assignAuthor("Ananya").assignDevice("Hp Laptop");
		driver.findElement(ByObjects.username).sendKeys("standard_user");
		test.info("Entered the username");
		driver.findElement(ByObjects.password).sendKeys("secret_sauce");
		test.info("Entered the password");
		driver.findElement(ByObjects.loginbtn).click();
		test.info("Clicked on login button");
	}

	@Test
	public void byTest() {
		test = extent.createTest("byTest").assignAuthor("Dhanoosh").assignDevice("Dell Laptop");
		sendKeys(ByObjects.username, "standard_user", "Entered the username");
		sendKeys(ByObjects.password, "secret_sauce", "Entered the password");
		click(ByObjects.loginbtn, "Clicked on login button");
	}

}
