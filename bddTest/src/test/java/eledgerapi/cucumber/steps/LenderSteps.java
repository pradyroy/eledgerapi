package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.LenderImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LenderSteps {

	@Steps
	LenderImpl lender;

//Post Request to create/update lenders
	@Given("User want to hit Lender POST api")
	public void user_want_to_hit_Lender_POST_api() {

	}

	@When("User provide the LenderData")
	public void user_provide_the_Lender() {
		lender.postLenderUrl();
	}

	@Then("Response code should return {int} status")
	public void response_code_should_return_status_code(int code) {
		lender.statusCodeCheck(code);
	}

//Get Request to get list of all lenders
	@Given("User perform GET for list of lenders")
	public void user_perform_GET_for_list_of_lenders() {
	}

	@When("User have url for api {string}")
	public void user_have_url_for(String string) {
		lender.getLendersList();
	}

	@Then("Response status should have statuscode {int}")
	public void response_status_should_be(int code) {
		lender.statusCodeCheck(code);
	}

//Get request to get specific lender with user Id
	@Given("User perform GET for one lender with user Id")
	public void user_perform_GET_for_one_lender_with_user_Id() {

	}

	@When("User have url for {string} and {int}")
	public void user_have_url_for_and(String string, int id) {
		lender.getLenderByUserId(string, id);
	}

	@Then("Response status be {int}")
	public void response_status_be(int code) {
		lender.statusCodeCheck(code);
	}

//Get request for non existing user-id lender
	@Given("User perform GET for one lender non existing user Id")
	public void user_perform_GET_for_one_lender_non_existing_user_Id() {

	}

	@When("User have url for {string} with any non existing user-Id {int}")
	public void user_have_url_for_with_any_non_existing_user_Id(String string, int id) {
		lender.getLenderByNonExistingUserId(string, id);
	}

	@Then("Response status shows code {int}")
	public void response_status_shows_code(int code) {
		lender.statusCodeCheck(code);
	}

}