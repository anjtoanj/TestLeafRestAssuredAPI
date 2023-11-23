package week3Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateChangeRequest {
	@Test
	public void createChangeRequest() {
		//end point
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		
		//authentication
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		
		//request body
		RequestSpecification request = RestAssured.given().contentType("application/json")
										.accept("application/xml")
										.body("{\r\n"
												+ "        \"short_description\": \"Created through postman\"\r\n"
												+ "}");		
		//send request
		Response response = request.get("/change_request");
		//check status code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	
		//print response body
		response.prettyPrint();
		
	}

}
