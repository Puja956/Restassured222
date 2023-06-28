package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Put_API_Methods {
	
	public static int ResponseStatusCode(String baseURI, String Resource, String RequestBody) {
		
		RestAssured.baseURI=baseURI;
		
		int StatusCode=given().header("Content-Type", "application/json").body(RequestBody).when()
				.put(Resource).then().extract().statusCode();
		return StatusCode;
		
	}
	
	public static String ResponseBody(String baseURI, String Resource, String RequestBody) {
		
		RestAssured.baseURI=baseURI;
		
		String ResponseBody=given().header("Content-type", "Application/Json").body(RequestBody).when()
				.put(Resource).then().extract().response().asPrettyString();
		return ResponseBody;
    }
}