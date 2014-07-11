package com.y.flickr.favorites;

import java.util.ArrayList;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import com.y.consts.Constants;
import com.y.trends.YelpResults;
import com.y.trends.YelpTrendingInfo;

public class YelpHandler {
	
	public void handle(String place,Context ctx,String reqPath){
		//ctx.put("sample", "hello");  
		String consumerKey = "fOvV4Pl3YhbdBZ-e-JQfiw";
		String consumerSecret = "xlLn6hqm40MZtPiMEUy_onYclH0";
		String token = "8IsZa5SkR-SCdkwdhT3F-Ig92p2Q4sup";
		String tokenSecret = "MNz-op4I92RRyt-ave-4Fb04k98";
		String trend = "localflavor";
		double latitude = 30.361471;
		double longitude = -87.164326;
		//String place = "Sunnyvale";
		String response = null;
		String pointsofInterest = "amusementparks,beaches,lakes,leisure_centers,skate_parks,playgrounds,recreation,zoos";
		String hotelsAndTravel = "hotelstravel";
		String restaurantInfo = "restaurants";
		String shopping = "watches,toys,sportgoods,shoppingcenters,outlet_stores,electronics,fashion";
		YelpResults yelp = new YelpResults(consumerKey, consumerSecret, token, tokenSecret);

		if(Constants.REQ_YELP_POI.equals(reqPath)){
		      response = yelp.pointsOfInterest(pointsofInterest, latitude, longitude, place) ;

		}else if(Constants.REQ_YELP_EVENTS.equals(reqPath)){
			response = yelp.searchForTrends(trend, latitude, longitude,
				place);
			
		}else if(Constants.REQ_YELP_SHOPPING.equals(reqPath)){
			response = yelp.searchShoppingPlaces(shopping, latitude, longitude, place) ;
		}else if(Constants.REQ_YELP_RESTAURANTS.equals(reqPath)){
			response  = yelp.searchRestaurantInfo(restaurantInfo, latitude, longitude, place) ;
		}
		//response = yelp.searchForTrends(trend, latitude, longitude,
			//	place);
   //   response = yelp.pointsOfInterest(pointsofInterest, latitude, longitude, place) ;
		
     //   response = yelp.searchHotelsTravel(hotelsAndTravel, latitude, longitude, place) ;
	//	response = yelp.searchRestaurantInfo(restaurantInfo, latitude, longitude, place) ;
		//
		//ctx.put("yelpResults", List)
		//response = yelp.searchShoppingPlaces(shopping, latitude, longitude, place) ;
		
		YelpTrendingInfo yelpObj = new YelpTrendingInfo();
		
		ArrayList<Map<String,String>> listObj = yelpObj.getLocationInfo(response);
	 	

		VelocityContext context = new VelocityContext();
		ctx.put("TrendingInfo", yelpObj.getLocationInfo(response));
		
	}

}
