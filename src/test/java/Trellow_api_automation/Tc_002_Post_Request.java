package Trellow_api_automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc_002_Post_Request {
	@Test
	void createdetails() {
		RestAssured.baseURI="https://reqres.in/api/";
		RequestSpecification req=RestAssured.given();
		
		JSONObject requestparams=new JSONObject();
		requestparams.put("email", "george.bluth123@reqres.in");
		requestparams.put("first_name", "George12");
		requestparams.put("last_name", "Bluth12");
		
		req.header("Content-Type","Application/json");
		req.body(requestparams.toJSONString());
		
		Response res=req.request(Method.POST,"/users");
		
		String responsBody=res.getBody().asString();
		System.out.println("response is:"+ responsBody);
		
		int statuscode=res.getStatusCode();
		System.out.println("status code is " + statuscode);
		Assert.assertEquals(statuscode, 201);
		
	}

}
