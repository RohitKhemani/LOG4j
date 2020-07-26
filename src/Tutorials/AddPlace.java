package Tutorials;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class AddPlace {

	public static void main(String[] args) {

		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
	String Response =	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rishabhpant\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"Block no C631, Aohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}").when().post("maps/api/place/add/json")
	.then().log().all().assertThat().extract().response().asString();
	
	JsonPath js = new JsonPath(Response);
	String place = js.get("place_id");
	
	System.out.println(place);
	
	
	
String SecondResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n" + 
		"    \"place_id\":\""+place+"\"}").when().get("maps/api/place/delete/json").then().log().all().assertThat().extract().response().asString();
	
System.out.println(SecondResponse);


		
		
	}

}
