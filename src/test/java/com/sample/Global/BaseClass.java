package com.sample.Global;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
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
	public String browsername = readconfig.getGlobalValue("browser");
	String time = readconfig.getGlobalValue("timeout");
	public int timeout = Integer.parseInt(time);

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
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void click(By element, String log) throws StaleElementReferenceException, ElementClickInterceptedException {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			test.info(log);
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	public void sendKeys(By element, String text, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
			test.info(log);
		} catch (Exception e) {
			e.printStackTrace();

			test.info(e.getMessage());
			logg.error(e.getMessage());

		}
	}

	// select by index
	public void selectIndex(By element, int index, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
			select.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	// select by value
	public void selectValue(By element, String value, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
			select.selectByValue(value);
			test.info(log);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	// select by visibletext
	public void selectVisibleText(By element, String visibleText, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(element)));
			select.selectByVisibleText(visibleText);
			test.info(log);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	// hover on element
	public void hoverOnElement(By element, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Actions action = new Actions(driver);
			action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
			test.info(log);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	// alerts
	public void alerts(By element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
		driver.switchTo().alert().accept();

	}

	public void doubleClick(By element, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Actions action = new Actions(driver);
			action.doubleClick(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
			test.info(log);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	public void dragAndDrop(By drag, By drop, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Actions action = new Actions(driver);
			action.dragAndDrop(wait.until(ExpectedConditions.visibilityOfElementLocated(drag)),
					wait.until(ExpectedConditions.visibilityOfElementLocated(drop))).build().perform();
			test.info(log);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

	public void rightClick(By element, String log) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
			Actions action = new Actions(driver);
			action.contextClick(wait.until(ExpectedConditions.visibilityOfElementLocated(element))).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.info(e.getMessage());
			test.info(e.getCause());
		}
	}

}
