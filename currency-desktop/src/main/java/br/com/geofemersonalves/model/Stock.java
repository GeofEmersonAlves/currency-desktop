package br.com.geofemersonalves.model;

import java.math.BigDecimal;

import org.json.JSONObject;

/**
 * Class that represent one stock position
 * 
 * @author Emerson Alves da Silva
 *
 */
public class Stock {
	String iso;
	String name;
	String location;
	BigDecimal points=null;
	BigDecimal variation;
	
	//getters and setters
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public BigDecimal getPoints() {
		return points;
	}
	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	public BigDecimal getVariation() {
		return variation;
	}
	public void setVariation(BigDecimal variation) {
		this.variation = variation;
	}
	
	/**
	 * Create a empty Stock object
	 */
	public Stock() {
		super();
	}
	/**
	 * Create a new Stock object with the parameters
	 * 
	 * @param iso
	 * @param name
	 * @param location
	 * @param points
	 * @param variation
	 */
	public Stock(String iso, String name, String location, BigDecimal points, BigDecimal variation) {
		super();
		this.iso = iso;
		this.name = name;
		this.location = location;
		this.points = points;
		this.variation = variation;
	}
	/**
	 * Create a new Stock object with a JSON String,
	 * it must be:
	 * {
	 * 		"iso":  "IBOVESPA",
     *		"name": "BM&F BOVESPA",
	 *		"location": "Sao Paulo, Brazil",
	 *		"points": 101915.219,
	 *		"variation": -2
		}
	 * @param jsonStringStock
	 */
	public Stock(String jsonStringStock) {
		super();
		JSONObject jsonStock = new JSONObject(jsonStringStock);
		
		this.iso = jsonStock.getString("iso");
		this.name = jsonStock.getString("name");
		this.location = jsonStock.getString("location");
		if(jsonStock.has("points")) {
			this.points = new BigDecimal(Double.toString(jsonStock.getDouble("points")));
		}
		this.variation = new BigDecimal(Double.toString(jsonStock.getDouble("variation ")));		
	}
	/**
	 * Create a new Stock object with a JSON Stock object
	 * 
	 * @param jsonStock
	 */
	public Stock(JSONObject jsonStock) {
		super();
		
		this.iso = jsonStock.getString("iso");
		this.name = jsonStock.getString("name");
		this.location = jsonStock.getString("location");
		if(jsonStock.has("points")) {
			this.points = new BigDecimal(Double.toString(jsonStock.getDouble("points")));
		}
		this.variation = new BigDecimal(Double.toString(jsonStock.getDouble("variation ")));		
	}
	
	
	@Override
	public String toString() {
		JSONObject jsonStock = new JSONObject();
		jsonStock.put("iso", this.iso) ;
		jsonStock.put("name",this.name);
		jsonStock.put("location",this.location);
		if(this.points!=null) {
			jsonStock.put("points",this.points);
		}
		jsonStock.put("variation",this.variation);
		
		return jsonStock.toString();
	}

}
