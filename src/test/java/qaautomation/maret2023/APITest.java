package qaautomation.maret2023;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {
	String token;
	String baseUrl = "https://api-staging-builder.engineer.ai";
	
	@Test (priority = 1)
	public void loginAPI() {
		RestAssured.baseURI = baseUrl;
		String payload = "{\"email\":\"testlabs@gmail.com\",\"password\":\"builder123\"}";
		
		Response responseLogin = RestAssured.given()
				.contentType("application/json")
				.body(payload).when().post("/users/sign_in");
		assertEquals(responseLogin.getStatusCode(), 200);
		token = responseLogin.jsonPath().get("user.authtoken");
		System.out.println(token);
	}
	
	@Test (priority = 2)
	public void dashboardAPI() {
		RestAssured.baseURI = baseUrl;
		
		Response responseDashboard = RestAssured.given()
				.contentType("application/json")
				.header("authtoken",token)
				.when().get("/build_cards?status=completed");
		assertEquals(responseDashboard.getStatusCode(),200);
	}
	
	@Test (priority = 2)
	public void userAPI() {
		RestAssured.baseURI = baseUrl;
		
		Response responseDashboard = RestAssured.given()
				.contentType("application/json")
				.header("authtoken",token)
				.when().get("/user");
		assertEquals(responseDashboard.getStatusCode(),200);
	}

}
