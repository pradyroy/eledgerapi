package eledgerapi.cucumber.serenity;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RelationImpl {
	Response response;

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Step
	public void contentCheck(String contentKey, String contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	@Step
	public void getUsersByLenderId(String lenderId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/relation/users/lenderId/{lenderId}");
	}

	@Step
	public void getUsersByLenderIdThatNotExist(String lenderId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/relation/users/lenderId/{lenderId}");
	}

	@Step
	public void getAllUsersByLenderId(String lenderId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/relation/allusers/lenderId/{lenderId}");
	}

	@Step
	public void getAllUsersByLenderIdThatNotExist(String lenderId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/relation/allusers/lenderId/{lenderId}");
	}
}
