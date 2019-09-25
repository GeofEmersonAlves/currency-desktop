package br.com.geofemersonalves;

import br.com.geofemersonalves.services.APIRequester;

public class App 
{
    public static void main( String[] args )   {
    	APIRequester apiRequester= new APIRequester();
    	
        System.out.println(apiRequester.getExternalIP());
        System.out.println(apiRequester.getWeather());
        System.out.println(apiRequester.getCurrencies());
    }
}
