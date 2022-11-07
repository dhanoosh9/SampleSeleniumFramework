package com.sample.Global;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sample.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public WebDriverWait wait;

	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;

	ReadConfig readconfig = new ReadConfig();
	public String browsername = readconfig.getGlobalValue("browser");
	public String baseURL = readconfig.getGlobalValue("baseURL");
	String time = readconfig.getGlobalValue("timeout");
	int timeout = Integer.parseInt(time);

	public static Logger logg = LogManager.getLogger(BaseClass.class);

	@BeforeMethod
	public void setUp() {
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void click(By element, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		test.info(log);
	}

	public void sendKeys(By element, String text, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
		test.info(log);
	}

	public void clear(By element, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(element)).clear();
		test.info(log);
	}

	// select by index
	public void selectIndex(By element, int index, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
		select.selectByIndex(index);
		test.info(log);
	}

	// select by value
	public void selectValue(By element, String value, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
		select.selectByValue(value);
		test.info(log);
	}

	// select by visible text
	public void selectVisibleText(By element, String visibleText, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
		select.selectByVisibleText(visibleText);
		test.info(log);

	}

	// hover on element
	public void hoverOnElement(By element, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
		test.info(log);
	}

	public void doubleClick(By element, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Actions action = new Actions(driver);
		action.doubleClick(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
		test.info(log);
	}

	public void dragAndDrop(By drag, By drop, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Actions action = new Actions(driver);
		action.dragAndDrop(wait.until(ExpectedConditions.visibilityOfElementLocated(drag)),
				wait.until(ExpectedConditions.visibilityOfElementLocated(drop))).build().perform();
		test.info(log);
	}

	public void rightClick(By element, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Actions action = new Actions(driver);
		action.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
		test.info(log);
	}

	public void clickAndHold(By element, String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Actions action = new Actions(driver);
		action.clickAndHold();
		test.info(log);
	}

	public void alertAccept(String log) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		test.info(log);
	}

	public void alertDismiss() {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}

	public void alertSendKeys(String text) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys(text);
	}

	// Scroll By Value
	public void scrollDown(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + value + ")");
	}

	// Scroll By element
	public void scrollToElement(String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('" + element + "').scrollIntoView()");
	}

	public void isDisplayed(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Boolean value = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
		Assert.assertTrue(value);
	}

	public void isSelected(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Boolean value = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isSelected();
		Assert.assertTrue(value);
	}

	public void isEnabled(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Boolean value = wait.until(ExpectedConditions.presenceOfElementLocated(element)).isEnabled();
		Assert.assertTrue(value);
	}

	// creates a random number
	public String randomNumber(int count) {
		String randomNumber = RandomStringUtils.randomNumeric(count);
		return randomNumber;
	}

	// creates a random String
	public String randomString(int count) {
		String randomString = RandomStringUtils.randomAlphabetic(count);
		return randomString;
	}
}
