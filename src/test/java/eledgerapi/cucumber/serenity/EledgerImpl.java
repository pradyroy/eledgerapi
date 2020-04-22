package eledgerapi.cucumber.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import in.pune.royforge.eledgerapi.data.model.TransactionType;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

import java.util.Date;

public class EledgerImpl {
	Response response;

	@Step
	public void provideUrl() {
		RestAssured.baseURI = "http://localhost:8080/wallet";
		response = postCreateStudent("m11", "6565-6565", 300d);
	}

	@Step
	public void transactionGetUrl(String lenderId, String date) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with().pathParam("date", date).when()
				.get("http://localhost:8080/transaction/lenderId/{lenderId}/date/{date}").then().statusCode(200);
	}

	@Step
	public void getRequest() {
		SerenityRest.rest().given().when().get("http://localhost:8080/wallet/wallets").then().statusCode(200);
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.then().statusCode(201), statusCode);
	}

	public Response postCreateStudent(String lenderId, String borrowId, Double balance) {
		Date currentDate = new Date();
		WalletTransaction wallet = new WalletTransaction();
		wallet.setLenderId(lenderId);
		wallet.setAmount(balance);
		wallet.setCreatedDate(currentDate);
		wallet.setUpdatedDate(currentDate);
		wallet.setTxnType(TransactionType.CREDIT);
		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(wallet)
				.post("http://localhost:8080/wallet");
	}
}
