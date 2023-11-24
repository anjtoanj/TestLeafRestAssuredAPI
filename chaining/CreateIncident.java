package week4Day1.chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident extends BaseClass{
    @Test
	public void createIncident() {		
		
		response =request.post("/incident");
		sys_id = response.jsonPath().get("result.sys_id");
		response.then().assertThat().statusCode(201);
	}	
	

}
