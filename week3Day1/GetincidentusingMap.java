package week3Day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetincidentusingMap {
	@Test
	public void getIncidentUsingMap() {
		RestAssured.baseURI = "https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "vb-Ou7h^3AVM");
		
		//Construct Request
		Map<String,String> multipleQP = new HashMap<String,String>();
		multipleQP.put("sysparm_fields","number,description,sys_id");
		multipleQP.put("sysparam_limit","1");
		RequestSpecification request = RestAssured
				                      .given()
				                      .accept("application/xml")
				                      .queryParams(multipleQP);
		Response response = request.post("/incident");
	}
}
