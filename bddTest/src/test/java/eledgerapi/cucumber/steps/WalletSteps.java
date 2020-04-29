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
	@Given("^User wants to create a wallet$")
	public void i_want_to_hit_wallet_post_api() {
		walletApi.getListOfWallets();
	}

	@When("User provide the walletTransaction object")
	public void iProvideTheWalletTransactionObject() {
		walletApi.postWalletRequest();
	}

	@Then("Response code should return {int} status code")
	public void response_code_should_return_status_code(int int1) {
		walletApi.statusCodeCheck(int1);
	}

// Wallet GET API using lenderId
	@Given("^User wants to get wallet by using lenderId$")
	public void i_want_to_hit_wallet_get_api() {
	}

	@When("User provide the lenderId {string}")
	public void iProvideTheLenderId(String string) {
		walletApi.getByLenderId(string);
	}

	@Then("Response should return {int} status code")
	public void response_should_return_status_code(int int1) {
		// Write code here that turns the phrase above into concrete actions
	}

//Wallet GET API using lenderId that not exist
	@Given("^User wants to get wallet by using lenderId that not exist$")
	public void i_want_to_call_wallet_get_api_with_lenderId() {
	}

	@When("User provide value of lenderId {string}")
	public void iProvideValueOfLenderId(String string) {
		walletApi.getByLenderIdThatNotExist(string);
	}

	@Then("Api should return {int} status code")
	public void api_should_return_status_code(int int1) {
	}

//Wallet GET API using lenderId and borrowId
	@Given("^User wants to get wallet by using lenderId and borrowerId$")
	public void i_want_to_call_wallet_get_api_with_lenderId_and_borrowId() {
	}

	@When("User provide value of lenderId {string} and borrowId {string}")
	public void iProvideValueOfLenderIdAndBorrowId(String string1, String string2) {
		walletApi.getByLenderIdAndBorrowId(string1, string2);
	}

	@Then("Api should contain balance {int}")
	public void api_should_contain_balance(int int1) {

	}

//Wallet GET API using walletId
	@Given("^User wants to get wallet by using walletId$")
	public void i_want_to_call_wallet_get_api_with_walletId() {
	}

	@When("User provide the walletId {string}")
	public void iProvideTheWalletId(String string) {
		walletApi.getByWalletId(string);
	}

	@Then("Response should match lenderId {string}")
	public void responseShouldMatchLenderId(String string) {
	}

//Delete Wallet using walletId
	@Given("^User wants to delete wallet by using walletId$")
	public void i_want_to_hit_wallet_delete_api() {
	}

	@When("User provide the walletId {string} for DELETE API")
	public void iProvideTheWalletIdForDeleteApi(String string) {
		walletApi.deleteByWalletId(string);
	}

	@Then("Response should return data {string}")
	public void responseShouldReturnData(String string) {
	}

//Wallet GET API after deleting the wallet
	@Given("^User wants to get wallet by using walletId after deleting that wallet$")
	public void iWantToHitWalletGetApiAfterDeleteApi() {

	}

	@When("User provide the deleted walletId {string}")
	public void iProvideTheDeletedWalletId(String string) {
		walletApi.getByWalletIdThatNotExist(string);
	}

	@Then("Response should match status code {string}")
	public void responseShouldMatchStatusCode(String string) {
	}

// Delete Wallet using walletId that not exist
	@Given("^User wants to delete wallet by using walletId that not exist$")
	public void i_want_to_hit_wallet_delete_api_with_not_existed_walletId() {
	}

	@When("User provide the not existed walletId {string} for DELETE API")
	public void iProvideTheNotExistedWalletIdForDeleteApi(String string) {
		walletApi.deleteByWalletIdThatNotExist(string);
	}

	@Then("Response should return responseCode {string}")
	public void responseShouldReturnResponseCode(String string) {
	}

//Wallet GET API to get list of wallets
	@Given("^User wants to get list of wallets$")
	public void iWantToHitWalletListGetApi() {
	}

	@When("User provide url for list {string}")
	public void iProvideUrlForList(String string) {
		walletApi.getListOfWallets();
	}

	@Then("Status code should be {int}")
	public void statusCodeShouldBe(int int1) {
	}
}
