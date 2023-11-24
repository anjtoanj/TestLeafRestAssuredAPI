package week4Day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Logs {
	@Test
	public void createIncidentWithFile() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table/incident";
		RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
		
		File file = new File("./src/test/resources/DataFileJs.json");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).body(file).log().all();
		Response response = input.post();
		response.then().log().all();
	}	
}
