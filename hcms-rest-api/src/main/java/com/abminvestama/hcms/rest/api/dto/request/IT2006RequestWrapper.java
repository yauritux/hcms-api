package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT2006RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = -4536274729925117737L;
	
	private int ktart;
	private double anzhl;
	private double kverb;
	private String desta;
	private String deend;
	
	/**
	 * GET Absence Quota Type.
	 * 
	 * @return
	 */
	@JsonProperty("absence_quota_type")
	public int getKtart() {
		return ktart;
	}
	
	/**
	 * GET Quota Number.
	 * 
	 * @return
	 */
	@JsonProperty("quota_number")
	public double getAnzhl() {
		return anzhl;
	}
	
	/**
	 * GET Quota Deduction.
	 * 
	 * @return
	 */
	@JsonProperty("quota_deduction")
	public double getKverb() {
		return kverb;
	}
	
	/**
	 * GET Deduction From (Date).
	 * 
	 * @return
	 */
	@JsonProperty("deduction_from_date")
	public String getDesta() {
		return desta;
	}
	
	/**
	 * GET Deduction To (Date).
	 * @return
	 */
	@JsonProperty("deduction_to_date")
	public String getDeend() {
		return deend;
	}
}