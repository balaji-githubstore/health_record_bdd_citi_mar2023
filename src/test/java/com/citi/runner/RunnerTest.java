package com.citi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Feature/Login.feature"}
		,glue = {"com.citi.steps","com.citi.base"}
		,publish = false
		,plugin = {"html:target/cucumber-report.html","pretty"}
		,tags = "@invalid"
		//,dryRun = true
		)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
