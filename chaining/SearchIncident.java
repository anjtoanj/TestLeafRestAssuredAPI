package week4Day1.chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class SearchIncident extends BaseClass{
	
	@Test(dependsOnMethods= {"week4Day1.chaining.Deleteincident.deleteIncident"})
	public void searchIncident() {
		response = request.get("/incident");
		response.then().assertThat().body("result.sys_id", Matchers.hasItem(sys_id));	// test should fail


	}
}
