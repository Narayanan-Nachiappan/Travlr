package com.y.places;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class PlaceDetails {
    public static void main(String[] args){

        PlaceDetails obj = new PlaceDetails();
        String latitude ="33.7628";
        String longtitude = "-84.3928";
        String radius ="4000";
        String key = "AIzaSyDf71iM82YvDbJIbzuVYWNrVYDAMap8O5c";
        String types = "aquarium";

        // getting the list of references
        HashSet<String> referenceList= obj.getReferences(latitude, longtitude, radius, key, types);

        // getting the information for all the references.
        ArrayList<HashMap<String,String>> locationInfo = obj.getLocationInfo(referenceList,key);
        System.out.println(locationInfo.toString());


    }

    // Returns the reference by calling the 1st API
    public HashSet<String> getReferences(String latitude, String longitude, String radius, String key,String types)
    {
        URL source = null;
        JsonElement jse = null;
        BufferedReader in = null;
        InputStream value = null;
        JsonObject mainObj = null;
        JsonArray result = null;
        String ref = null;
        HashSet<String> reference = new HashSet<String>();


        String targetURL="https://maps.googleapis.com/maps/api/place/radarsearch/json?location=".
                concat(latitude).
                concat("%2c").
                concat(longitude).
                concat("&radius=").
                concat(radius).
                concat("&sensor=").
                concat("false").
                concat("&key=").
                concat(key).
                concat("&types=").
                concat(types);
        try
        {
            // Getting the string and converting into JSON.
            source = new URL(targetURL);
            in = new BufferedReader(new InputStreamReader(source.openStream(),"UTF-8"));
            jse = new JsonParser().parse(in);
            in.close();

            // Converting the JSON into JSON object
            mainObj = jse.getAsJsonObject();
            result = mainObj.get("results").getAsJsonArray();

            // There can be more than one result for a call to traversing reach.
            for(int i=0; i<result.size();i++)
            {
                ref = result.get(i).getAsJsonObject().get("reference").getAsString();
                reference.add(ref);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reference;
    }

    public ArrayList<HashMap<String,String>> getLocationInfo(HashSet<String> referenceList, String key)
    {
        Iterator itr = referenceList.iterator();
        ArrayList<HashMap<String,String>> locationInfoHash = new ArrayList<HashMap<String, String>>();

        URL source = null;
        JsonElement jse = null;
        BufferedReader in = null;
        InputStream value = null;
        JsonObject mainObj = null;
        JsonObject result = null;
        String ref = null;

        String targetURL = "https://maps.googleapis.com/maps/api/place/details/json".
                concat("?sensor=").
                concat("false").
                concat("&key=").
                concat(key).
                concat("&reference=");

        try
        {
            while(itr.hasNext())
            {
                // Creating new URL
                String newtargetURL = targetURL.concat(itr.next().toString());

                // Creating a new hashmap for each of the reference's
                HashMap<String,String> locationInfo = new HashMap<String, String>();

                // Getting the string and converting into JSON.
                source = new URL(newtargetURL);
                in = new BufferedReader(new InputStreamReader(source.openStream(),"UTF-8"));
                jse = new JsonParser().parse(in);
                in.close();

                // Converting the JSON into JSON object
                mainObj = jse.getAsJsonObject();
                result = mainObj.get("result").getAsJsonObject();

                // There can be more than one result for a call to traversing reach.
                String locationName = result.get("name").getAsString();
                String addressInformation = result.get("formatted_address").getAsString();
                String phoneNumber = result.get("formatted_phone_number").getAsString();

                locationInfo.put("locationName",locationName);
                locationInfo.put("addressInformation",addressInformation);
                locationInfo.put("phoneNumber",phoneNumber);

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
