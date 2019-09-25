package br.com.geofemersonalves.services;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Get informations from API http access point
 * 
 * @author Emerson Alves da silva
 * 
 */
public class APIRequester {
	private final static String APIKEY="5d57817e";

	/**
	 * Get the external IP Address
	 * 
	 * @return String with the external IP Address
	 * 
	 */
	public static String getExternalIP() {
		final String IPAPIACCESSPOINT="http://checkip.dyndns.org/";
		
		String ipAdress;
		
		ipAdress = sendRequest(IPAPIACCESSPOINT);
		
		return ipAdress.split(":")[1].trim().substring(0,ipAdress.split(":")[1].trim().indexOf("<"));		
	}

	
	/**
	 *  Send a request for the api access point
	 *  
	 * @param httpAccessPoint - http address of access point
	 * @return String with the API response
	 * 
	 */
	private static String sendRequest(String httpAccessPoint) {
		HttpClient httpclient = new DefaultHttpClient();
		try {
			// URL definition
			HttpGet httpget = new HttpGet(httpAccessPoint);  
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String html = httpclient.execute(httpget, responseHandler);
			return html;		  
			
		} catch (Exception e) {
			throw new RuntimeException("Something gets wrong!", e);
			
		} finally {
			httpclient.getConnectionManager().shutdown();
		}		
			
	}

}
