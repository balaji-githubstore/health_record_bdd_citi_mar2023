package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.citi.base.AutomationKeywords;

public class MainPage extends AutomationKeywords {
	private By patientLocator=By.xpath("//div[text()='Patient']");
	
	private WebDriver driver;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMainPageTitle() {
		return driver.getTitle();
	}

	public void clickOnPatientMenu() {
		clickUsingLocator(patientLocator);
	}
}
