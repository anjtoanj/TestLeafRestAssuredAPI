package week4Day1.chaining;

import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass{
	@Test(dependsOnMethods = {"week4Day1.chaining.CreateIncident.createIncident"})
	public void updateIncident() {		
		request.given().contentType("application/json")
			   .when()
		       .body("{\r\n"
		         		+ "     \"short_description\": \"using put method for hemcrest in RestAssured\"\r\n"
		            		+ "}");
		request.put("/incident"+sys_id);
		response.then().assertThat().statusCode(201);
		response.prettyPrint();
	
	}	
}
