package com.y.flickr.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FlickrClient {

	public static void get(String host, String path, Map<String, String> urlParams) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		URI uri = buildURI(host,path,urlParams);
		System.err.println("Calling " + uri);
		HttpGet httpGet = new HttpGet(uri);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST either fully consume the response content  or abort request
		// execution by calling CloseableHttpResponse#close().

		try  {
			response = httpclient.execute(httpGet);
			//System.out.println(response.getStatusLine());
		    HttpEntity entity1 = response.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    
		    BufferedReader rd = new BufferedReader(new InputStreamReader(entity1.getContent()));
		    String line = null;
		      while ((line = rd.readLine()) != null) {
		        System.out.println(line);
		      }
		    //EntityUtils.consume(entity1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	public static void post(String url, Map<String, String> requestParams) {

	}
	
	public static URI buildURI(String host,String path,Map<String,String> urlParams ){
		URI uri = null;
		URIBuilder uriBuilder = new URIBuilder()
		.setScheme("http")
		.setHost(host)
		.setPath(path);
		Iterator<String> paramIter = urlParams.keySet().iterator();
		while(paramIter.hasNext()){
			String key = paramIter.next();
			String value = urlParams.get(key);
			uriBuilder.setParameter(key, value);
		}
		try {
			uri = uriBuilder.build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
		return uri;
	}

}
