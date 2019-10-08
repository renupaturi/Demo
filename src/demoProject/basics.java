package demoProject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;



public class basics {
	@Test

	public void Test1()
	{
	RestAssured.baseURI="https://maps.googleapis.com";
	given().
	param("location","-33.8670522,151.1957362").
			
			param("radius","1500").
			param("key","AIzaSyAQ4-5DzWve71-ZCSR_TdNb_ZNlVRK9MrM").
			when().
			get("/maps/api/place/nearbysearch/json").
			then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("results[0].geometry.location.lat", equalTo("-33.8688197")).and().
			body("results[0].name",equalTo("Sydney")).and().
			body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
			header("server","scaffolding on HTTPServer2");
			
					}


}