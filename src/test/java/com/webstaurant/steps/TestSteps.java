package com.webstaurant.steps;

import java.util.Map;

import com.webstaurant.utils.CommonUI;
import com.webstaurant.utils.ReadConfig;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps extends ReadConfig {
	public TestSteps() {
		super.getInstance();
	}
	
	@Before
	public void setUp() {
		CommonUI.openBrowser("chrome");			
	}
	
	@Given("User navigates to the webstaurantStore website")
	public void user_navigates_to_the_webstaurant_store_website() {
	   CommonUI.navigate(applicationURL);
	}
	
	@When("^.*enterText$")
	public void enterText(DataTable dataTable) {
		String value = "";
		for (Map<String, String> data : dataTable.asMaps()) { 
			String webelement = data.get("ObjectName");
			value = data.get("text");
			CommonUI.explicitWait(webelement);
			CommonUI.enter(webelement, value);
		}

	}
	
	@When("^.*clickObject$")
	public void clickObject(DataTable dataTable) {
		for (Map<String, String> data : dataTable.asMaps()) {
			String webelement = data.get("ObjectName");
			CommonUI.explicitWait(webelement);
			CommonUI.click(webelement);
		}
	}
	
	@When("^.*verifyWebListText$")
	public void verifyWebListText(DataTable dataTable) {
		for (Map<String, String> data : dataTable.asMaps()) {
			String webelement = data.get("ObjectName");
			String expectedValue=data.get("expectedValue");
			CommonUI.verifyListText(webelement, expectedValue);
		}
	}
	
	@When("^.*clickOnLastItem$")
	public void addLastItemToTheCart(DataTable dataTable) {
		for (Map<String, String> data : dataTable.asMaps()) {
			String webelement = data.get("ObjectName");			
			CommonUI.clickLastWebElement(webelement);
		}
	}
	
	@Then("^.*verifyText$")
	public void verifyText(DataTable dataTable) {
			for (Map<String, String> data : dataTable.asMaps()) {
				String webelement = data.get("ObjectName");	
				String expectedValue=data.get("expectedValue");
				CommonUI.verifyText(webelement,expectedValue);
			}
	}

	@After
	public void tearDown() {
		if(CommonUI.driver != null) {
			CommonUI.quitBrowser();
		}
		
	}

}
