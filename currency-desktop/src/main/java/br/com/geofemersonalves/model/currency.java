package br.com.geofemersonalves.model;

import java.math.BigDecimal;

/**
 * Class that represents one currency, the base currency is not part of this class
 * 
 * @author Emerson Alves da Silva
 *
 */
public class currency {
	private String iso;
	private String name;
	private BigDecimal buy;
	private BigDecimal sell;
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
	public BigDecimal getSell() {
		return sell;
	}
	public void setSell(BigDecimal sell) {
		this.sell = sell;
	}
	public BigDecimal getVariation() {
		return variation;
	}
	public void setVariation(BigDecimal variation) {
		this.variation = variation;
	}
	
	//Constructors
	public currency() {
		super();
	}
	/**
	 * Create a new currency with the parameters
	 * 
	 * @param iso Currency string code
	 * @param name Currency's name
	 * @param buy  
	 * @param sell
	 * @param variation
	 */
	public currency(String iso, String name, BigDecimal buy, BigDecimal sell, BigDecimal variation) {
		super();
		this.iso = iso;
		this.name = name;
		this.buy = buy;
		this.sell = sell;
		this.variation = variation;
	}
	
	//TODO others constructors and toString() 
}
