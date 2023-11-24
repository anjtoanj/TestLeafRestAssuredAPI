package week4Day1;

import java.util.regex.Matcher;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssertionsChangeRequest {

	@Test
	public void createChangeRequest() {

		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response = request.post("/change_request");
		response.then().assertThat().statusCode(201);
	}
	@Test 
	public void getChangeRequest() {

		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response = request.get("/change_request");
		response.then().assertThat().statusCode(200);
	}
	@Test
	public void assertHasItem() {

		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response = request.get("/change_request");
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("result.number", Matchers.hasItem("CHG0030031"));
	
	}

}
