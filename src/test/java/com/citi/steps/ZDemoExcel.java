package com.citi.steps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.citi.utilities.DBUtils;
import com.citi.utilities.ExcelUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ZDemoExcel {

	@When("I fill the record")
	public void i_fill_the_record(DataTable dataTable) {

		System.out.println(dataTable);

		List<Map<String, String>> list = dataTable.asMaps();

//		System.out.println(list.get(0).get("city"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("city"));
			System.out.println(list.get(i).get("country"));
		}
	}

	@Then("I should verify the saved records")
	public void i_should_verify_the_saved_records() {

	}

	@When("I fill the record from excel {string} and sheet {string}")
	public void i_fill_the_record_from_excel_and_sheet(String excelFile, String sheetName) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
//		Object[][] data= ExcelUtils.getSheetIntoTwoDimArray(excelFile, sheetName);
//		
//		System.out.println(data[0][0]);
//		System.out.println(data[0][1]);

		List<Map<String, String>> list = ExcelUtils.getSheetIntoListOfMap(excelFile, sheetName);
		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).get("City"));
//			System.out.println(list.get(i).get("Country"));
			driver.findElement(By.name("q")).sendKeys(list.get(i).get("City") + ",");
		}
	}

	@Then("I should verify the data in db with username {string} and password {string} and {string}")
	public void i_should_verify_the_data_in_db_with_username_and_password(String username, String password,
			String query) throws SQLException {

		int count = DBUtils.getQueryCount(username, password, query);

		Assert.assertTrue(count > 0, "Assertion on count in db");
	}

}
