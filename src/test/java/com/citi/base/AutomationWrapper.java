package com.citi.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class AutomationWrapper {
	
	public static WebDriver driver;
	
	
	@After
	public void endScenario()
	{
		AutomationWrapper.driver.quit();
	}

}
