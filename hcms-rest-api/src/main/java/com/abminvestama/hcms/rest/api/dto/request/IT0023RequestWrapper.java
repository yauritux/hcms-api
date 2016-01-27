package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0023RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = 5810708859718546691L;
	
	private String arbgb;
	private String ort01;
	private String land1;
	private String branc;
	private long taete;
	private String ansvx;
	
	@JsonProperty("employer")
	public String getArbgb() {
		return arbgb;
	}
	
	@JsonProperty("city")
	public String getOrt01() {
		return ort01;
	}
	
	@JsonProperty("country_key")
	public String getLand1() {
		return land1;
	}
	
	@JsonProperty("industry_code")
	public String getBranc() {
		return branc;
	}
	
	@JsonProperty("job_code")
	public long getTaete() {
		return taete;
	}
	
	@JsonProperty("work_contract")
	public String getAnsvx() {
		return ansvx;
	}
}