package products;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsGet {

	private String basicUrl="http://localhost:3030/";
	
	@Test
	public void givenValidEndpoint_whenProductsRetrieved_then200IsReceived() throws ClientProtocolException, IOException {
	   // Given
	   HttpUriRequest request = new HttpGet( basicUrl + "/products" );
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	   // Then
	   Assert.assertTrue(httpResponse.getStatusLine().getStatusCode()==(HttpStatus.SC_OK)); //200
	}
	
	@Test
	public void givenValidEndpoint_whenProductRetrievedById_then200IsReceived() throws ClientProtocolException, IOException {
	   // Given Get product with ID of 9132294
	   HttpUriRequest request = new HttpGet( basicUrl + "/products/9132294" );
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	   // Then
	   Assert.assertTrue(httpResponse.getStatusLine().getStatusCode()==(HttpStatus.SC_OK)); //200
	}
	
	@Test
	public void givenValidEndpoint_whenProductsRetrieved_thenDefaultResponseContentTypeIsJson() throws ClientProtocolException, IOException {
	   // Given Testing the Media Type
	   HttpUriRequest request = new HttpGet( basicUrl + "/products" );
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	   // Then
	   String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();

	   System.out.println(mimeType);
	   Assert.assertTrue(mimeType.equalsIgnoreCase(ContentType.APPLICATION_JSON.getMimeType())); 
	}

}
