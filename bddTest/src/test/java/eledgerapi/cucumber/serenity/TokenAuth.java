package eledgerapi.cucumber.serenity;

import eledger.model.AuthRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

public class TokenAuth {

	public String jwtToken() {
		AuthRequest auth = new AuthRequest();
		auth.setUsername("8319972749");
		auth.setPassword("@Sahil123");
		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(auth)
				.post("http://localhost:8100/login").then().extract().path("token");
	}

}
