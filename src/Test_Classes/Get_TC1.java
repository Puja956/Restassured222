package Test_Classes;

import org.testng.annotations.Test;

import Common_API_Methods.Get_API_Method;
//import Common_API_Methods.Put_API_Methods;
import Request_Repository.Get_Req_Repository;


public class Get_TC1 {
	@Test
	public static void extractor() {

		int Statuscode=Get_API_Method.ResponseStatusCode(Get_Req_Repository.baseURI(), Get_Req_Repository.Get_Resource());
		System.out.println(Statuscode);
		
		
		String ResponseBody=Get_API_Method.ResponseBody(Get_Req_Repository.baseURI(), Get_Req_Repository.Get_Resource());
		System.out.println(ResponseBody);
	}

}
