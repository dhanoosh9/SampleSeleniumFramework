package com.sample.Tests;

import org.testng.annotations.Test;

import com.sample.Global.BaseClass;
import com.sample.PageObjects.ByObjects;
import com.sample.PageObjects.SampleObjects;

public class SampleTest extends BaseClass {

	@Test
	public void sampleTest() {
		SampleObjects sample = new SampleObjects(driver);
		sample.login("standard_user", "secret_sauce");
	}
	
	@Test
	public void byTest() {
//		driver.findElement(ByObjects.username).sendKeys("standard_user");
//		driver.findElement(ByObjects.password).sendKeys("secret_sauce");
//		driver.findElement(ByObjects.loginbtn).click();
		
		sendKeys(ByObjects.username, "standard_user");
		sendKeys(ByObjects.password, "secret_sauce");
		click(ByObjects.loginbtn);
	}

}
