package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.TransactionImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TransactionSteps {

	@Steps
	TransactionImpl transactionApi;

	@Given("^I want to test transaction GET Api$")
	public void i_want_to_test_transaction_get_api() {

	}

	@When("I provide lenderId {string} and Date {string}")
	public void iProvideLenderIdAndDate(String string1, String string2) {
		transactionApi.transactionGetUrl(string1, string2);
	}

	@Then("I should see the response code {string}")
	public void i_should_see_the_response_code(String string) {
		// Write code here that turns the phrase above into concrete actions
	}
}
