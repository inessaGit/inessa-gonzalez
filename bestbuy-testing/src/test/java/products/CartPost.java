package products;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import objects.Cart;
import objects.User;

import objects.ProductNew;

public class CartPost {

	
	private String basicUrl="https://www.sf-test1.com/v1/shoppingCarts/";
	

	
//	curl = "https://api.dir.sf-test1.com/v1/shoppingCarts?country=de&access_token=4b31781b-b359-4b89-ab72-d5dda644907d" ;
//user inessa.08283@yopmail.com / nautica1 

	@Test (invocationCount=5)
	public void createCart() {				
		String stageEndpoint = "https://api.dir.sf-test1.com/v1/shoppingCarts" ;
		RestAssured.given().
		queryParam("country", "de").
		queryParam("access_token", "4b31781b-b359-4b89-ab72-d5dda644907d").
		when().post(stageEndpoint).then().statusCode(200) ;	
		
	}
	
	@Test (invocationCount=1)
	public void createCartGetResponse() {				
		String stageEndpoint = "https://api.dir.sf-test1.com/v1/shoppingCarts" ;
		
		RequestSpecification httpRequest = RestAssured.given().
				queryParam("country", "de").
				queryParam("access_token", "4b31781b-b359-4b89-ab72-d5dda644907d");
		Response response = httpRequest.when().post(stageEndpoint);
	 
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		String bodyAsString = body.asString();
		System.out.println(bodyAsString) ;
		
	}
	@Test
	public void postItemsToCart() {
		User testUser = User.createTestUser();
		
		
//		String stageEndpoint = "https://api.dir.sf-test1.com/v1/shoppingCarts?country=de&access_token=4b31781b-b359-4b89-ab72-d5dda644907d" ;
		String stageEndpoint = "https://api.dir.sf-test1.com/v1/shoppingCarts?country=de&access_token=4b31781b-b359-4b89-ab72-d5dda644907d" ;

	RestAssured.given().header("Authorization", "Basic bW9iaWxjb206bW9iaWxjb206MDE=")
				.contentType("application/json; charset=UTF-8").body(testUser).when().post(stageEndpoint).then()
				.statusCode(200);
		
		/*
		 * String url = RestAssured.given().header("Authorization", "Basic bW9iaWxjb206bW9iaWxjb206MDE=")
				.contentType("application/json; charset=UTF-8").body(testUser).when().post(devEndpoint).then()
				.statusCode(200).extract().path("activationUrl");
				System.out.println(url) ;

		 */
	}
	@Test
	public void givenValidPostParameters_whenProductsPosted_then201IsReceived() throws ClientProtocolException, IOException {
		
		Gson gson  = new Gson();
		Cart cart = new Cart();
		cart.setAllParametersWithValidData();
		
	   // Given
	   HttpPost post = new HttpPost( basicUrl );
	   StringEntity postingString = new StringEntity(gson.toJson(cart));
	   
	   //set POST body parameters
	   post.setEntity(postingString);
	   post.setHeader("Content-type", "application/json");
	   
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute(post);
	   System.out.println(httpResponse.getStatusLine().getStatusCode());
	   
	   // Then
	   Assert.assertTrue(httpResponse.getStatusLine().getStatusCode()==(HttpStatus.SC_OK)); //200
	}
	
	@Test
	public void givenValidPostParameters_whenProductsPosted_thenResponseHeadersReceived() throws ClientProtocolException, IOException {
		
		Gson gson  = new Gson();
		ProductNew product = new ProductNew();
		product.setAllParametersWithValidData();
		
	   // Given
	   HttpPost post = new HttpPost( basicUrl );
	   StringEntity postingString = new StringEntity(gson.toJson(product));
	   
	   //set POST body parameters
	   post.setEntity(postingString);
	   post.setHeader("Content-type", "application/json");
	   
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute(post);

	 //get all headers
	   Header[] headers = httpResponse.getAllHeaders();
	   for (Header header : headers) {
	   	System.out.println("Key : " + header.getName()
	   	      + " ,Value : " + header.getValue());
	   }
	   // Then
	  Assert.assertTrue(httpResponse.getFirstHeader("X-Powered-By").getValue().equalsIgnoreCase("Express"));
	}
	
	@Test
	public void givenInvalidPostParameters_whenProductsPosted_then400IsReceived() throws ClientProtocolException, IOException {
		
		Gson gson  = new Gson();
		ProductNew product = new ProductNew();
		product.setDescription("test"); //other mandatory parameters missing 
		
	   // Given
	   HttpPost post = new HttpPost( basicUrl );
	   StringEntity postingString = new StringEntity(gson.toJson(product));
	   
	   //set POST body parameters
	   post.setEntity(postingString);
	   post.setHeader("Content-type", "application/json");
	   
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute(post);
	   System.out.println(httpResponse.getStatusLine().getStatusCode());
	   
	   // Then
	   Assert.assertTrue(httpResponse.getStatusLine().getStatusCode()==(HttpStatus.SC_BAD_REQUEST)); //400
	}
}
