

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class test_get_request {
	
	@Test
	void getweatherdetails() {
	Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody());
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		Assert.assertEquals(response.getStatusCode(),200);
		 
	given()
	.get("https://reqres.in/api/users?page=2")
	.then().statusCode(200)
	.body("data.id[1]", equalTo(8)).log().all();
	
	given()
	.get("https://reqres.in/api/users?page=2")
	.then().statusCode(300).body("data.id[3]", equalTo(9));
	
	JSONObject js=new JSONObject();
		js.put("name", "morpheus12");
	    js.put("job", "education");
	   
	    given()
	    .body(js)
	    .when()
	    .put("https://reqres.in/api/users")
	    .then().statusCode(201).log().all();
	    
    JSONObject js1=new JSONObject();
	    js1.put("name","Niroosha12");
	    js1.put("job", "SDET");
	    
	    given()
	    .body(js1)
	    
	    .when()
	    .post("https://reqres.in/api/users")
	   
	    .then().statusCode(201).log().all();
    
	    given()
	   .get("https://reqres.in/api/users")
	   .then().statusCode(200).body("data.first_name", hasItems("George","Niroosha12")).log().all();
	    
	    given().
	    get("https://reqres.in/api/users")
	    .then().statusCode(200).body("data.first_name", hasItem(null));
   
   //delete request
    when().
    delete("https://reqres.in/api/users/2").
    then().
    statusCode(204).log().all();
   
    
//    given().
//    get("https://reqres.in/api/users/2").then().statusCode(200).
//    body("dat.last_name", hasItem(null))
   
	
	
		
		
		
		//given().body(js.put("name", "morpheus12")).body(js.put("job", "education")).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
		
		
	}

}
