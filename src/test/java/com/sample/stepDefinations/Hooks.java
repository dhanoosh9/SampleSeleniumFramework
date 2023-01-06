package com.sample.stepDefinations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sample.Global.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseClass {
	
	@Before
	public void setUp() {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
