package stepdefinitions;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class StepDefinition {
	
	BaseUtils utils;
	
	public StepDefinition(BaseUtils baseUtils) {
		this.utils=baseUtils;
	}

	
	@Given("token to be generated")
	public void tokenToBeGenerated() {
	   System.out.println("Currently Token generation in implementation.");
	}
	@Given("path param {string} with value {string}")
	public void pathParamWithValue(String key, String value) {
		System.out.println("Executing Given");
		System.out.println("Printing Key : " + key);
		System.out.println("Printing Value : " + value);
		
		utils.reqSpec = RestAssured.given().pathParam(key, value);
	}
	@When("GET request is exectuted with {string}")
	public void getRequestIsExectutedWith(String url) {
		System.out.println("Executing When");
		utils.resp = utils.reqSpec.when().log().all().get(url);
	}
	@Then("verify status code is {int}")
	public void verifyStatusCodeIs(Integer statusCode) {
		System.out.println("Executing Then");
		utils.resp.then().log().all().statusCode(statusCode);
	}
	
	@Given("query param {string} with value {string}")
	public void queryParamWithValue(String key, String value) {
		System.out.println("Executing Given Query 1");
		System.out.println("Printing Key : " + key);
		System.out.println("Printing Value : " + value);

		utils.reqSpec.queryParam(key, value);
	}
	@Given("header {string} with value {string}")
	public void headerWithValue(String key, String value) {
		System.out.println("Executing Given Header");
		System.out.println("Printing Key : " + key);
		System.out.println("Printing Value : " + value);

		utils.reqSpec.header(key, value);
	}
	@Given("query param {string} with value {int}")
	public void queryParamWithValue(String key, Integer value) {
		System.out.println("Executing Given Query 2");
		System.out.println("Printing Key : " + key);
		System.out.println("Printing Value : " + value);

		utils.reqSpec.queryParam(key, value);
	}

	@Then("verify response body count is {int}")
	public void verifyResponseBodyCountIs(Integer count) {

		utils.resp.then().body("size()", Matchers.equalTo(count));
	}
	@Given("verify if json body has key {string} with value {string}")
	public void verifyJsonResponseBody(String key, String val) {
		// Without pojo
		utils.resp.then().body(key, Matchers.equalTo(val));

		// With Pojo - deserialization
		//GithubCreateResponseRootPOJO obj = utils.resp.then().extract().as(GithubCreateResponseRootPOJO.class);
		//String name = obj.getName();
		//MatcherAssert.assertThat(name, Matchers.equalTo(val));
	}
}
