package eledgerapi.cucumber.steps;

import eledgerapi.cucumber.serenity.WalletImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class WalletSteps {

    @Steps
    WalletImpl walletApi;

    @Given("I want to hit wallet POST api")
    public void i_want_to_hit_wallet_post_api() {
        walletApi.getRequest();
    }

    @When("I provide the walletTransaction object")
    public void iProvideTheWalletTransactionObject() {
        walletApi.postRequest();
    }

    @Then("Response code should return {} status code")
    public void response_code_should_return_status_code(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
}
