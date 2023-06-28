package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.API_Methods;
import Common_API_Methods.Common_Utlity_Method;
import Request_Repository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
	public static void extractor() throws IOException {

		for (int i = 0; i < 10; i++) {

			// local variable -> local variable created inside a method block
			int Statuscode = API_Methods.ResponseStatusCode(Post_Req_Repository.baseURI(),
					Post_Req_Repository.Post_Resource(), Post_Req_Repository.Post_Req_TC1());

			if (Statuscode == 201) { // 201=expected status code
				System.out.println(Statuscode);
				String ResponseBody = API_Methods.ResponseBody(Post_Req_Repository.baseURI(),
						Post_Req_Repository.Post_Resource(), Post_Req_Repository.Post_Req_TC1());
				System.out.println(ResponseBody);

				String RequestBody = Post_Req_Repository.Post_Req_TC1();
				
				Common_Utlity_Method.EvidenceCreater( "Post_TC1", RequestBody, ResponseBody, Statuscode);

				//Validator(ResponseBody, RequestBody);
				break;
			} else {
				//System.out.println("Invalid ststus code");
			}
		}
	}

	public static void Validator(String ResponseBody, String RequestBody) {
		JsonPath JspRequest = new JsonPath(RequestBody);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		
		
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0, 10);
		// Validate the ResponseBody parameters
		// Validate the ResponseBody parameters
		Assert.assertEquals(Res_name, "Req_name");
		Assert.assertEquals(Res_job, "Req_job");
		Assert.assertEquals(Res_createdAt, "2023-06-19");

		//System.out.println(ResponseBody);

	}
}

