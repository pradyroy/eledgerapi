package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.WalletImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class WalletSteps {

	@Steps
	WalletImpl walletApi;

//Wallet POST API to create new wallet
	@Given("^I want to hit wallet POST api$")
	public void i_want_to_hit_wallet_post_api() {
		walletApi.getRequest();
	}

	@When("^I provide the walletTransaction object$")
	public void iProvideTheWalletTransactionObject() {
		walletApi.postRequest();
	}

	@Then("Response code should return {int} status code")
	public void response_code_should_return_status_code(int int1) {
		// Write code here that turns the phrase above into concrete actions
		walletApi.statusCodeCheck(int1);
	}

// Wallet GET API using lenderId
	@Given("^I want to hit wallet GET API$")
	public void i_want_to_hit_wallet_get_api() {

	}

	@When("I provide the lenderId {string}")
	public void iProvideTheLenderId(String string) {
		walletApi.walletGetByLenderId(string);
	}

	@Then("Response should return {int} status code")
	public void response_should_return_status_code(int int1) {
		// Write code here that turns the phrase above into concrete actions
	}

//Wallet GET API using lenderId that not exist
	@Given("^I want to call wallet GET API with lenderId$")
	public void i_want_to_call_wallet_get_api_with_lenderId() {

	}

	@When("I provide value of lenderId {string}")
	public void iProvideValueOfLenderId(String string) {
		walletApi.walletGetByLenderIdThatNotExist(string);
	}

	@Then("Api should return {int} status code")
	public void api_should_return_status_code(int int1) {
	}

//Wallet GET API using lenderId and borrowId
	@Given("^I want to call wallet GET API with lenderId and borrowId$")
	public void i_want_to_call_wallet_get_api_with_lenderId_and_borrowId() {

	}

	@When("I provide value of lenderId {string} and borrowId {string}")
	public void iProvideValueOfLenderIdAndBorrowId(String string1, String string2) {
		walletApi.walletGetByLenderIdAndBorrowId(string1, string2);
	}

	@Then("Api should contain balance {int}")
	public void api_should_contain_balance(int int1) {

	}
}
