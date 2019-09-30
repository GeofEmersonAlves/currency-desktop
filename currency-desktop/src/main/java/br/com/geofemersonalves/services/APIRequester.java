package br.com.geofemersonalves.services;

import java.io.IOException;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

/**
 * Get informations from API http end point
 * 
 *   APIKEY is a constant with the access key for the HGbrasil API.
 * Here I am using a free one that I got with my HGbrasil account, 
 * this key have limit access so it is better you get one 
 * from https://hgbrasil.com/.       
 * 
 * @author Emerson Alves da silva
 * 
 */
public class APIRequester {
	private final static String IP_API_ENDPOINT="http://checkip.dyndns.org/";
	private final static String APIKEY="5d57817e";
	private final static String APIWEATHER_ENDPOINT="https://api.hgbrasil.com/weather?format=json-cors&key=";
	private final static String APIFINANCESDATA_ENDPOINT="https://api.hgbrasil.com/finance?format=json-cors&key="; //fields=currencies,stocks,taxes&
	/**
	 * Get the external IP Address
	 * 
	 * @return String with the external IP Address
	 * 
	 */
	public String getExternalIP() {
		String ipAdress;
		
		ipAdress = sendRequest(IP_API_ENDPOINT);
		
		ipAdress = ipAdress.split(":")[1].trim(); 
		
		return ipAdress.substring(0,ipAdress.indexOf("<"));		
	}

	/**
	 * Get the weather condition and forecast from HG Brasil Weather API
	 * 
	 * @return JSON object with the weather information
	 * 
	 */
	public JSONObject getWeather() {
		String weatherInfo;
		weatherInfo=sendRequest(APIWEATHER_ENDPOINT+APIKEY);
		JSONObject weatherObj= new JSONObject(weatherInfo);

		return weatherObj;
	}
	/**
	 * Get the currencies information from HG Brasil Finance API
	 * 
	 * @return JSON object with the currencies information
	 *
	 */
	public JSONObject getFinancalData() {
		String currenciesInfo;
		currenciesInfo = sendRequest(APIFINANCESDATA_ENDPOINT+APIKEY);
		
		JSONObject currenciesObj = new JSONObject(currenciesInfo);
		
		return currenciesObj;
	}
	/**
	 *  Send a request for the api access point
	 *  
	 * @param httpAccessPoint - http address of access point
	 * 
	 * @return String with the API response
	 * 
	 */
	private static String sendRequest(String httpAccessPoint) {
		//HttpClient httpclient = new DefaultHttpClient(); // ** Deprecated
		CloseableHttpClient  httpclient = HttpClientBuilder.create().build();   
		
		try {
			// URL definition
			HttpGet httpget = new HttpGet(httpAccessPoint);  
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String html = httpclient.execute(httpget, responseHandler);
			return html;		  
			
		} catch (Exception e) {
			throw new RuntimeException("Something gets wrong!", e);
			
		} finally {
			//httpclient.getConnectionManager().shutdown(); // ** Deprecated
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}				
	}
}
