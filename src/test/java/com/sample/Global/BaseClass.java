package com.sample.Global;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public String browsername = readconfig.getbrowserName();
	public int timeout = readconfig.getTimeout();

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
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void click(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void sendKeys(By element, String text) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
	}

	// select by index
	public void selectIndex(By element, int index) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
		select.selectByIndex(index);
	}

	// select by value
	public void selectValue(By element, String value) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
		select.selectByValue(value);
	}

	// select by visibletext
	public void selectVisibleText(By element, String visibleText) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
		select.selectByVisibleText(visibleText);
	}

	// hover on element
	public void hoverOnElement(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
	}

}
