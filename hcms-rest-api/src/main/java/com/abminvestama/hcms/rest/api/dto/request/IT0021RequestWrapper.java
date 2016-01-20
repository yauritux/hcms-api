package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0021RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = 6742574229923918283L;
	
	private String famsa;
	private String fgbdt;
	private String fgbld;
	private String fanat;
	private String fasex;
	private String favor;
	private String fanam;
	private String fgbot;
	private String fcnam;
	private int fknzn;
	private String fnmzu;
	private String title;
	
	@JsonProperty("family_member")
	public String getFamsa() {
		return famsa;
	}
	
	@JsonProperty("date_of_birth")
	public String getFgbdt() {
		return fgbdt;
	}
	
	@JsonProperty("country_of_birth")
	public String getFgbld() {
		return fgbld;
	}
	
	@JsonProperty("nationality")
	public String getFanat() {
		return fanat;
	}
	
	@JsonProperty("gender")
	public String getFasex() {
		return fasex;
	}
	
	@JsonProperty("first_name")
	public String getFavor() {
		return favor;
	}
	
	@JsonProperty("last_name")
	public String getFanam() {
		return fanam;
	}
	
	@JsonProperty("birth_place")
	public String getFgbot() {
		return fgbot;
	}
	
	@JsonProperty("full_name")
	public String getFcnam() {
		return fcnam;
	}
	
	@JsonProperty("ind_name")
	public int getFknzn() {
		return fknzn;
	}
	
	@JsonProperty("other_title")
	public String getFnmzu() {
		return fnmzu;
	}
	
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
}