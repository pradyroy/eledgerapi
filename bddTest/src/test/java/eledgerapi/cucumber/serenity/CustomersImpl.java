package eledgerapi.cucumber.serenity;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.UUID;

import org.junit.Assert;

import eledger.model.CustomerData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CustomersImpl {
	Response response;
	int id;

	@Step
	public void postCustomerData() {
		RestAssured.baseURI = "http://localhost:8100/customer";
		response = postCreateCustomer("Prem Raj", 1212121215l, "m6");
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Step
	public void contentCheck(String contentKey, String contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	@Step
	public void contentCheck(String contentKey, Boolean contentValue) {
		response.then().assertThat().body(contentKey, equalTo(contentValue));
	}

	@Step
	public void getListOfAllCustomers(String url) {
		response = SerenityRest.rest().given().with().pathParam("url", url).when()
				.get("http://localhost:8100/customer/{url}");
	}

	@Step
	public void getListOfCustomers(String url) {
		response = SerenityRest.rest().given().with().pathParam("url", url).when()
				.get("http://localhost:8100/customer/{url}");
	}

	@Step
	public void getCustomerById(String id) {
		response = SerenityRest.rest().given().with().pathParam("id", id).when()
				.get("http://localhost:8100/customer/customer/{id}");
	}

	@Step
	public void getCustomerByIdThatNotExisted(String id) {
		response = SerenityRest.rest().given().with().pathParam("id", id).when()
				.get("http://localhost:8100/customer/customer/{id}");
	}

	@Step
	public void postDataToDelete() {
		RestAssured.baseURI = "http://localhost:8100/customer";
		response = postCreateCustomer("Delete Test", 1212121214l, "m5");
	}

	@Step
	public void deleteCustomerById() {
		id = response.then().extract().path("data.id");
		response = SerenityRest.rest().given().when().delete("http://localhost:8100/customer/customer/" + id);
	}

	@Step
	public void deleteCustomerByIdThatNotExisted(String id) {
		response = SerenityRest.rest().given().with().pathParam("id", id).when()
				.delete("http://localhost:8100/customer/customer/{id}");
	}

	// Method to push customer data to database
	private Response postCreateCustomer(String name, Long phone, String lenderId) {
		CustomerData customerData = new CustomerData();
		UUID uuId = UUID.randomUUID();
		customerData.setName(name);
		customerData.setPhone(phone);
		customerData.setBorrowId(uuId.toString());
		customerData.setLenderId(lenderId);
		customerData.setIsDeleted(false);
		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(customerData)
				.post("http://localhost:8100/customer");
	}
}