package com.citi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Feature/Login.feature"}
		,glue = {"com.citi.steps"} 
		,publish = false
		,plugin = {"html:target/cucumber-report.html"}
		)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
