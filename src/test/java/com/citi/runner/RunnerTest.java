package com.citi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//		features = {"src/test/resources/Feature/Login.feature",
//				"src/test/resources/Feature/Patient.feature"}
		
		features = {"src/test/resources/Feature"}
		,glue = {"com.citi.steps","com.citi.base"}
		,publish = false
		,plugin = {"html:target/cucumber-report.html","pretty"}
		,tags = "@patient"
		,dryRun = false
		)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
