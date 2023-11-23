package week3Day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {
	
	  
	@Test
	public void updateIncident(){
	
	        //Add endpoints
		    RestAssured.baseURI="https://dev135546.service-now.com/api/now/table" ;
		    
		    //Add authentication
		    RestAssured.authentication =RestAssured.basic("admin","vb-Ou7h^3AVM");
		    
		    // Construction of Request
		    RequestSpecification inputRequest = RestAssured.given()
		    		                            .contentType("application/json")// specifies the input request format
		    		                            .when()
		    		                            .body("{\r\n"
		    		                         		+ "    \"short_description\": \"My first created via RestAssured1\",\r\n"
		    		                         		+ "    \"description\": \"Created with RestAssured1\"\r\n"
		    		                         		+ "}");
		    //Send Request
		    Response response = inputRequest.put("/incident/dfafdc7f476af11089fa2646926d43a2");
		    response.then().assertThat().statusCode(200);
		    
		    //get status code
		    int statusCode = response.getStatusCode();
		    System.out.println("status code for create incident is :" +statusCode);
		    
		    //Print response
		    response.prettyPrint();
	}

}
