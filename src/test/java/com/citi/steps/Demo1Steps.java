package com.citi.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.citi.base.AutomationWrapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1Steps {
	
	@Given("I have browser with openemr page")
	public void i_have_browser_with_openemr_page() 
	{
		AutomationWrapper.driver=new ChromeDriver();
		AutomationWrapper.driver.manage().window().maximize();
		AutomationWrapper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
		AutomationWrapper.driver.get("https://demo.openemr.io/b/openemr");
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) 
	{
		AutomationWrapper.driver.findElement(By.id("authUser")).sendKeys(username);
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) 
	{
		AutomationWrapper.driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
	}
	
	@When("I select language as {string}")
	public void i_select_language_as(String language) 
	{
	    //language not required now
	}
	
	@When("I click on login")
	public void i_click_on_login() {
		AutomationWrapper.driver.findElement(By.id("login-button")).click();
	}
	
	@Then("I should get access to portal with title as {string}")
	public void i_should_get_access_to_portal_with_title_as(String expectedTitle) { 
		String actualTitle=AutomationWrapper.driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Then("I should not get access portal with error as {string}")
	public void i_should_not_get_access_portal_with_error_as(String expectedError) 
	{
		String actualError=AutomationWrapper.driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		Assert.assertTrue(actualError.contains(expectedError)); //expect true
	}

}
