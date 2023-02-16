package week3Day2Assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateBugInJIRA {
     @Test
	 public void createBug() {
    	 
    	 RestAssured.baseURI="https://anjurestapi2023.atlassian.net/rest/api/2";
    	 
    	 RestAssured.authentication =RestAssured.preemptive().basic("anjtoanj@gmail.com", "ATATT3xFfGF024QQgY3sXLRCnmoeAWdpelsWd2MqKVCjo_TQ06a1BQWcXin_-XyaPkTCNe9jg5nvLC7VT_eeVS1pOIuLjhPVKScFABTSWNvCWWGeKvHSNhRfMlxUzqceQ6Xv0EhPAcgWpAqm92_oXDmdJ9iW9_-NM_k9O4fyjv5alg864RpECsw=C08058E1");
    	 
		 RequestSpecification inputRequest = RestAssured.given()
		            .contentType("application/json")
		 			.accept("*/*")
		 			.when().body("{\r\n"
		 					+ "    \"fields\": {\r\n"
		 					+ "        \"project\": {\r\n"
		 					+ "            \"key\": \"TS\"\r\n"
		 					+ "        },\r\n"
		 					+ "        \"summary\": \"create issue in RA project\",\r\n"
		 					+ "        \"description\": \"Creating of an issue using project keys and issue type names using the postman\",\r\n"
		 					+ "        \"issuetype\": {\r\n"
		 					+ "            \"name\": \"Bug\"\r\n"
		 					+ "        }\r\n"
		 					+ "    }\r\n"
		 					+ "}");
		 
		 Response response = inputRequest.post("/issue");
		 System.out.println(response.getStatusCode());
		 System.out.println(response.prettyPrint());
		 
		 //Add Assertion
		 ValidatableResponse statusCode = response.then().assertThat().statusCode(201);
		 			
	 }
}
