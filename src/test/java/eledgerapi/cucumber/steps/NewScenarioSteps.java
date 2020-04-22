package eledgerapi.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewScenarioSteps {

    @Given("elegder url is there")
    public void elegder_url_is_there() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("put your given url here");
    }


    @When("url is hit")
    public void url_is_hit() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("url should be hit from here");

    }

    @Then("repons code success should be returned")
    public void repons_code_success_should_be_returned() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("assertion should be done here");
    }
}
