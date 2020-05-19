package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.CustomersImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CustomerSteps {

	@Steps
	CustomersImpl customerImpl;

//POST API to create new customer
	@Given("User want to create a new Customer")
	public void iWantToHitCustomerPostApi() {
	}

	@When("User provide the CustomerData Object")
	public void IProvideTheCustomerDataObject() {
		customerImpl.postCustomerData();
	}

	@Then("User verify the Response code {int}")
	public void IVerifyTheResponseCode(int int1) {
		customerImpl.statusCodeCheck(int1);
	}

//All Customers GET API to get all customers including deleted
	@Given("User want to get all customers including deleted")
	public void iWantToHitAllCustomersGetApi() {
	}

	@When("User provide the {string} url")
	public void IProvideTheUrl(String string) {
		customerImpl.getListOfAllCustomers(string);
	}

	@Then("User should see status code {int}")
	public void responseShouldHaveStatusCode(int int1) {
		customerImpl.statusCodeCheck(int1);
	}

//Customers GET API to get list of customers
	@Given("User want to get all customers")
	public void iWantToHitCustomersGetApi() {
	}

	@When("User provide the {string} url for Customers GET API")
	public void IProvideTheUrlForCustomersGetApi(String string) {
		customerImpl.getListOfCustomers(string);
	}

	@Then("Api should return responseCode {string}")
	public void responseShouldReturnStatusCode(String string) {
		customerImpl.contentCheck("responseCode", string);
	}

//Customer GET API to get customer by Id
	@Given("User want to get Customer by using Id")
	public void iWantToHitCustomersGetApiWithId() {
	}

	@When("User provide the id {string} for Customer GET API")
	public void IProvideTheIdForCustomersGetApi(String string) {
		customerImpl.getCustomerById(string);
	}

	@Then("Response should return name of customer {string}")
	public void responseShouldReturnNameOfCustomer(String string) {
		customerImpl.contentCheck("data.name", string);
	}

//Customer GET API to get customer by Id that not exist
	@Given("User want to get customers by id that not exist")
	public void iWantToHitCustomersGetApiWithIdThatNotExist() {
	}

	@When("User provide the not existed id {string} for Customer GET API")
	public void IProvideTheNotExistedIdForCustomersGetApi(String string) {
		customerImpl.getCustomerByIdThatNotExisted(string);
	}

	@Then("Response should return status {int}")
	public void responseShouldReturnStatus(int int1) {
		customerImpl.statusCodeCheck(int1);
	}

//Customer DELETE API to delete customer by Id
	@Given("User performs a POST Operation to create customer")
	public void user_performs_a_POST_Operation_to_create_customer() {
		customerImpl.postDataToDelete();
	}

	@Given("User wants to delete created customer by using id")
	public void user_wants_to_delete_created_customer_by_using_id() {
	}

	@When("User provide the id for Customer DELETE API")
	public void user_provide_the_id_for_Customer_DELETE_API() {
		customerImpl.deleteCustomerById();
	}

	@Then("Response should return data message {string}")
	public void responseShouldReturnDataMessage(String string) {
		customerImpl.contentCheck("data", Boolean.valueOf(string));
	}

//Customer DELETE API to delete customer by Id that not exist
	@Given("User want to delete customer by id that not exist")
	public void iWantToHitCustomerDeleteApiWithIdThatNotExist() {
	}

	@When("User provide the not existed id {string} for Customer DELETE API")
	public void IProvideTheNotExistedIdForCustomerDeleteApi(String string) {
		customerImpl.deleteCustomerByIdThatNotExisted(string);
	}

	@Then("Response should return {int} status code with message {string}")
	public void responseShouldReturnStatusCodeWithMessage(int int1, String string) {
		customerImpl.statusCodeCheck(int1);
		customerImpl.contentCheck("message", string);
	}
}