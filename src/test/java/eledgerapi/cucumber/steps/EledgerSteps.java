package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.EledgerImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EledgerSteps {

	@Steps
	EledgerImpl eledgerApi;

	@When("^Eledger GET request api hit$")
	public void studentGetRequestIsHit() {
		eledgerApi.provideUrl();
	}

	@Given("^A Eledger api url$")
	public void a_student_app_url() {
		eledgerApi.getRequest();
	}

	@Then("Response code should return {string} status code")
	public void response_code_should_return_status_code(String string) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("^I want to test transaction GET Api$")
	public void i_want_to_test_transaction_get_api() {

	}

	@When("I provide lenderId {string} and Date {string}")
	public void iProvideLenderIdAndDate(String string1, String string2) {
		eledgerApi.transactionGetUrl(string1, string2);
	}

	@Then("I should see the response code {string}")
	public void i_should_see_the_response_code(String string) {
		// Write code here that turns the phrase above into concrete actions
	}
}
