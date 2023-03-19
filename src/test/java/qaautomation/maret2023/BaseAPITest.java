package qaautomation.maret2023;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaautomation.maret2023.utils.DataUtility;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri("https://api-staging-builder.engineer.ai")
			.setContentType(ContentType.JSON)
			.build().log().all();
	
	RequestSpecification loginJsonSpec;
	String token;
	
	@BeforeMethod
	public void loginAPI() {
		//String payload = "{\"email\":\"testlabs@gmail.com\",\"password\":\"builder123\"}";
		
		String payload = DataUtility.getDataFromExcel("requestbody", "signinBody");
		
//		Response responseLogin = RestAssured.given()
//				.contentType("application/json")
//				.body(payload).when().post("/users/sign_in");
		Response responseLogin = given().spec(commonJsonSpec).body(payload).when().post("/users/sign_in");
		assertEquals(responseLogin.getStatusCode(), 200);
		token = responseLogin.jsonPath().get("user.authtoken");
		System.out.println(token);
		
		loginJsonSpec = new RequestSpecBuilder()
				.setBaseUri("https://api-staging-builder.engineer.ai")
				.setContentType(ContentType.JSON)
				.addHeader("authtoken", token)
				.build().log().all();
	}
}
