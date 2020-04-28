package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.TransactionImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TransactionSteps {

	@Steps
	TransactionImpl transactionApi;

// Get Transactions using lender Id and Date
	@Given("I want to test transaction GET Api")
	public void i_want_to_test_transaction_get_api() {
	}

	@When("I provide lenderId {string} and Date {string}")
	public void iProvideLenderIdAndDate(String string1, String string2) {
		transactionApi.transactionGetUrl(string1, string2);
	}

	@Then("I should see the response code {string}")
	public void i_should_see_the_response_code(String string) {
		System.out.println("Successfuly get transactions by lender id and dates");
	}

// Get list of all transactions
	@Given("I perform GET for transactions")
	public void i_perform_get_transactions() {
	}

	@When("I have url for {string}")
	public void iProvideTransactions(String string) {
		transactionApi.getTransactionsList(string);
	}

	@Then("Response status should be {string}")
	public void iShouldGetResponse(String string) {
		System.out.println("This is the complete list of transactions");
	}

// Get transactions by lender Id	
	@Given("I perform GET transaction by lender Id")
	public void i_perform_GET_transaction_by_lender_Id() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("I provide path {string} and lender Id {string}")
	public void i_provide_lender_Id(String path, String Id) {
		transactionApi.getTransactionsListByLenderId(path, Id);
	}

	@Then("Response status is {string}")
	public void responseStatus(String string) {
		System.out.println("This is the complete list of transactions by LenderId");
	}

//Error Message- Get transactions by non-existing lender Id	
	@Given("I perform GET transaction by non existing lender Id")
	public void get_transaction_by_non_existing_lender_Id() {

	}

	@When("I provide path {string} and non existing lender Id {string}")
	public void nonExisting_lender_Id(String path, String Id) {
		transactionApi.getTransactionsListByNonExistingLenderId(path, Id);
	}

	@Then("Not Found status should match {string}")
	public void not_Found_status_should_match(String string) {

	}

//Error message- transactions by non existing lender Id and borrower Id
	@Given("I perform GET transaction by non_existing lender Id or borrowerId")
	public void get_transaction_by_non_existing_lender_Id_or_borrowerId() {
	}

	@When("I provide path {string} with {string} and wrong {string} with {string}")
	public void i_provide_path_with_nonExisting_lender_and_borrower(String lender, String lenderid, String borrow,
			String borrowerId) {
		transactionApi.getTransactionsByNonExistingLenderIdAndBorrowId(lender, lenderid, borrow, borrowerId);
	}

	@Then("Not Found status matches {string}")
	public void not_Found_status_matches(String string) {
	}

//Get transactions by lender Id and borrower Id
	@Given("I perform GET transaction by lender Id and borrower Id")
	public void i_perform_GET_transaction_by_lenderId_and_borrowerId() {
	}

	@When("I provide path {string} with {string} and {string} with {string}")
	public void i_provide_path_with_lender_and_borrower(String lender, String lenderid, String borrow,
			String borrowerId) {
		transactionApi.getTransactionsListByLenderIdAndBorrowId(lender, lenderid, borrow, borrowerId);
	}

	@Then("Response status code is {string}")
	public void responseStatusByLenderAndBorrower(String string) {
		System.out.println("This is the complete list of transactions by LenderId and BorrowerId");
	}

// Get transaction by lender Id between two dates
	@Given("I want to test transaction GET Api by lenderId, Start and End Date")
	public void i_want_to_test_transaction_GET_Api_by_lenderId_Start_and_End_Date() {
	}

	@When("I provide lenderId {string} between Dates {string} to {string}")
	public void i_provide_lenderId_between_Dates_to(String lenderId, String startDate, String endDate) {
		transactionApi.transactionsByLenderIdBetweenDates(lenderId, startDate, endDate);
	}

	@Then("I should have the response code {string}")
	public void i_should_have_the_response_code(String string) {
	}
}
