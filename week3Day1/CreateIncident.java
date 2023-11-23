package week3Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateIncident {
    @Test
	public void incidentCreation() {
	
    //Requirement(API document)
    	
    	
    //Add endpoints
    RestAssured.baseURI="https://dev135546.service-now.com/api/now/table" ;
    
    //Add authentication
    RestAssured.authentication =RestAssured.basic("admin", "vb-Ou7h^3AVM");
    
    // Construction of Request
    RequestSpecification inputRequest = RestAssured.given()
    		                            .contentType("application/json")// specifies the input request format
    		                            .accept("application/xml")
    		                            .when().body("{\r\n"
    		                         		+ "    \"short_description\": \"My first created via Postman\",\r\n"
    		                         		+ "    \"description\": \"Created with Postman\"\r\n"
    		                         		+ "}");
    //Send Request
    Response response = inputRequest.post("/incident");
    
    //get status code
    int statusCode = response.getStatusCode();
    System.out.println("status code for create incident is :" +statusCode);
    
    //Print response
    response.prettyPrint();
	}

}
