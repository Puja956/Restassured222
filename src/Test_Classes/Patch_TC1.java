package Test_Classes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Common_Utlity_Method;
import Common_API_Methods.Patch_API_Methods;
//import Common_API_Methods.Put_API_Methods;
import Request_Repository.Patch_Req_Repository;
import Request_Repository.Post_Req_Repository;
//import Request_Repository.Post_Req_Repository;
//import Request_Repository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
@Test
	public static void extractor() throws IOException 
	{
		int statusCode = Patch_API_Methods.ResponsestatusCode(
		Patch_Req_Repository.baseURI(),
		Patch_Req_Repository.Patch_Resource(),
		Patch_Req_Repository.Patch_Req_TC1());
		System.out.println(statusCode);
		
		String ResponseBody =Patch_API_Methods.ResponseBody (
		Patch_Req_Repository.baseURI(),
		Patch_Req_Repository.Patch_Resource(),
		Patch_Req_Repository.Patch_Req_TC1());
		System.out.println(ResponseBody);
		String RequestBody = Patch_Req_Repository.Patch_Req_TC1();
		Common_Utlity_Method.EvidenceCreater( "Patch_TC1", RequestBody, ResponseBody, statusCode);
		
		JsonPath JspResponse =new JsonPath(ResponseBody);
		String patch_res_name=JspResponse.getString("Name");
		String patch_res_job=JspResponse.getString("Job");
		
		
		Assert.assertEquals(patch_res_name, "morpheus");
		Assert.assertEquals(patch_res_job, "zion resident");
	}
	}
