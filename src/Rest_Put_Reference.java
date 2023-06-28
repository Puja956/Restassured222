import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import java.time.LocalDateTime;

public class Rest_Put_Reference {

	public static void main(String[] args) {
		// Declare the base URL
		RestAssured.baseURI = "https://reqres.in/";

		// Declare the request body string variable
		String requestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}";

		// Declare the expected results
		JsonPath JspRequest = new JsonPath(requestBody);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentDate = LocalDateTime.now();
		String expectedDate = currentDate.toString().substring(0, 11);

		// declare given when & then method
		String responseBody = given().header("Content-Type", "application/json").body(requestBody).log().all().when()
				.put("api/users/2").then().log().all().extract().response().asString();

		// Extract values from the response body
		JsonPath JspResponse = new JsonPath(responseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_updatedAt = JspResponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0, 11);

		// validate response body
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_updatedAt, expectedDate);
//		System.out.println(responseBody);
	}
}
