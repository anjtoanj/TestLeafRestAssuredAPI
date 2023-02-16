package week3Day2Assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteBugInJIRA {
	@Test
	 public void deleteBug() {
   	 
   	 RestAssured.baseURI="https://anjurestapi2023.atlassian.net/rest/api/2";
   	 
   	 RestAssured.authentication =RestAssured.preemptive().basic("anjtoanj@gmail.com", "ATATT3xFfGF024QQgY3sXLRCnmoeAWdpelsWd2MqKVCjo_TQ06a1BQWcXin_-XyaPkTCNe9jg5nvLC7VT_eeVS1pOIuLjhPVKScFABTSWNvCWWGeKvHSNhRfMlxUzqceQ6Xv0EhPAcgWpAqm92_oXDmdJ9iW9_-NM_k9O4fyjv5alg864RpECsw=C08058E1");
   	 
		 RequestSpecification inputRequest = RestAssured.given();
		 
		 Response response = inputRequest.delete("/issue/TS-22");
		 System.out.println(response.getStatusCode());
		 
		 response.then().assertThat().statusCode(204);

		 			
	 }
}
