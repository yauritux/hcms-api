package com.abminvestama.hcms.rest.api.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Base class for all request payload objects. 
 *
 */
public class ITRequestWrapper implements Serializable {

	private static final long serialVersionUID = 5393202597259317592L;
	
	private long pernr;
	private String subty;
	private String endda;
	private String begda;
	
	@JsonIgnore
	private boolean isDataChanged;
	
	public boolean isDataChanged() {
		return isDataChanged;
	}
	
	public void setIsDataChanged(boolean isDataChanged) {
		this.isDataChanged = isDataChanged;
	}
	
	@JsonProperty("ssn")
	public long getPernr() {
		return pernr;
	}
	
	@JsonProperty("subtype")
	public String getSubty() {
		return subty;
	}
	
	@JsonProperty("end_date")
	public String getEndda() {
		return endda;
	}
	
	@JsonProperty("begin_date")
	public String getBegda() {
		return begda;
	}
}