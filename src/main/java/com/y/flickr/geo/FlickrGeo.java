package com.y.flickr.geo;

import java.util.HashMap;
import java.util.Map;

import com.y.consts.Constants;
import com.y.flickr.http.FlickrClient;

public class FlickrGeo {

	public static void main (String a[]){
		new FlickrGeo().getGeo("5544935601");
	}

	private void getGeo(String photoId) {
		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("method", Constants.FLICKR_GEO_METHOD);
		urlParams.put("api_key", Constants.API_KEY);
		urlParams.put("photo_id", photoId);
		//urlParams.put("auth_token", FlickrConstants.AUTH_TOKEN);
		//urlParams.put("api_sig", FlickrUtil.getMD5Hash(FlickrConstants.SIGNATURE+FlickrConstants.FLICKR_GEO_METHOD));
		//System.err.println(FlickrConstants.SIGNATURE+FlickrConstants.FLICKR_GEO_METHOD);
		FlickrClient.get(Constants.FLICKR_HOST, Constants.FLICR_PATH, urlParams);
				
	}
}