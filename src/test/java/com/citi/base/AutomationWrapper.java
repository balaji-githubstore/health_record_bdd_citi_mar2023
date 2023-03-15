package com.citi.base;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;

public class AutomationWrapper {
	
	public WebDriver driver;
	
	
	@After
	public void endScenario()
	{
		if(driver !=null)
		{
			driver.quit();
		}
		
	}

}
