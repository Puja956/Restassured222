import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Rest_Get_Reference {

	public static void main(String[] args) {
//declare the base URL
		RestAssured.baseURI="https://reqres.in/";
//declare the response body
 given().header("Content-Type", "application/json")
                .log().all()
                .when().get("api/users?page=2")
                .then().log().all().extract().response().asString();


	}

}
