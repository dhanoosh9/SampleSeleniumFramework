package com.sample.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features", glue = { "com.sample.stepDefinations" }, monochrome = true, plugin = {
		"html:target/htmlReports/index.html", "json:target/jsonReports/report.json" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
