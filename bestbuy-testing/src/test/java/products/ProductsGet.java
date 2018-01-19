package products;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
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

}
