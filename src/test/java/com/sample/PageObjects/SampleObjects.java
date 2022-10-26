package com.sample.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleObjects {

	WebDriver driver;

	public SampleObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginbtn;

	public void login(String Username, String Password) {
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginbtn.click();
	}

}
