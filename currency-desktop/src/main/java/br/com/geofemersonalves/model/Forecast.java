package br.com.geofemersonalves.model;

import org.json.JSONObject;

/**
 * Model for one day forecast
 *  
 * @author Emerson Alves da Silva
 *
 */
public class Forecast {
	private String date;
	private String weekDay;
	private int maxTemp;
	private int minTemp;
	private String description;
	private String condition;
	
	
	/**
	 * Constructor with each properties of one forecast
	 * 
	 * @param date
	 * @param weekDay
	 * @param maxTemp
	 * @param minTemp
	 * @param description
	 * @param condition
	 */
	public Forecast(String date, String weekDay, int maxTemp, int minTemp, String description, String condition) {
		super();
		this.date = date;
		this.weekDay = weekDay;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.description = description;
		this.condition = condition;
	}
	
	/**
	 * Constructor with a JSON string for forecast
	 * it must be like:
	 * {
	 *	"date": "14/08",
	 *	"weekday": "Qua",
	 *	"max": 14,
	 *	"min": 10,
	 *	"description": "Tempo nublado",
	 *	"condition": "cloudly_day"
	 *}
	 * @param jsonString
	 */
	public Forecast(String jsonString) {
		super();
		
		JSONObject obj = new  JSONObject(jsonString);
		this.date = obj.getString("date");
		this.weekDay = obj.getString("weekday");
		this.maxTemp = obj.getInt("max");
		this.minTemp = obj.getInt("min");
		this.description = obj.getString("description");
		this.condition = obj.getString("condition");
	}
	/**
	 * Constructor with one JSONObject forecast
	 * 
	 * @param obj
	 */
	public Forecast(JSONObject obj) {
		super();
		
		this.date = obj.getString("date");
		this.weekDay = obj.getString("weekday");
		this.maxTemp = obj.getInt("max");
		this.minTemp = obj.getInt("min");
		this.description = obj.getString("description");
		this.condition = obj.getString("condition");		
	}

	//Getters
	public String getDate() {
		return date;
	}
	public String getWeekDay() {
		return weekDay;
	}
	public int getMaxTemp() {
		return maxTemp;
	}
	public int getMinTemp() {
		return minTemp;
	}
	public String getDescription() {
		return description;
	}
	public String getCondition() {
		return condition;
	}

	@Override
	public String toString() {
		JSONObject obj = new  JSONObject();
		
		obj.put("date", date);
		obj.put("weekday" ,weekDay);
		obj.put("max", maxTemp);
		obj.put("min", minTemp);
		obj.put("description",description);
		obj.put("condition", condition);
		
		return   obj.toString();
	}
}
