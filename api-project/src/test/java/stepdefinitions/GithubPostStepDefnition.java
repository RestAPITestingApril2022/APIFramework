package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.GithubCreateRepoPOJO;
import utils.POJOHelper;

public class GithubPostStepDefnition {
	
	BaseUtils utils;
	public GithubPostStepDefnition(BaseUtils baseUtils) {
		this.utils=baseUtils;
	}
	
	@Given("input json body for create repo key {string} with value {string}")
	public void inputJsonBodyForCreateRepoKeyWithValue(String string, String string2) {
		GithubCreateRepoPOJO obj = new GithubCreateRepoPOJO();
		obj.setName(string2);
		utils.reqSpec.body(obj);
	}
	
	@Given("input json body for create repo with {string},{string},{string}")
	public void inputJsonBodyForCreateRepoWith(String name, String privateVal, String desc) {
		GithubCreateRepoPOJO obj = POJOHelper.GetCreateRepoObject(name, privateVal, desc);

		// Parsing Json to body [serialization]
		utils.reqSpec.body(obj);
	}
	
	@When("POST request is exectuted with {string}")
	public void postRequestIsExectutedWith(String url) {
		System.out.println("Executing POST Call");
		utils.resp = utils.reqSpec.when().log().all().post(url);
	}
	
	@Then("verify if response body as {string},{string},{string}")
	public void verifyIfResponseBodyAs(String name, String privateVal, String desc) {
		POJOHelper.ValidateCreateRepoObject(utils.resp, name, privateVal, desc);
	}
}
