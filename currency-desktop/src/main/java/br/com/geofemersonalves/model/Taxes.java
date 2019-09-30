package br.com.geofemersonalves.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Taxes {
	private Date date;
	private BigDecimal cdi;
	private BigDecimal selic;
	private BigDecimal dailyFactor;
	
	//Getters and Setters
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getCdi() {
		return cdi;
	}
	public void setCdi(BigDecimal cdi) {
		this.cdi = cdi;
	}
	public BigDecimal getSelic() {
		return selic;
	}
	public void setSelic(BigDecimal selic) {
		this.selic = selic;
	}
	public BigDecimal getDailyFactor() {
		return dailyFactor;
	}
	public void setDailyFactor(BigDecimal dailyFactor) {
		this.dailyFactor = dailyFactor;
	}
	
	/**
	 * Create a empty Taxes object
	 */
	public Taxes() {
		super();
	}
	/**
	 * Create a new Taxes object with the parameters
	 * 
	 * @param date
	 * @param cdi
	 * @param selic
	 * @param dailyFactor
	 */
	public Taxes(Date date, BigDecimal cdi, BigDecimal selic, BigDecimal dailyFactor) {
		super();
		this.date = date;
		this.cdi = cdi;
		this.selic = selic;
		this.dailyFactor = dailyFactor;
	}
	/**
	 * Create a new Taxes object with the JSON Taxes string,
	 * It must be like:
	 * {
	 *  	"date": "2019-08-09",
	 *  	"cdi": 5.9,
	 *      "selic": 5.9,
	 *      "daily_factor": 1.00022751
	 * }
	 *      
	 * @param jsonTaxes
	 * @throws ParseException 
	 * @throws JSONException 
	 */
	public Taxes(String jsonStringTaxes) throws JSONException, ParseException {
		super();
		
		JSONObject jsonTaxes= new JSONObject(jsonStringTaxes);
		this.date = new SimpleDateFormat("dd/MM/yyyy").parse(jsonTaxes.getString("date"));
		this.cdi = new BigDecimal(Double.toString(jsonTaxes.getDouble("cdi")));
		this.selic = new BigDecimal(Double.toString(jsonTaxes.getDouble("selic")));
		this.dailyFactor = new BigDecimal(Double.toString(jsonTaxes.getDouble("daily_factor")));
	}
	/**
	 * Create a new Taxes object from a taxes JSONObject
	 * @param jsonTaxes
	 * @throws ParseException 
	 * @throws JSONException 
	 */
	public Taxes(JSONObject jsonTaxes) throws JSONException, ParseException {
		super();
		this.date = new SimpleDateFormat("dd/MM/yyyy").parse(jsonTaxes.getString("date"));
		this.cdi = new BigDecimal(Double.toString(jsonTaxes.getDouble("cdi")));
		this.selic = new BigDecimal(Double.toString(jsonTaxes.getDouble("selic")));
		this.dailyFactor = new BigDecimal(Double.toString(jsonTaxes.getDouble("daily_factor")));		
	}
	
	@Override
	public String toString() {
		JSONObject jsonTaxes= new JSONObject();
		jsonTaxes.put("date", new SimpleDateFormat ("dd/MM/yyyy").format(date));
		jsonTaxes.put("cdi", this.cdi);
		jsonTaxes.put("selic",this.selic);
		jsonTaxes.put("daily_factor",this.dailyFactor);
		
		return jsonTaxes.toString();
	}
}
