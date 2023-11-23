package week3Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident {

	@Test
	public void deletIncident() {
		RestAssured.baseURI ="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin","vb-Ou7h^3AVM");
		
		RequestSpecification request = RestAssured.given()
										.contentType("application/json");
		
		Response response = request.delete("/incident/2f9124ff476af11089fa2646926d435f");
		ValidatableResponse vResponse = response.then().assertThat().statusCode(204);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is -"+statusCode);				
	}
}
