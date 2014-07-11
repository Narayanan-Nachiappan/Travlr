package com.y.trends;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: ashwath
 * Date: 11/14/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class YelpTrendingInfo {

    public YelpTrendingInfo() {
    }

    public ArrayList<Map<String,String>> getLocationInfo(String jsonValue)
    {
    	ArrayList<Map<String,String>>  locationInfoHash = new ArrayList<Map<String,String>> ();

        JsonElement jse = null;
        BufferedReader in = null;
        JsonObject mainObj = null;
        JsonArray business = null;

        try
        {



            // Getting the string and converting into JSON
            jse = new JsonParser().parse(jsonValue);


            // Converting the JSON into JSON object
            mainObj = jse.getAsJsonObject();


            // There can be more than one result for a call to traversing reach
            business = mainObj.get("businesses").getAsJsonArray();

            for(int i=0;i<business.size();i++)
            {
                String rating = null;
                String review = null;
                String name = null;
                String cityname = null;
                String snippettext = null;
                String phone = null;
                String url = null;
                StringBuffer addressname = new StringBuffer();

                // Creating a new hashmap for each of the reference's
            	HashMap<String,String> locationInfo = new HashMap<String,String>();
            	
                if(business.get(i).getAsJsonObject().has("rating"))
                {
                     rating = business.get(i).getAsJsonObject().get("rating").getAsString();
                     locationInfo.put("rating",rating);
                }

                if(business.get(i).getAsJsonObject().has("review_count"))
                {
                    review = business.get(i).getAsJsonObject().get("review_count").getAsString();
                    locationInfo.put("review", review);
                }

                if(business.get(i).getAsJsonObject().has("name"))
                {
                    name = business.get(i).getAsJsonObject().get("name").getAsString();
                    locationInfo.put("name", name);
                }

                if(business.get(i).getAsJsonObject().has("snippet_text"))
                {
                    snippettext = business.get(i).getAsJsonObject().get("snippet_text").getAsString();
                    locationInfo.put("snippet",snippettext);
                }
                
                if(business.get(i).getAsJsonObject().has("url"))
                {
                    url = business.get(i).getAsJsonObject().get("url").getAsString();
                    locationInfo.put("url",url);
                }
                
                if(business.get(i).getAsJsonObject().has("phone"))
                {
                    phone = business.get(i).getAsJsonObject().get("phone").getAsString();
                    locationInfo.put("phone", phone);
                }

                if(business.get(i).getAsJsonObject().get("location").getAsJsonObject().has("city"))
                {
                    cityname = business.get(i).getAsJsonObject().get("location").getAsJsonObject().get("city").getAsString();
                    locationInfo.put("city", cityname);
                }

                if(business.get(i).getAsJsonObject().get("location").getAsJsonObject().has("display_address"))
                {
                    JsonArray addressname1 = business.get(i).getAsJsonObject().get("location").getAsJsonObject().get("display_address").getAsJsonArray();
                    for(int j=0; j<addressname1.size();j++)
                    {
                         String addressname_temp = addressname1.get(j).getAsJsonPrimitive().getAsString();
                         if(addressname.length() == 0)
                        	 addressname.append(addressname_temp);
                         else
                        	 addressname.append(", "+addressname_temp);
                    }
                    locationInfo.put("address",addressname.toString());
                }

//                TrendingInfo trendingInfo = new TrendingInfo(name,addressname,cityname,rating,review,phone,snippettext);
//                locationInfo.put();
                locationInfoHash.add(locationInfo);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return locationInfoHash;
    }
}
