package br.com.geofemersonalves.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Currencies model, that have a ArrayList of the currencies 
 * @author Emerson
 *
 */
public class Currencies {
	private String source;
	private ArrayList<Currency> currencyList=new ArrayList<>();
	
	//Getters and Setters
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public ArrayList<Currency> getCurrencyList() {
		return currencyList;
	}
	public void setCurrencyList(ArrayList<Currency> currencyList) {
		this.currencyList = currencyList;
	}
	
	//Constructors
	/**
	 * Create a empty Currencies object
	 */
	public Currencies() {
		super();
	}
	/**
	 * Create a new Currencies object from a JSON String,
	 * it must be like:
	 *  {
	 *		"source": "BRL",
	 *		"USD": {
	 *			"name": "Dollar",
	 *			"buy": 3.9837,
	 *			"sell": 3.9848,
	 *			"variation": 1.058
	 *		},
	 *		"EUR": {
	 *			"name": "Euro",
	 *			"buy": 4.4663,
	 *			"sell": 4.4703,
	 *			"variation": 1.128
	 *		}
	 *	}
	 *	
	 * @param jsonCurrencies
	 */
	public Currencies(String jsonCurrencies) {
		super();
		JSONObject cObj = new JSONObject(jsonCurrencies);
		auxCurrencies(cObj);
	}
	
	public Currencies(JSONObject cObj) {
		super();
		auxCurrencies(cObj);
	}
	
	
	/**
	 * Private method to help the constructors don't repeat Java code
	 * 
	 * @param cObj
	 */
	private void auxCurrencies(JSONObject cObj) {
		JSONArray  keyNames =cObj.names();
		
		for(int i = 0; i < keyNames.length(); i++) {
			String key= keyNames.getString(i);
			
			if(key.equals("source")) {
				this.source=cObj.getString(key);
				
			} else {
				JSONObject obj = cObj.getJSONObject(key);
				obj.put("iso",key);
				Currency currency = new Currency(obj);
				currencyList.add(currency);
			}
		}		
	}
	
	
	@Override
	public String toString() {
		JSONObject obj = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		for (Currency currency2 : currencyList) {
			JSONObject objCurrency = new JSONObject(currency2.toString());
			jsonArray.put(objCurrency);
		}
		
		obj.put("source",this.source);
		obj.put("currencies",jsonArray);
		
		return obj.toString();
	}
}
