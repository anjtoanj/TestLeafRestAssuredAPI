package week3Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateincidentWithQueryParams {
	public void createIncidentWithQueryParam() {
		//endpoint
		RestAssured.baseURI ="https://dev135546.service-now.com/api/now/table";
		RestAssured.authentication = RestAssured.basic("admin", "");
		RequestSpecification request = RestAssured.given().contentType("application/json")
											.accept("application/xml")
											.body("{\r\n"
													+ "    \"description\": \"Created in postman\",\r\n"
													+ "    \"short_description\": \"checking\"\r\n"
													+ "}")
											.queryParam("sysparm_fields", "number,description,sys_id");
		Response response = request.post("/incident");
		int statusCode = response.getStatusCode();
		System.out.println("Status code- "+statusCode);
		response.prettyPrint();
	}

}
