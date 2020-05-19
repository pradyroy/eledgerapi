package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.EmailImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EmailSteps {

	@Steps
	EmailImpl emailImpl;

//POST API to send Reset Password Mail
	@Given("User want to send Password Recovery Mail")
	public void iWantToHitCustomerPostApi() {
	}

	@When("User provide name {string}  and email {string}")
	public void IProvideTheCustomerDataObject(String string1, String string2) {
		emailImpl.postResetPasswordMail(string1, string2);
	}

	@Then("User verify the Response {int}")
	public void userVerifyTheResponse(int int1) {
		emailImpl.statusCodeCheck(int1);
	}

//POST API to send New Customer Addition Mail
	@Given("User want to send New Customer Addition Mail")
	public void userWantToSendNewCustomerAdditionMail() {
	}

	@When("User provide the details {string}  and {string}")
	public void userProvideTheDetails(String string1, String string2) {
		emailImpl.postNewCustomerMail(string1, string2);
	}

	@Then("User should receive the Response {int}")
	public void userShouldReceiveTheResponse(int int1) {
		emailImpl.statusCodeCheck(int1);
	}

//POST API to send Welcome Mail on Signup
	@Given("User want to send Welcome Mail on Signup")
	public void userWantToSendWelcomeMailOnSignup() {
	}

	@When("User provide the name and email address {string}  and {string}")
	public void userProvideTheNameAndEmailAddress(String string1, String string2) {
		emailImpl.postSignupMail(string1, string2);
	}

	@Then("User should receive the message {string}")
	public void userShouldReceiveTheStatusCode(String string1) {
		emailImpl.contentCheck("message", string1);
	}
}
