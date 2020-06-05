package eledgerapi.cucumber.serenity;

import org.junit.Assert;

import eledger.model.AuthRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TransactionImpl {

	Response response;
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
	public void transactionGetUrl(String lenderId, String date) {
		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken()).with()
				.pathParam("lenderId", lenderId).with().pathParam("date", date).when()
				.get("http://localhost:8100/transaction/lenderId/{lenderId}/date/{date}");
	}

	public void getTransactionsList(String string) {
		response = SerenityRest.given().header("Authorization", "Bearer " + jwtToken()).contentType(ContentType.JSON)
				.when().get("http://localhost:8100/transaction/" + string);
	}

	public void getTransactionsListByLenderId(String path, String lenderId) {
		response = SerenityRest.given().header("Authorization", "Bearer " + jwtToken()).contentType(ContentType.JSON)
				.with().pathParam("path", path).with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/transaction/{path}/{lenderId}");
	}

	public void getTransactionsListByNonExistingLenderId(String path, String lenderId) {
		response = SerenityRest.given().header("Authorization", "Bearer " + jwtToken()).contentType(ContentType.JSON)
				.with().pathParam("path", path).with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8100/transaction/{path}/{lenderId}");
	}

	public void getTransactionsListByLenderIdAndBorrowId(String path, String lenderId, String path2, String borrowId) {
		response = SerenityRest.given().header("Authorization", "Bearer " + jwtToken()).contentType(ContentType.JSON)
				.with().pathParam("path", path).with().pathParam("lenderId", lenderId).with().pathParam("path2", path2)
				.with().pathParam("borrowId", borrowId).when()
				.get("http://localhost:8100/transaction/{path}/{lenderId}/{path2}/{borrowId}");

	}

	public void getTransactionsByNonExistingLenderIdAndBorrowId(String path, String lenderId, String path2,
			String borrowId) {
		response = SerenityRest.given().header("Authorization", "Bearer " + jwtToken()).contentType(ContentType.JSON)
				.with().pathParam("path", path).with().pathParam("lenderId", lenderId).with().pathParam("path2", path2)
				.with().pathParam("borrowId", borrowId).when()
				.get("http://localhost:8100/transaction/{path}/{lenderId}/{path2}/{borrowId}");

	}

	public void transactionsByLenderIdBetweenDates(String lenderId, String startDate, String endDate) {

		response = SerenityRest.rest().given().header("Authorization", "Bearer " + jwtToken()).with()
				.pathParam("lenderId", lenderId).with().pathParam("startDate", startDate).with()
				.pathParam("endDate", endDate).when()
				.get("http://localhost:8100/transaction/lenderId/{lenderId}/startDate/{startDate}/endDate/{endDate}");
	}
}
