package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0022RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = -6702420198984433220L;

	private String slart;
	private String insti;
	private String sland;
	private long ausbi;
	private String slabs;
	private double anzkl;
	private String anzeh;
	private String sltp1;
	private String sltp2;
	
	/**
	 * GET Education Est.
	 * 
	 * @return
	 */
	@JsonProperty("education_est_code")
	public String getSlart() {
		return slart;
	}
	
	/**
	 * GET Institute/Location.
	 * 
	 * @return
	 */
	@JsonProperty("institute")
	public String getInsti() {
		return insti;
	}
	
	/**
	 * GET Country Key.
	 * 
	 * @return
	 */
	@JsonProperty("country_key")
	public String getSland() {
		return sland;
	}
	
	/**
	 * GET Education/Training Code.
	 * 
	 * @return
	 */
	@JsonProperty("edu_or_training_code")
	public long getAusbi() {
		return ausbi;
	}
	
	/**
	 * GET Certificate Code.
	 * 
	 * @return
	 */
	@JsonProperty("certificate_code")
	public String getSlabs() {
		return slabs;
	}
	
	/**
	 * GET Duration of Courses.
	 * 
	 * @return
	 */
	@JsonProperty("duration_of_courses")
	public double getAnzkl() {
		return anzkl;
	}
	
	/**
	 * GET Unit of Time/Meas.
	 * 
	 * @return
	 */
	@JsonProperty("unit_of_time_code")
	public String getAnzeh() {
		return anzeh;
	}
	
	/**
	 * GET Branch of Study 1.
	 * 
	 * @return
	 */
	@JsonProperty("branch_study1_code")
	public String getSltp1() {
		return sltp1;
	}
	
	/**
	 * GET Branch of Study 2.
	 * 
	 * @return
	 */
	@JsonProperty("branch_study2_code")
	public String getSltp2() {
		return sltp2;
	}
}