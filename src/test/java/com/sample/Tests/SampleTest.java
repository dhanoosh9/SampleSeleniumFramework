package com.sample.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.Global.BaseClass;
import com.sample.PageObjects.ByObjects;
import com.sample.PageObjects.SampleObjects;

public class SampleTest extends BaseClass {

	@Test(retryAnalyzer = com.sample.Utilities.RetryAnalyzer.class)
	public void sampleTest() {
		test = extent.createTest("sampleTest").assignAuthor("Dhanoosh").assignDevice("Dell Laptop");
		SampleObjects sample = new SampleObjects(driver);
		sample.login("standard_user", "secret_sauce");
		test.info("Entered the username");
		test.info("Entered the password");
		test.info("Clicked on login button");
	}

	@Test
	public void byTest() {
//		driver.findElement(ByObjects.username).sendKeys("standard_user");
//		driver.findElement(ByObjects.password).sendKeys("secret_sauce");
//		driver.findElement(ByObjects.loginbtn).click();
		test = extent.createTest("byTest").assignAuthor("Ananya").assignDevice("Hp Laptop");
		sendKeys(ByObjects.username, "standard_user");
		test.info("Entered the username");
		sendKeys(ByObjects.password, "secret_sauce");
		test.info("Entered the password");
		click(ByObjects.loginbtn);
		test.info("Clicked on login button");
	}

}
