package com.citi.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationKeywords {
	WebDriver driver;

	public AutomationKeywords(WebDriver driver) {
		this.driver = driver;
	}

	public void clickUsingLocator(By locator) {
		driver.findElement(locator).click();
	}

	public void typeUsingLocator(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
}