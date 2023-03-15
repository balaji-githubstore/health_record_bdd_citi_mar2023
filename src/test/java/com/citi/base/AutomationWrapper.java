package com.citi.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class AutomationWrapper {
	
	public WebDriver driver;
	
	@BeforeStep
	public void beforeStep()
	{
		
	}
	
	@AfterStep
	public void afterStep()
	{
		
	}
	
	@Before
	public void startScenario()
	{
		
	}
	
	@After
	public void endScenario()
	{
		if(driver !=null)
		{
			driver.quit();
		}
		
	}

}
