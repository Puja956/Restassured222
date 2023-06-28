import java.time.LocalDateTime;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;

public class RE_PO_RE {

	public static void main(String[] args) {
		
				RestAssured.baseURI = "https://reqres.in/";

				//Declare the request body string variable
				String RequestBody = "{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}";
				//Declare the expected results
				JsonPath JspRequest = new JsonPath(RequestBody);
				String Req_name = JspRequest.getString("name");
				String Req_job = JspRequest.getString("job");
				LocalDateTime currentdate = LocalDateTime.now();
				String expecteddate= currentdate.toString().substring(0, 9);
				//Declare given, when then method (Response Body fetching)
				//String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).log().all().
						//when().post("api/users").then().log().all().extract().response().asString();
				String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).
						when().post("api/users").then().extract().response().asString();
				//System.out.println(ResponseBody);
				//Create an object of JSON path to parse the response body
				JsonPath JspResponse = new JsonPath(ResponseBody);
				String Res_name = JspResponse.getString("name");
				String Res_job = JspResponse.getString("job");
				String Res_id = JspRequest.getString("id");
				String Res_createdAt = JspResponse.getString("createdAt");
				Res_createdAt = Res_createdAt.substring(0, 9);
				//Validate the ResponseBody parameters
				Assert.assertEquals(Res_name, Req_name);
				Assert.assertEquals(Res_job, Req_job);
				
				//Assert.assertNotNull(Res_id);
				Assert.assertNotEquals(Res_id,0);
				Assert.assertEquals(Res_createdAt, expecteddate);
				System.out.println(ResponseBody);
				
				
			}

		

	}


