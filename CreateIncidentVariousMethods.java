package week4Day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentVariousMethods {
	@Test
	public void createIncident() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
		Response response = input.post("/incident");
		response.prettyPrint();
		
	}
	@Test
	public void createIncidentWithString() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"short_description\": \"{{short_desc}}\",\r\n"
						+ "    \"description\": \"{{desc}}\"\r\n"
						+ "}");
		Response response = input.post("/incident");
		response.prettyPrint();
		
	}
	@Test
	public void createIncidentWithFile() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
		
		File file = new File("./src/test/resources/DataFileJs.json");
		RequestSpecification input = RestAssured.given().contentType(ContentType.JSON).body(file);
		Response response = input.post("/incident");
		response.prettyPrint();
		
	}

}
