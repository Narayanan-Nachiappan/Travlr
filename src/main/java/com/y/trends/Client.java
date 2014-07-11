package com.y.trends;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;

public class Client {

	public static void main(String[] args) {

		String consumerKey = "fOvV4Pl3YhbdBZ-e-JQfiw";
		String consumerSecret = "xlLn6hqm40MZtPiMEUy_onYclH0";
		String token = "8IsZa5SkR-SCdkwdhT3F-Ig92p2Q4sup";
		String tokenSecret = "MNz-op4I92RRyt-ave-4Fb04k98";
		String trend = "localflavor";
		double latitude = 30.361471;
		double longitude = -87.164326;
		//String place = "Sunnyvale";
		String place = "San Jose";
		String response;
		String pointsofInterest = "amusementparks,beaches,lakes,leisure_centers,skate_parks,playgrounds,recreation,zoos";
		String hotelsAndTravel = "hotelstravel";
		String restaurantInfo = "restaurants";
		String shopping = "watches,toys,sportgoods,shoppingcenters,outlet_stores,electronics,fashion";
		YelpResults yelp = new YelpResults(consumerKey, consumerSecret, token, tokenSecret);

		// response = yelp.searchForTrends(trend, latitude, longitude,
		//		place);
      //  response = yelp.pointsOfInterest(pointsofInterest, latitude, longitude, place) ;
		//
     //   response = yelp.searchHotelsTravel(hotelsAndTravel, latitude, longitude, place) ;
	//	response = yelp.searchRestaurantInfo(restaurantInfo, latitude, longitude, place) ;
		
		response = yelp.searchShoppingPlaces(shopping, latitude, longitude, place) ;
		
		YelpTrendingInfo yelpObj = new YelpTrendingInfo();
		
		ArrayList<Map<String,String>> listObj = yelpObj.getLocationInfo(response);
	 	

		VelocityContext context = new VelocityContext();
		context.put("TrendingInfo", "hi");
		
        System.out.println(response);

	}

}
