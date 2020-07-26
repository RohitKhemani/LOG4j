package Tutorials;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Update {

	public static void main(String[] args) {

		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
	String Response =	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"ROHIT123\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"").when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(Response);
	
	JsonPath js = new JsonPath(Response);
	String placeid = js.getString("place_id");
	
	System.out.println(placeid);
	
	
	
	
	given().log().all().header("Content-Type", "application/json").queryParam("key", "qaclick123").body("{\r\n" + 
			"    \"place_id\":\""+placeid+"\"\r\n" + 
			"}\r\n" + 
			"").when().post("/maps/api/place/delete/json").then().assertThat().statusCode(200);
		
		
	}

}


