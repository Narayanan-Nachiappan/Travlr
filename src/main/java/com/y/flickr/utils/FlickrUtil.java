package com.y.flickr.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FlickrUtil {
	
	public static String getMD5Hash(String signatureString){
        StringBuffer sb = new StringBuffer();

		try {

	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(signatureString.getBytes());
	 
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	        
	 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}
