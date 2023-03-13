package com.citi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1Steps {
	
	@Given("I have browser with openemr page")
	public void i_have_browser_with_openemr_page() 
	{
	   System.out.println("browser launch");
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) 
	{
	    System.out.println(username);
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) 
	{
	   
	}
	
	@When("I select language as {string}")
	public void i_select_language_as(String language) 
	{
	    
	}
	
	@When("I click on login")
	public void i_click_on_login() {
	    
	}
	
	@Then("I should get access to portal with title as {string}")
	public void i_should_get_access_to_portal_with_title_as(String expectedTitle) {
	    
	}

	@Then("I should not get access portal with error as {string}")
	public void i_should_not_get_access_portal_with_error_as(String expectedError) 
	{
	   
	}

}
