package com.y.trends;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class Code {

	OAuthService service;
	Token accessToken;

	public Code(String consumerKey, String consumerSecret, String token, String tokenSecret) {
		this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret)
				.build();
		this.accessToken = new Token(token, tokenSecret);
	}

	public String search(String category, Double latitude, Double longitude) {
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
		// request.addQuerystringParameter("term", term);

		// request.addQuerystringParameter("ll", latitude + "," + longitude);
		request.addQuerystringParameter("ll", latitude.toString()+","+longitude.toString());
		request.addQuerystringParameter("category_filter", category);

		this.service.signRequest(this.accessToken, request);
		Response response = request.send();
		return response.getBody();
	}
}
