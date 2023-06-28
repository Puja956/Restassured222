package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Patch_API_Methods {
public static int ResponsestatusCode(String BaseURI,String Resourse,String RequestBody) {
		
		RestAssured.baseURI=BaseURI;
				
	 int statusCode  = given().header("Content-Type", "application/json").body(RequestBody).                
	              when().patch(Resourse).then().extract(). statusCode();                             
	                  return statusCode ;
	}
	     public static String ResponseBody(String BaseURI,String Resourse,String RequestBody) {
	              		
	         	RestAssured.baseURI=BaseURI;
	              				
	      String ResponseBody  = given().header("Content-Type", "application/json").body(RequestBody).                
	               when().patch(Resourse).then().extract().response().asPrettyString();                             
	              	   return ResponseBody ;
	}
}

