package eledgerapi.cucumber.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;

import in.pune.royforge.eledgerapi.data.model.TransactionType;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;

public class WalletImpl {
	Response response;

	@Step
	public void postRequest() {
		RestAssured.baseURI = "http://localhost:8080/wallet";
		response = postWallet("m12", 500d);
	}

	@Step
	public void getRequest() {
		SerenityRest.rest().given().when().get("http://localhost:8080/wallet/wallets").then().statusCode(200);
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Step
	public void walletGetByLenderId(String lenderId) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}").then().statusCode(200);
	}

	@Step
	public void walletGetByLenderIdThatNotExist(String lenderId) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}").then().statusCode(404);
	}

	@Step
	public void walletGetByLenderIdAndBorrowId(String lenderId, String borrowId) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with().pathParam("borrowId", borrowId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}/borrowId/{borrowId}").then().assertThat()
				.statusCode(200).body("data.balance", equalTo(500.0f));
	}

	public Response postWallet(String lenderId, Double balance) {
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