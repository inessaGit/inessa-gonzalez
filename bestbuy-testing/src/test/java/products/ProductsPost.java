package products;

import java.io.IOException;
import com.google.gson.Gson;

import objects.ProductNew;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPost {

	private String basicUrl="http://localhost:3030/products";
	
	@Test
	public void givenValidPostParameters_whenProductsPosted_then201IsReceived() throws ClientProtocolException, IOException {
		
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
	   System.out.println(httpResponse.getStatusLine().getStatusCode());
	   
	   // Then
	   Assert.assertTrue(httpResponse.getStatusLine().getStatusCode()==(HttpStatus.SC_CREATED)); //201
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
