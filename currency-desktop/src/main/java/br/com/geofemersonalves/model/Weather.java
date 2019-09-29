package br.com.geofemersonalves.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Weather {
	private int temp;
	private Date date;
	private Date time;
	private int conditionCode;
	private String description;
	private String currently;
	private String city;
	private int humidity;
	private String windSpeedy;
	private String sunrise;
	private String sunset;
	private String conditionSlug;
	private String cityName;
	private ArrayList<Forecast> forecast;
	
	//Constructors
	/**
	 * Create a new Weather with each parameter 
	 * 
	 * @param temp
	 * @param date
	 * @param time
	 * @param conditionCode
	 * @param description
	 * @param currently
	 * @param city
	 * @param humidity
	 * @param windSpeedy
	 * @param sunrise
	 * @param sunset
	 * @param conditionSlug
	 * @param cityName
	 * @param forecast
	 */
	public Weather(int temp, Date date, Date time, int conditionCode, String description, String currently, String city,
			int humidity, String windSpeedy, String sunrise, String sunset, String conditionSlug, String cityName,
			ArrayList<Forecast> forecast) {
		super();
		this.temp = temp;
		this.date = date;
		this.time = time;
		this.conditionCode = conditionCode;
		this.description = description;
		this.currently = currently;
		this.city = city;
		this.humidity = humidity;
		this.windSpeedy = windSpeedy;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.conditionSlug = conditionSlug;
		this.cityName = cityName;
		this.forecast = forecast;
	}

	/**
	 * Create a new weather from a JSON String
	 * 
	 * @param jsonString
	 * @throws ParseException 
	 * @throws JSONException 
	 */
	public Weather(String jsonString) throws JSONException, ParseException {
		super();
		
		JSONObject obj = new JSONObject(jsonString);
		
		this.temp = obj.getInt("temp");
		this.date = new SimpleDateFormat("dd/MM/yyyy").parse(obj.getString("date"));
		this.time = new SimpleDateFormat("hh:mm").parse(obj.getString("time"));
		this.conditionCode = obj.getInt("condition_code");
		this.description = obj.getString("description");
		this.currently = obj.getString("currently");
		this.city = obj.getString("city");
		this.humidity = obj.getInt("humidity");
		this.windSpeedy = obj.getString("wind_speedy");
		this.sunrise = obj.getString("sunrise");
		this.sunset = obj.getString("sunset");
		this.conditionSlug = obj.getString("condition_slug");
		this.cityName = obj.getString("city_name");
		
		JSONArray jsonArrayForecast= obj.getJSONArray("forecast");
		ArrayList<Forecast> arrayForecast= new ArrayList<>();
		for(int i =0; i<jsonArrayForecast.length();i++) {
			arrayForecast.add(new Forecast(jsonArrayForecast.getJSONObject(i)));
		}
		this.forecast = arrayForecast;			
	}
	
	/**
	 * Create a new Weather with a JSONObject weather
	 * 
	 * @param obj
	 * @throws JSONException
	 * @throws ParseException
	 */
	public Weather(JSONObject obj) throws JSONException, ParseException {
		super();
		
		this.temp = obj.getInt("temp");
		this.date = new SimpleDateFormat("dd/MM/yyyy").parse(obj.getString("date"));
		this.time = new SimpleDateFormat("hh:mm").parse(obj.getString("time"));
		this.conditionCode = obj.getInt("condition_code");
		this.description = obj.getString("description");
		this.currently = obj.getString("currently");
		this.city = obj.getString("city");
		this.humidity = obj.getInt("humidity");
		this.windSpeedy = obj.getString("wind_speedy");
		this.sunrise = obj.getString("sunrise");
		this.sunset = obj.getString("sunset");
		this.conditionSlug = obj.getString("condition_slug");
		this.cityName = obj.getString("city_name");
		
		JSONArray jsonArrayForecast= obj.getJSONArray("forecast");
		ArrayList<Forecast> arrayForecast= new ArrayList<>();
		for(int i =0; i<jsonArrayForecast.length();i++) {
			arrayForecast.add(new Forecast(jsonArrayForecast.getJSONObject(i)));
		}
		this.forecast = arrayForecast;			
	}
	/**
	 * Create a empty weather obj
	 */
	public Weather() {
		super();
	}


	@Override
	public String toString() {
		JSONObject obj = new JSONObject();
		
		obj.put("temp",temp);
		obj.put("date",new SimpleDateFormat ("dd/MM/yyyy").format(date));
		obj.put("time",new SimpleDateFormat ("hh:mm").format(time));
		obj.put("condition_code",conditionCode);
		obj.put("description",description);
		obj.put("currently", currently);
		obj.put("city",city);
		obj.put("humidity",humidity);
		obj.put("wind_speedy",windSpeedy);
		obj.put("sunrise",sunrise);
		obj.put("sunset" ,sunset);
		obj.put("condition_slug",conditionSlug);
		obj.put("city_name",cityName);
		
		//Convert ArrayList<Forecast> to a JSONArray and put it into to a JSONObject
		JSONArray jsonArray = new JSONArray();
		for (Forecast forecast2 : forecast) {
			JSONObject objForecast = new JSONObject(forecast2.toString());
			jsonArray.put(objForecast);
		}
		obj.put("forecast",jsonArray);
		
		return obj.toString();
	}	
}
