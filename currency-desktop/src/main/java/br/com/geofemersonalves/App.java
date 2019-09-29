package br.com.geofemersonalves;

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.geofemersonalves.model.Weather;
import br.com.geofemersonalves.model.Currencies;
import br.com.geofemersonalves.model.Currency;
import br.com.geofemersonalves.services.APIRequester;

public class App 
{
    public static void main( String[] args )   {
    	
    	APIRequester apiRequester= new APIRequester();
    	
        System.out.println(apiRequester.getExternalIP());
        
        JSONObject jsonWeather = apiRequester.getWeather();
        System.out.println(jsonWeather);
        
        Weather weather=new Weather();;
        try {
        	weather = new Weather(jsonWeather.getJSONObject("results"));

        } catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
        
        System.out.println("----------------------------");
        System.out.println(weather);
        
        System.out.println("---------FINANCES-----------");
        JSONObject jsonFinances = apiRequester.getFinancalData();
        
        System.out.println("Currencies-----------------------");
        
        JSONObject jsonCurrencies = jsonFinances.getJSONObject("results")
		         								.getJSONObject("currencies");
        System.out.println(jsonCurrencies);               
        Currencies currencies= new Currencies(jsonCurrencies);
        System.out.println(currencies);
        
    }
}
