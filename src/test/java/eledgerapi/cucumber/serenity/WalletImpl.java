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

public class WalletImpl {
	Response response;

	@Step
	public void postRequest() {
		RestAssured.baseURI = "http://localhost:8080/wallet";
		response = postCreateStudent("m12", 500d);
	}

	@Step
	public void getRequest() {
		SerenityRest.rest().given().when().get("http://localhost:8080/wallet/wallets").then().statusCode(200);
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.then().statusCode(201), statusCode);
	}

	public Response postCreateStudent(String lenderId, Double balance) {
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
