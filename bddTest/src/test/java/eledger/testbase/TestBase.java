package eledger.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8100/wallet";
		RestAssured.baseURI = "http://localhost:8100/transaction";
	}
}
