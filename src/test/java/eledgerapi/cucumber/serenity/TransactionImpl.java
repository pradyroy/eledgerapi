package eledgerapi.cucumber.serenity;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TransactionImpl {
	@Step
	public void transactionGetUrl(String lenderId, String date) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with().pathParam("date", date).when()
				.get("http://localhost:8080/transaction/lenderId/{lenderId}/date/{date}").then().statusCode(200);
	}

}
