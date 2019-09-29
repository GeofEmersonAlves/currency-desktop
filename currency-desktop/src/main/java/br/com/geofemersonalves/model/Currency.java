package br.com.geofemersonalves.model;

import java.math.BigDecimal;

import org.json.JSONObject;

/**
 * Class that represents one Currency, the base Currency is not part of this class
 * 
 * @author Emerson Alves da Silva
 *
 */
public class Currency {
	private String iso;
	private String name;
	private BigDecimal buy;
	//private BigDecimal sell; --it came null sometimes
	private BigDecimal variation;
	
	//Getters and Setters
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
	public BigDecimal getBuy() {
		return buy;
	}
	public void setBuy(BigDecimal buy) {
		this.buy = buy;
	}
/*	
   public BigDecimal getSell() {
		return sell;
	}
	public void setSell(BigDecimal sell) {
		this.sell = sell;
	}
*/
	public BigDecimal getVariation() {
		return variation;
	}
	public void setVariation(BigDecimal variation) {
		this.variation = variation;
	}
	
	//Constructors
	public Currency() {
		super();
	}
	/**
	 * Create a new Currency object with the parameters
	 * 
	 * @param iso Currency string code
	 * @param name Currency's name
	 * @param buy  
	 * @param variation
	 */
	public Currency(String iso, String name, BigDecimal buy, BigDecimal variation) {
		super();
		this.iso = iso;
		this.name = name;
		this.buy = buy;
		//this.sell = sell;
		this.variation = variation;
	}
	/**
	 * Create a new Currency object from a JSON String.
	 * it must be: 
	 * {
	 *   "iso": "USD",
	 *   "name": "Dollar",
	 *	 "buy": 3.9837,
	 *	 "sell": 3.9848,
	 *	 "variation": 1.058
	 *	}
	 * @param jsonStringCurrency
	 */
	public Currency(String jsonStringCurrency) {
		super();
		JSONObject jsonCurrency = new  JSONObject(jsonStringCurrency);
		
		this.iso = jsonCurrency.getString("iso");
		this.name = jsonCurrency.getString("name");
		this.buy = new BigDecimal(Double.toString(jsonCurrency.getDouble("buy")));
		/*if(jsonCurrency.get("sell") != null) { 
			this.sell = new BigDecimal(Double.toString(jsonCurrency.getDouble("sell")));
		}*/
		this.variation = new BigDecimal(Double.toString(jsonCurrency.getDouble("variation")));	
	}
	/**
	 * Create a new Currency object from a JSONObject
	 *  
	 * @param obj
	 */
	public Currency(JSONObject jsonCurrency) {
		super();

		this.iso = jsonCurrency.getString("iso");
		this.name = jsonCurrency.getString("name");
		this.buy = new BigDecimal(Double.toString(jsonCurrency.getDouble("buy"))) ;
		/*if(jsonCurrency.get("sell") != null) { 
			System.out.println(Double.toString(jsonCurrency.getDouble("sell")));
			this.sell = new BigDecimal(Double.toString(jsonCurrency.getDouble("sell")));
		}*/	
		this.variation = new BigDecimal(Double.toString(jsonCurrency.getDouble("variation")));	
		
	}
	
	@Override
	public String toString() {
		JSONObject obj = new JSONObject();
		
		obj.put("iso", this.iso);
		obj.put("name", this.name);
		obj.put("buy", this.buy);
		//obj.put("sell", this.sell);
		obj.put("variation", this.variation);
		
		return obj.toString();
	}
}
