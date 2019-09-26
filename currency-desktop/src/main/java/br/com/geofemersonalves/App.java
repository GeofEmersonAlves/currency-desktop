package br.com.geofemersonalves;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.geofemersonalves.model.Weather;
import br.com.geofemersonalves.services.APIRequester;

public class App 
{
    public static void main( String[] args )   {
    	APIRequester apiRequester= new APIRequester();
    	
        System.out.println(apiRequester.getExternalIP());
        
        JSONObject jsonWeather = apiRequester.getWeather();
        System.out.println(jsonWeather);
        
        Weather weather=new Weather();
        try {
			weather = new Weather(jsonWeather.getJSONObject("results"));

        } catch (JSONException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(weather);
        System.out.println(apiRequester.getCurrencies());
    }
}
