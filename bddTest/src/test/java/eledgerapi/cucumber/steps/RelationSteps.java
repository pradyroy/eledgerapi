package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.RelationImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RelationSteps {

	@Steps
	RelationImpl relationImpl;

//User wants list of relational users
	@Given("User perform GET API for list of relation users")
	public void userPerformGetApiForListOfRelationUsers() {
	}

	@When("User provides the required lenderId {string}")
	public void user_provide_the_Lender(String string) {
		relationImpl.getUsersByLenderId(string);
	}

	@Then("User should have status code {int} and message {string}")
	public void response_code_should_return_status_code(int int1, String string) {
		relationImpl.statusCodeCheck(int1);
		relationImpl.contentCheck("message", string);
	}

// User wants list of customer relational users with lenderId not exist
	@Given("User perform GET API for list of customer relation users with id not exist")
	public void userPerformGetApiForListOfRelationUsersWithIdNotExist() {
	}

	@When("User provides the required lenderId that not exist {string}")
	public void user_provide_the_required_lenderId_that_not_exist(String string) {
		relationImpl.getUsersByLenderIdThatNotExist(string);
	}

	@Then("User should see response with status code {int}")
	public void userShoudSeeResponseWithStatusCode(int int1) {
		relationImpl.statusCodeCheck(int1);
	}

//User wants list of reports relational users
	@Given("User perform GET API for list of reports relation users")
	public void userPerformGetApiForListOfReportRelationUsers() {
	}

	@When("User provides the required lenderId {string} for transaction API")
	public void user_provide_the_required_lenderId(String string) {
		relationImpl.getAllUsersByLenderId(string);
	}

	@Then("Response should have status code {int} with  message {string}")
	public void response_should_have_status_code_with_message(int int1, String string) {
		relationImpl.statusCodeCheck(int1);
		relationImpl.contentCheck("message", string);
	}

// User wants list of reports relational users with lenderId not exist
	@Given("User perform GET API for list of reports relation users with id not exist")
	public void userPerformGetApiForListOfReportsRelationUsersWithIdNotExist() {
	}

	@When("User provides the required lenderId {string} that not exist for transaction api")
	public void user_provide_the_required_lenderId_that_not_exist_for_transaction_api(String string) {
		relationImpl.getAllUsersByLenderIdThatNotExist(string);
	}

	@Then("User should see message {string}")
	public void userShouldSeeMessage(String string1) {
		relationImpl.contentCheck("message", string1);
	}
}