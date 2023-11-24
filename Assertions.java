package week4Day1;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assertions {
	@Test
	   public void getIncident() {
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		RequestSpecification request = RestAssured.given().contentType("application/json");
		Response response = request.post("/incident");
		int statusCode = response.getStatusCode();	
		response.prettyPrint();				
	   }
		@Test
		public void simpleAssert() {
			RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
			RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
			
			RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
			Response response = input.post("/incident");
			response.then().assertThat().statusCode(201);		
		}
		@Test
		public void assertEquals() {
			RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
			RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
						
			RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
			Response response = input.get("/incident");
			response.then().assertThat().body("result[0].number", Matchers.equalTo("INC0000060"));	
		}
		
		@Test
		public void assertContains() {
			RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
			RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
						
			RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
			Response response = input.get("/incident");
			response.then().assertThat().body("result[0].number",Matchers.containsString("INC"));	
		}
		@Test
		public void assertHasItem() {
			RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
			RestAssured.authentication= RestAssured.basic("admin","vb-Ou7h^3AVM");
						
			RequestSpecification input = RestAssured.given().contentType(ContentType.JSON);
			Response response = input.get("/incident");
			response.then().assertThat().body("result.number",Matchers.hasItem("INC0010202"));	
		}
}
