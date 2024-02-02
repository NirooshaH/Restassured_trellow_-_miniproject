package Trellow_api_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc_001_Get_Request {
	@Test
	void getdetails(){
		RestAssured.baseURI="https://reqres.in/api/users/";
		
		RequestSpecification req=RestAssured.given();
		Response res=req.request(Method.GET,"/8");
		String responsebody= res.getBody().asPrettyString();
		System.out.println("Response Body is :"+ responsebody);
		
		int statuscode=res.getStatusCode();
		System.out.println("status code is:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		String statusline=res.getStatusLine();
		System.out.println("Status line is:"+statusline);
		
		
		boolean s=statusline.contains("HTTP");
		System.out.println(s);
		
		
		
		
		
	}

}
