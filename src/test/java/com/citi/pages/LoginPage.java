package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.citi.base.AutomationKeywords;

public class LoginPage extends AutomationKeywords {
	private WebDriver driver;
	
	private By usernameLocator=By.id("authUser");
	private By passwordLocator=By.cssSelector("#clearPass");
	private By loginLocator=By.cssSelector("button[type='submit']");
	private By errorLocator=By.xpath("//*[contains(text(),'Invalid')]");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String username) {
		typeUsingLocator(usernameLocator, username);
	}

	public void enterPassword(String password) {
		typeUsingLocator(passwordLocator, password);
	}

	public void clickLogin() {
		clickUsingLocator(loginLocator);
	}

	public String getErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}
}