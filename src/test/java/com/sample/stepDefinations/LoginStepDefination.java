package com.sample.stepDefinations;

import static org.testng.Assert.assertEquals;

import com.sample.Global.BaseClass;
import com.sample.PageObjects.ByObjects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination extends BaseClass {

	@Given("^the user is on loginpage of the website$")
	public void the_user_is_on_loginpage_of_the_website() {
		test = extent.createTest("LoginTest").assignAuthor("Dhanoosh").assignDevice("Dell Laptop");
		assertEquals(driver.getCurrentUrl(), baseURL);
	}

	@When("user enters username {string} and password {string}")
	public void user_enters_username_username_and_password_password(String username, String password) {
		sendKeys(ByObjects.username, username, "Entered the username");
		sendKeys(ByObjects.password, password, "Entered the password");
	}

	@And("^Clicks on login button$")
	public void clicks_on_login_button() {
		click(ByObjects.loginbtn, "Clicked on login button");
	}

	@Then("^verify user is on homepage$")
	public void verify_user_is_on_homepage() {
		isDisplayed(ByObjects.products);
	}

}
