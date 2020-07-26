package Tutorials;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdditionPlace {
	
	@BeforeMethod
	
	public void login() {
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";

	}
	
	
	
	
	@DataProvider
	
	public Object[][] info() throws EncryptedDocumentException, IOException {
		
		Object[][] data = Data.selection("RR");
		
		return data;
		
		
	}
	
	
	@Test(dataProvider = "info")
	
	public void test(String name, String address) {
		
		
		
	String Response = 	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \""+name+"\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \""+address+"\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"}").when().post("/maps/api/place/add/json").then().assertThat().extract().response().asString();
	
	JsonPath js = new JsonPath(Response);
	
	String place = js.get("place_id");
	
	System.out.println(place);
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	}

}
