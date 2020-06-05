package eledgerapi.cucumber.serenity;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import eledger.model.AuthRequest;
import eledger.model.EmailData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmailImpl {
	Response response;
	@Autowired
	TokenAuth token;

	public String jwtToken() {
		AuthRequest auth = new AuthRequest();
		auth.setUsername("8319972749");
		auth.setPassword("@Sahil123");
		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(auth)
				.post("http://localhost:8100/login").then().extract().path("token");
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Step
	public void postResetPasswordMail(String name, String email) {
		RestAssured.baseURI = "http://localhost:8100/reset-password";
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken())
				.contentType(ContentType.JSON).when().body(postEmailData(name, email, "Prem Singh"))
				.post("http://localhost:8100/reset-password");
	}

	@Step
	public void postNewCustomerMail(String name, String email) {
		RestAssured.baseURI = "http://localhost:8100/new-customer";
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken())
				.contentType(ContentType.JSON).when().body(postEmailData(name, email, "Prem Singh"))
				.post("http://localhost:8100/new-customer");
	}

	@Step
	public void postSignupMail(String name, String email) {
		RestAssured.baseURI = "http://localhost:8100/signup";
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken())
				.contentType(ContentType.JSON).when().body(postEmailData(name, email, "Prem Singh"))
				.post("http://localhost:8100/signup");
	}

	@Step
	public void contentCheck(String contentKey, String contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	// Method to push customer data to database
	private EmailData postEmailData(String name, String email, String customerName) {
		EmailData emailData = new EmailData();
		emailData.setName(name);
		emailData.setEmail(email);
		emailData.setCustomerName(customerName);
		return emailData;
	}
}