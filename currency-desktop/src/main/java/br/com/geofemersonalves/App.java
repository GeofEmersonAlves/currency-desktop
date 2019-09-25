package br.com.geofemersonalves;

import br.com.geofemersonalves.services.APIRequester;


public class App 
{
    public static void main( String[] args )   {
        
        System.out.println(APIRequester.getExternalIP());
        
    }
}
