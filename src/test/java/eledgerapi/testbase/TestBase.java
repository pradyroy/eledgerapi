package eledgerapi.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://localhost:8080/wallet";
		RestAssured.baseURI = "http://localhost:8080/transaction";
	}
}
