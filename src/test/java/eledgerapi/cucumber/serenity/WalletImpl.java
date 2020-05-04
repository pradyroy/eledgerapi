package eledgerapi.cucumber.serenity;

import in.pune.royforge.eledgerapi.data.model.TransactionType;
import in.pune.royforge.eledgerapi.data.model.WalletTransaction;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;

public class WalletImpl {
	Response response;

	@Step
	public void postWalletRequest() {
		RestAssured.baseURI = "http://localhost:8080/wallet";
		response = postWallet("m13", 600d);
	}

	@Step
	public void getListOfWallets() {
		SerenityRest.rest().given().when().get("http://localhost:8080/wallet/wallets").then().statusCode(200);
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Step
	public void getByLenderId(String lenderId) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}").then().statusCode(200);
	}

	@Step
	public void getByLenderIdThatNotExist(String lenderId) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}").then().statusCode(404);
	}

	@Step
	public void getByLenderIdAndBorrowId(String lenderId, String borrowId) {
		SerenityRest.rest().given().with().pathParam("lenderId", lenderId).with().pathParam("borrowId", borrowId).when()
				.get("http://localhost:8080/wallet/lenderId/{lenderId}/borrowId/{borrowId}").then().assertThat()
				.statusCode(200).body("data.balance", equalTo(500.0f));
	}

	@Step
	public void getByWalletId(String walletId) {
		SerenityRest.rest().given().with().pathParam("walletId", walletId).when()
				.get("http://localhost:8080/wallet/walletId/{walletId}").then().statusCode(200)
				.body("data.lenderId", equalTo("m12"));
	}

	@Step
	public void deleteByWalletId(String walletId) {
		SerenityRest.rest().given().with().pathParam("walletId", walletId).when()
				.delete("http://localhost:8080/wallet/walletId/{walletId}").then().statusCode(200)
				.body("data", equalTo(true));
	}

	@Step
	public void getByWalletIdThatNotExist(String walletId) {
		SerenityRest.rest().given().with().pathParam("walletId", walletId).when()
				.get("http://localhost:8080/wallet/walletId/{walletId}").then().statusCode(404);
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