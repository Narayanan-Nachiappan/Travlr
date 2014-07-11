package com.y.trends;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class YelpResults {

	OAuthService service;
	Token accessToken;
	String apiToYelp = new String();
	OAuthRequest request;

	public YelpResults(String consumerKey, String consumerSecret, String token,
			String tokenSecret) {
		this.service = new ServiceBuilder().provider(YelpApi2.class)
				.apiKey(consumerKey).apiSecret(consumerSecret).build();
		this.accessToken = new Token(token, tokenSecret);
		apiToYelp = "http://api.yelp.com/v2/search";

	}

	public String searchForTrends(String trend, double latitude,
			double longitude, String place) {
		request = new OAuthRequest(Verb.GET, apiToYelp);
		if (place.length() > 0) {
			request.addQuerystringParameter("location", place.trim());

		} else {
			request.addQuerystringParameter("ll", latitude + "," + longitude);

		}

		request.addQuerystringParameter("category_filter", trend);
		return callService(request);

	}

	public String callService(OAuthRequest req) {
		this.service.signRequest(this.accessToken, req);
		Response response = request.send();
		return response.getBody();//.replace("\"", "\\\"");

	}

	public String pointsOfInterest(String params, double latitude,
			double longitude, String place) {
		request = new OAuthRequest(Verb.GET, apiToYelp);
		if (place.length() > 0) {
			request.addQuerystringParameter("location", place.trim());

		} else {
			request.addQuerystringParameter("ll", latitude + "," + longitude);

		}

		request.addQuerystringParameter("category_filter", params);
		return callService(request);
	}
	
	
	public String searchHotelsTravel(String params, double latitude,
			double longitude, String place) {
		request = new OAuthRequest(Verb.GET, apiToYelp);
		if (place.length() > 0) {
			request.addQuerystringParameter("location", place.trim());

		} else {
			request.addQuerystringParameter("ll", latitude + "," + longitude);
			System.out.println("test");

		}

		request.addQuerystringParameter("category_filter", params);
		return callService(request);
	}
	
	
	
	public String searchRestaurantInfo(String restaurant, double latitude,
			double longitude, String place) {
		request = new OAuthRequest(Verb.GET, apiToYelp);
		if (place.length() > 0) {
			request.addQuerystringParameter("location", place.trim());

		} else {
			request.addQuerystringParameter("ll", latitude + "," + longitude);
			System.out.println("test");

		}

		request.addQuerystringParameter("category_filter", restaurant);
		return callService(request);
	}
	
	
	public String searchShoppingPlaces(String shopping, double latitude,
			double longitude, String place) {
		request = new OAuthRequest(Verb.GET, apiToYelp);
		if (place.length() > 0) {
			request.addQuerystringParameter("location", place.trim());

		} else {
			request.addQuerystringParameter("ll", latitude + "," + longitude);
			System.out.println("test");

		}

		request.addQuerystringParameter("category_filter", shopping);
		return callService(request);
	}
	
}
