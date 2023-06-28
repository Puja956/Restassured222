package Common_API_Methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class API_Methods {

	public static int ResponseStatusCode(String baseURI, String Resource, String RequestBody) {

		RestAssured.baseURI = baseURI;

		int statusCode = given().header("Content-type", "application/json").body(RequestBody).when().post(Resource)
				.then().extract().statusCode();
		return statusCode;

	}

	public static String ResponseBody(String baseURI, String Resource, String RequestBody) {

		RestAssured.baseURI = baseURI;
		
		String ResponseBody = given().header("Content-type", "Application/Json").body(RequestBody).when().post(Resource)
				.then().extract().response().asPrettyString();
		return ResponseBody;

	}

	
		
	

}
