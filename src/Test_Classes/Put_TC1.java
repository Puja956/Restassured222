package Test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Put_API_Methods;
//import Request_Repository.Post_Req_Repository;
import Request_Repository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
@Test
	public static void extractor() {

		int Statuscode = Put_API_Methods.ResponseStatusCode(Put_Req_Repository.baseURI(),
				Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_Req_TC1());
		System.out.println(Statuscode);

		String ResponseBody = Put_API_Methods.ResponseBody(Put_Req_Repository.baseURI(),
				Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_Req_TC1());
		System.out.println(ResponseBody);

		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		// String Res_updateAt = JspResponse.getString("updateAt");
		// Res_updateAt = Res_updateAt.substring(0,10);

		Assert.assertEquals(Res_name, "morpheus");
		Assert.assertEquals(Res_job, "zion resident");
		// Assert.assertEquals(Res_updateAt, "2023-06-07");

	}

}
