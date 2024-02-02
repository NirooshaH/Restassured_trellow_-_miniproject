package Trellow_api_automation;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;

public class Trellow_create_board {
	
	private static final String alwaysRun = null;
	String id;
	
//go to this link for API documentation: https://developer.atlassian.com/cloud/trello/rest/api-group-boards/#api-group-boards
	
	//public static String baseurl ="https://api.trello.com/";
	
	 @Test(priority = 0)
	 void createboard() {
		Response res= 
				given()
				.header("Content-Type","application/json").
					queryParam("name", "Niroosha").
					queryParam("key", "e93ead5c9aef2ab5f3215c2f988aecfe").
					queryParam("token", "ATTAe1b6493b1e3a2b24ec946276f20da5d4fe20873804505014c6f4ddeeff38ffbfE21DAC3D")
				
				.when()
				.post("https://api.trello.com/1/boards/")
				
				.then()
				.statusCode(200).extract().response();
		
		System.out.println(res.asString());
		JsonPath req=new JsonPath(res.asString());
		 id=req.get("id");
		System.out.println(id);
		
		//6580270b9247455d8f1bcbe8
   }
	
	 @Test(priority = 1)
	 void getboard() {
		//https://api.trello.com/1/boards/{id}
		given()
		.queryParam("key", "e93ead5c9aef2ab5f3215c2f988aecfe")
		.queryParam("token", "ATTAe1b6493b1e3a2b24ec946276f20da5d4fe20873804505014c6f4ddeeff38ffbfE21DAC3D")
		.header("Accept", "application/json")
		
		.when()
		.get("https://api.trello.com/1/boards/"+ id ) //concating the id with the url
		
		.then()
		.statusCode(200);
	}
	@Test
	void deleteboard() {
		given()
		.queryParam("key", "e93ead5c9aef2ab5f3215c2f988aecfe")
		.queryParam("token", "ATTAe1b6493b1e3a2b24ec946276f20da5d4fe20873804505014c6f4ddeeff38ffbfE21DAC3D")
		
		.when()
		.accept("https://api.trello.com/1/boards/"+ id)
		
		.then().statusCode(200);
		
	}
//	@Test
//	public void postreq() {
//		Response res=
//				given()
//				.header("Content-Type","application/json")
//				.queryParam("name", "Shahi")
//				.queryParam("key", "e93ead5c9aef2ab5f3215c2f988aecfe")
//				.queryParam("token", "ATTAe1b6493b1e3a2b24ec946276f20da5d4fe20873804505014c6f4ddeeff38ffbfE21DAC3D")
//				
//				.when()
//				.post("https://api.trello.com/1/boards/")
//				.then()
//				.statusCode(200).extract().response();
//		
//		System.out.println(res.asPrettyString());
//		JsonPath js=new JsonPath(res.asPrettyString());
//		//System.out.println(js);
//		id=js.getString(id);
//	
//	}
//	@Test
//	void getreq() {
//		Response res=
//				given()
//				.header("Content-Type","application/json")
//				.queryParam("key", "e93ead5c9aef2ab5f3215c2f988aecfe")
//				.queryParam("token", "ATTAe1b6493b1e3a2b24ec946276f20da5d4fe20873804505014c6f4ddeeff38ffbfE21DAC3D")
//				
//			    .when()
//			    .get("https://api.trello.com/1/boards/"+id)
//			    
//			    .then()
//			    .statusCode(200).extract().response();
//		
//		System.out.println(id);
		
	}
	

