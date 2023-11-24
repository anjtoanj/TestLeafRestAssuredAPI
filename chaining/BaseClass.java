package week4Day1.chaining;

import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	static RequestSpecification request = null;
	static String sys_id = null;
	static Response  response= null;
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		request=RestAssured.given().contentType(ContentType.JSON).log().all();
	}
	
	@AfterMethod
	public void tearDown() {
		response.then().log().all();
	}

}
