package com.citi.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.citi.base.AutomationWrapper;
import com.citi.pages.LoginPage;
import com.citi.pages.MainPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {

	private static DataTable dtMain = null;

	private AutomationWrapper wrapper;

	private MainPage mainPage;

	public PatientSteps(AutomationWrapper wrapper) {
		this.wrapper = wrapper;

		// initialize page objects
		initPageObjects();
	}

	public void initPageObjects() {

		mainPage = new MainPage(wrapper.driver);
	}

	@When("I click on patient menu")
	public void i_click_on_patient_menu() {
//		wrapper.driver.findElement(By.xpath("//div[text()='Patient']")).click();
		mainPage.clickOnPatientMenu();
	}

	@When("I click on new-search menu")
	public void i_click_on_new_search_menu() {
		wrapper.driver.findElement(By.xpath("//div[text()='New/Search']")).click();
	}

	@When("I fill the patient record who")
	public void i_fill_the_patient_record(DataTable dataTable) {
		dtMain = dataTable;
		// sheet to List<Map<String, String>>
		System.out.println(dataTable);

		List<Map<String, String>> list = dataTable.asMaps();

		System.out.println(list.get(0).get("firstname"));
		System.out.println(list.get(0).get("lastname"));
		System.out.println(list.get(0).get("gender"));
		System.out.println(list.get(0).get("dob"));

		wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));

		wrapper.driver.findElement(By.id("form_fname")).sendKeys(list.get(0).get("firstname"));
		wrapper.driver.findElement(By.id("form_lname")).sendKeys(list.get(0).get("lastname"));

		Select selectGender = new Select(wrapper.driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText(list.get(0).get("gender"));

		wrapper.driver.findElement(By.id("form_DOB")).sendKeys(list.get(0).get("dob"));
	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {
		wrapper.driver.findElement(By.id("create")).click();
		wrapper.driver.switchTo().defaultContent();

	}

	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() {
		wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		wrapper.driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		wrapper.driver.switchTo().defaultContent();
	}

	@When("I store the alert text and handle it")
	public void i_store_the_alert_text_and_handle_it() {

	}

	@When("I close happy birthday popup if available")
	public void i_close_happy_birthday_popup_if_available() {

	}

	@Then("the alert message should contatin {string}")
	public void the_alert_message_should_contatin(String string) {

	}

	@Then("I should get the added patient name {string}")
	public void i_should_get_the_added_patient_name(String string) {

		System.out.println(dtMain);
	}

}
