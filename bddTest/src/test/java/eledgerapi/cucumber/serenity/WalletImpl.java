package eledgerapi.cucumber.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import eledger.model.TransactionType;
import eledger.model.WalletTransaction;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Date;

public class WalletImpl {
	Response response;
	int walletId;

	@Step
	public void postWalletRequest() {
		RestAssured.baseURI = "http://localhost:8080/wallet";
		response = postWallet("TestId1", 600d);
	}

	@Step
	public void getListOfWallets() {
		response = SerenityRest.rest().given().when().request().get("http://localhost:8080/wallet/wallets");
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	public void contentCheck(String contentKey, String contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	public void contentCheck(String contentKey, float contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	@Step
	public void getByLenderId(String lenderId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}");

	}

	@Step
	public void getByLenderIdThatNotExist(String lenderId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}");
	}

	@Step
	public void getByLenderIdAndBorrowId(String lenderId, String borrowId) {
		response = SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with()
				.pathParam("borrowId", borrowId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}/borrowId/{borrowId}");
	}

	@Step
	public void getByWalletId(String walletId) {
		response = SerenityRest.rest().given().with().pathParam("walletId", walletId).when()
				.get("http://localhost:8080/wallet/walletId/{walletId}");
	}

	@Step
	public void deleteByWalletId() {
		walletId = response.then().extract().path("data.walletId");
		response = SerenityRest.rest().given().when().delete("http://localhost:8080/wallet/walletId/" + walletId);
	}

	@Step
	public void getByWalletIdThatNotExist(String walletId) {
		response = SerenityRest.rest().given().with().pathParam("walletId", walletId).when()
				.get("http://localhost:8080/wallet/walletId/{walletId}");
	}

	@Step
	public void deleteByWalletIdThatNotExist(String walletId) {
		response = SerenityRest.rest().given().with().pathParam("walletId", walletId).when()
				.delete("http://localhost:8080/wallet/walletId/{walletId}");
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