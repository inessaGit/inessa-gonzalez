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
import objects.Cart;
import objects.User;

import objects.ProductNew;

public class CartPost {

	
	private String basicUrl="https://www.sf-test1.com/v1/shoppingCarts/826d6b55-f849-4e90-ae33-9c9b18f953ce/items?productBundleUuid=CamPackage_2018_06&count=1";
	
	//private String basicUrl="https://www.sf-test1.com/v1/shoppingCarts/";

	
	//POST /v1/shoppingCarts/{shoppingCartUuid}/items

	@Test
	public void postItemsToCart() {
		User testUser = User.createTestUser();
		
		//String devEndpoint = "https://user-relay.dir.dev1.com/api/v1/mobilcom/accounts" ;
		
		String devEndpoint = "https://cc.sedoparking.com/api/v1/mobilcom/accounts" ;

	RestAssured.given().header("Authorization", "Basic bW9iaWxjb206bW9iaWxjb206MDE=")
				.contentType("application/json; charset=UTF-8").body(testUser).when().post(devEndpoint).then()
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
