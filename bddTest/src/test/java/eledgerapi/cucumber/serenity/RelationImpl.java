package eledgerapi.cucumber.serenity;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;

import eledger.model.AuthRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RelationImpl {
	Response response;
//	@Autowired
//	TokenAuth token;
//
//	String token1 = token.jwtToken();
//	String token2 = jwtToken();

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
	public void contentCheck(String contentKey, String contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	@Step
	public void getUsersByLenderId(String lenderId) {
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken()).with()
				.pathParam("lenderId", lenderId).when().get("http://localhost:8100/relation/users/lenderId/{lenderId}");
	}

	@Step
	public void getUsersByLenderIdThatNotExist(String lenderId) {
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken()).with()
				.pathParam("lenderId", lenderId).when().get("http://localhost:8100/relation/users/lenderId/{lenderId}");
	}

	@Step
	public void getAllUsersByLenderId(String lenderId) {
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken()).with()
				.pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/relation/allusers/lenderId/{lenderId}");
	}

	@Step
	public void getAllUsersByLenderIdThatNotExist(String lenderId) {
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken()).with()
				.pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/relation/allusers/lenderId/{lenderId}");
	}
}
