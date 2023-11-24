package week4Day1.chaining;

import org.testng.annotations.Test;

public class Deleteincident extends BaseClass{
	
	@Test(dependsOnMethods= {"week4Day1.chaining.UpdateIncident.updateIncident"})
	public void deleteIncident() {
		response = request.delete("/incident/"+sys_id);
		response.then().assertThat().statusCode(204);
	}

}
