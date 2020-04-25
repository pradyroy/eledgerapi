package eledgerapi.cucumber.serenity;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TransactionImpl {
	@Step
	public void transactionGetUrl(String lenderId, String date) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with().pathParam("date", date).when()
				.get("http://localhost:8080/transaction/lenderId/{lenderId}/date/{date}").then().statusCode(200);
	}

	
	public void getTransactionsList(String string) {
		SerenityRest.given().contentType(ContentType.JSON).when().get("http://localhost:8080/transaction/" + string)
				.then().statusCode(200);
	}

	
	public void getTransactionsListByLenderId(String path, String lenderId) {
		SerenityRest.given().contentType(ContentType.JSON).with().pathParam("path", path).with()
				.pathParam("lenderId", lenderId).when().get("http://localhost:8080/transaction/{path}/{lenderId}")
				.then().statusCode(200);
	}

	
	public void getTransactionsListByLenderIdAndBorrowId(String path, String lenderId, String path2, String borrowId) {
		SerenityRest.given().contentType(ContentType.JSON).with().pathParam("path", path).with()
				.pathParam("lenderId", lenderId).with().pathParam("path2", path2).with().pathParam("borrowId", borrowId)
				.when().get("http://localhost:8080/transaction/{path}/{lenderId}/{path2}/{borrowId}").then()
				.statusCode(200);

	}

	
	public void transactionsByLenderIdBetweenDates(String lenderId, String startDate, String endDate) {

		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with().pathParam("startDate", startDate).with().pathParam("endDate", endDate).when()
				.get("http://localhost:8080/transaction/lenderId/{lenderId}/startDate/{startDate}/endDate/{endDate}").then().statusCode(200);
	
	}
}
