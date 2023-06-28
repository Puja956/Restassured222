import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.path.xml.*;

public class Soap_Api_Refererence_Sec {

	public static void main(String[] args) {
//declare baseURL
		RestAssured.baseURI = "http://www.dataaccess.com/";
		// DECLARE REQUEST BODY
		String RequestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap12:Envelope xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
				+ "  <soap12:Body>\r\n"
				+ "    <NumberToDollars xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <dNum>35</dNum>\r\n"
				+ "    </NumberToDollars>\r\n"
				+ "  </soap12:Body>\r\n"
				+ "</soap12:Envelope>";
		// EXTRACT RESPONSE BODY
		String ResponseBody=given().header("Content-Type","text/xml; charset=utf-8").body(RequestBody).when()
				.post("webservicesserver/NumberConversion.wso").then().extract().response().asString();
		System.out.println(ResponseBody);
		// parse the response
		XmlPath XmlResponse=new XmlPath(ResponseBody);
		String ResponseParameter=XmlResponse.getString("NumberToDollarsResult");
		System.out.println(ResponseParameter);
		// validate response body
		Assert.assertEquals(ResponseParameter, "thirty five ");
		

	}

}


