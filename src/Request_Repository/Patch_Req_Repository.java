package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utlity_Method;

public class Patch_Req_Repository {
	
public static String baseURI()
{
	String BaseURI = "https://reqres.in/" ;
	return BaseURI;
}
public static String Patch_Resource() 
{
	String Patch_Resource= "api/users/2";
	return Patch_Resource;
}
public static String Patch_Req_TC1() throws IOException 
{
	ArrayList<String> Req_Data=Common_Utlity_Method.ReadDataExcel("patch","TC2");
	System.out.println(Req_Data);
		String Req_Name=Req_Data.get(1);
		String Req_Job=Req_Data.get(2);
	String RequestBody= "{\r\n"
			+ "    \"name\": \""+Req_Name+"\",\r\n"
			+ "    \"job\": \"\""+Req_Job+"\"\"\r\n"
			+ "}";
   
	return RequestBody;
}

}