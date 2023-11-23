package week3Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncident {
	@Test
	public void getIncident() {
		//API Requirement
		//Add endpoint
		RestAssured.baseURI="https://dev135546.service-now.com/api/now/table";
		
		//Add authentication
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		
		//Construct Request
		RequestSpecification request = RestAssured.given().accept("application/xml");
		
		//Send Request
		Response response = request.post("/incident");
		
	   //get status code 
		int statusCode = response.getStatusCode();
		System.out.println("status code for get incident is :" +statusCode);
		
		response.prettyPrint();		
		
	}

}
