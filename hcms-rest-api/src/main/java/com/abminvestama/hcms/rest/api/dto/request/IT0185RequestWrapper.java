package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0185RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = -5234365762723526620L;
	
	private String ictyp;
	private String icnum;
	private String auth1;
	private String fpdat;
	private String expid;
	private String isspl;
	private String iscot;
	
	@JsonProperty("ic_type")
	public String getIctyp() {
		return ictyp;
	}
	
	@JsonProperty("ic_number")
	public String getIcnum() {
		return icnum;
	}
	
	@JsonProperty("issuing_authority")
	public String getAuth1() {
		return auth1;
	}
	
	@JsonProperty("issuing_date")
	public String getFpdat() {
		return fpdat;
	}
	
	@JsonProperty("expiry_date")
	public String getExpid() {
		return expid;
	}
	
	@JsonProperty("place_of_issue")
	public String getIsspl() {
		return isspl;
	}
	
	@JsonProperty("country_of_issue")
	public String getIscot() {
		return iscot;
	}
}