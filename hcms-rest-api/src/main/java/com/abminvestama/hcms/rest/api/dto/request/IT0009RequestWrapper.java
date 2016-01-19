package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */

public class IT0009RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = 2539645779455671060L;

	private double betrg;
	private String waers;
	private double anzhl;
	private String bnksa;
	private String zlsch;
	private String emftx;
	private String bkplz;
	private String bkort;
	private String banks;
	private String bankl;
	private String bankn;
	private String zweck;
	
	@JsonProperty("standard_value")
	public double getBetrg() {
		return betrg;
	}
	
	@JsonProperty("payment_currency")
	public String getWaers() {
		return waers;
	}
	
	@JsonProperty("standard_percentage")
	public double getAnzhl() {
		return anzhl;
	}
	
	@JsonProperty("bank_details_type")
	public String getBnksa() {
		return bnksa;
	}
	
	@JsonProperty("payment_method")
	public String getZlsch() {
		return zlsch;
	}
	
	@JsonProperty("payee")
	public String getEmftx() {
		return emftx;
	}
	
	@JsonProperty("postal_code")
	public String getBkplz() {
		return bkplz;
	}
	
	@JsonProperty("city")
	public String getBkort() {
		return bkort;
	}
	
	@JsonProperty("bank_country")
	public String getBanks() {
		return banks;
	}
	
	@JsonProperty("bank_key")
	public String getBankl() {
		return bankl;
	}
	
	@JsonProperty("bank_account")
	public String getBankn() {
		return bankn;
	}
	
	@JsonProperty("purpose")
	public String getZweck() {
		return zweck;
	}
}