package eledgerapi.cucumber.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import eledger.model.LenderData;


public class LenderImpl {
	Response response;

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Step
	public void postLenderUrl() {
		RestAssured.baseURI = "http://localhost:8100/lender";
		response = postCreateLender("Sahil K", "sk@gmail.com", "sk1", "Sahil@123", 1234567890L, "SK Info");
	}

	@Step
	public void getLendersList() {
		response = SerenityRest.rest().given().when().get("http://localhost:8100/lender/lenders");
	}

	@Step
	public void getLenderByUserId(String path, int userId) {
		response = SerenityRest.rest().given().with().pathParam("path", path).with().pathParam("id", userId).when()
				.get("http://localhost:8100/lender/{path}/{id}");
	}

	@Step
	public void getLenderByNonExistingUserId(String path, int userId) {
		response = SerenityRest.rest().given().with().pathParam("path", path).with().pathParam("id", userId).when()
				.get("http://localhost:8100/lender/{path}/{id}");
	}

	public Response postCreateLender(String Name, String email, String lenderId, String password, Long phone,
			String shopName) {
		LenderData lender = new LenderData();
		lender.setName(Name);
		lender.setLenderId(lenderId);
		lender.setEmail(email);
		lender.setPassword(password);
		lender.setPhone(phone);
		lender.setShopName(shopName);

		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(lender)
				.post("http://localhost:8100/lender");
	}
}