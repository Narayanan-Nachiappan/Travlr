package com.y.flickr.favorites;

import java.util.HashMap;
import java.util.Map;

import com.y.consts.Constants;
import com.y.flickr.http.FlickrClient;
import com.y.flickr.utils.FlickrUtil;

public class FlickrFavorites {
	
	
	public static void main (String a[]){
		new FlickrFavorites().getFavorites();
	}

	private void getFavorites() {
		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("method", Constants.FLICKR_FAVORITES_METHOD);
		urlParams.put("api_key", Constants.API_KEY);
		urlParams.put("auth_token", Constants.AUTH_TOKEN);
		urlParams.put("api_sig", FlickrUtil.getMD5Hash(Constants.SIGNATURE+Constants.FLICKR_FAVORITES_METHOD));
		System.err.println(Constants.SIGNATURE+Constants.FLICKR_FAVORITES_METHOD);
		FlickrClient.get(Constants.FLICKR_HOST, Constants.FLICR_PATH, urlParams);
				
	}

}

/*

http://www.flickr.com/services/oauth/request_token
?oauth_nonce=89601180
&oauth_timestamp=1305583298
&oauth_consumer_key=653e7a6ecc1d528c516cc8f92cf98611
&oauth_signature_method=HMAC-SHA1
&oauth_version=1.0
&oauth_callback=http%3A%2F%2Fwww.example.com


: 	

bZFLt0UmE2TpswlRc5nXDMf5z4g=


http://www.flickr.com/services/oauth/request_token?oauth_nonce=I6oBrUSmzO7&oauth_timestamp=1384316143&oauth_consumer_key=069c4767675f14688238ef0c0c9dc059&oauth_signature_method=HMAC-SHA1&oauth_version=1.0&oauth_signature=dsXSaMiMgA9HwrUFwJBaesYcdkE=&oauth_callback=http%3A%2F%2Fhealthelves-lm.corp.yahoo.com

	
	
	oauth_callback_confirmed=true&oauth_token=72157637617996566-9da5b490ec08864b&oauth_token_secret=164ea3e32c6bf817
	
			http://www.flickr.com/services/oauth/authorize?oauth_token=72157637617996566-9da5b490ec08864b&perms=delete
	
				http://healthelves-lm.corp.yahoo.com/?oauth_token=72157637617996566-9da5b490ec08864b&oauth_verifier=285d1cd1921f0175
	
					
					
					http://www.flickr.com/services/oauth/access_token?oauth_nonce=wWxHMXlsXaa&oauth_timestamp=1384316527&oauth_verifier=285d1cd1921f0175&oauth_consumer_key=069c4767675f14688238ef0c0c9dc059&oauth_signature_method=HMAC-SHA1&oauth_version=1.0&oauth_token=72157637617996566-9da5b490ec08864b&oauth_signature=WhzeH8hOHGe/0pTLm6e5yDJ5JDM=

http://flickr.com/services/auth/?api_key=069c4767675f14688238ef0c0c9dc059&perms=delete&api_sig=99ee92ff201dbcc8a697ab6c0d9a9c6f

a83bb620b8995cc2api_key069c4767675f14688238ef0c0c9dc059permsdelete

http://strangeletter.corp.yahoo.com/?frob=72157637640099863-c1c85dbb5838ac59-107474786


a83bb620b8995cc2api_key069c4767675f14688238ef0c0c9dc059frob72157637640099863-c1c85dbb5838ac59-107474786methodflickr.auth.getToken

3ad3da1e3506d02512b63c75a3e3e556

api.flickr.com/services/rest/?api_key=069c4767675f14688238ef0c0c9dc059&method=flickr.auth.getToken&api_sig=3ad3da1e3506d02512b63c75a3e3e556&frob=72157637640099863-c1c85dbb5838ac59-107474786

<rsp stat="ok"><auth><token>72157637640099833-1edf4725ca8d05db</token><perms>delete</perms><user nsid="107496116@N07" username="narayanan.nachiappan" fullname="Narayanan Nachiappan"/></auth></rsp>

a83bb620b8995cc2api_key069c4767675f14688238ef0c0c9dc059auth_token72157637640099833-1edf4725ca8d05dbmethodflickr.favorites.getList

http://api.flickr.com/services/rest/?api_key=069c4767675f14688238ef0c0c9dc059&method=flickr.favorites.getList&api_sig=07a6cb881ee75a694f5e6dde05223324&auth_token=72157637640099833-1edf4725ca8d05db

http://api.flickr.com/services/rest/?api_key=069c4767675f14688238ef0c0c9dc059&method=flickr.favorites.getList&api_sig=07a6cb881ee75a694f5e6dde05223324&auth_token=72157637640099833-1edf4725ca8d05db

http://api.flickr.com/services/rest/?api_key=069c4767675f14688238ef0c0c9dc059&api_sig=9992ebb08a2061d87b0e5150ae019eea&auth_token=72157637640099833-1edf4725ca8d05db&method=flickr.favorites.getList*
*/