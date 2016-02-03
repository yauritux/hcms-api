package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT2006;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class IT2006ResponseWrapper extends ResourceSupport {

	private long pernr;
	private String subty;
	private Date endda;
	private Date begda;
	
	private String subtyText;

	private int ktart;
	private String ktartText;
	private double anzhl;
	private double kverb;
	private Date desta;
	private Date deend;
	
	private IT2006ResponseWrapper() {}
	
	public IT2006ResponseWrapper(IT2006 it2006) {
		if (it2006 == null) {
			new IT2006ResponseWrapper();
		} else {
			this
			.setPernr(it2006.getId().getPernr())
			.setSubty(it2006.getSubty() != null ? 
					StringUtils.defaultString(it2006.getSubty().getId() != null ? 
							it2006.getSubty().getId().getSubty() : StringUtils.EMPTY, StringUtils.EMPTY) 
					: it2006.getId().getSubty())
			.setEndda(it2006.getId().getEndda()).setBegda(it2006.getId().getBegda())
			.setSubtyText(it2006.getSubty() != null ? StringUtils.defaultString(it2006.getSubty().getStext(), StringUtils.EMPTY) : StringUtils.defaultString(it2006.getId().getSubty(), StringUtils.EMPTY))
			.setKtart(it2006.getKtart() != null ? it2006.getKtart().getKtart().intValue() : 0)
			.setKtartText(it2006.getKtart() != null ? StringUtils.defaultString(it2006.getKtart().getKtext(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setAnzhl(it2006.getAnzhl() != null ? it2006.getAnzhl().doubleValue() : 0.0)
			.setKverb(it2006.getKverb() != null ? it2006.getKverb().doubleValue() : 0.0)
			.setDesta(it2006.getDesta()).setDeend(it2006.getDeend());			
		}
	}
	
	/**
	 * GET Employee SSN.
	 * 
	 * @return
	 */
	@JsonProperty("ssn")
	public long getPernr() {
		return pernr;
	}
	
	private IT2006ResponseWrapper setPernr(long pernr) {
		this.pernr = pernr;
		return this;
	}
	
	/**
	 * GET Subtype Code.
	 * 
	 * @return
	 */
	@JsonProperty("subtype")
	public String getSubty() {
		return subty;
	}
	
	private IT2006ResponseWrapper setSubty(String subty) {
		this.subty = subty;
		return this;
	}
	
	/**
	 * GET End Date.
	 * 
	 * @return
	 */
	@JsonProperty("end_date")
	public Date getEndda() {
		return endda;
	}
	
	private IT2006ResponseWrapper setEndda(Date endda) {
		this.endda = endda;
		return this;
	}
	
	/**
	 * GET Begin Date.
	 * 
	 * @return
	 */
	@JsonProperty("begin_date")
	public Date getBegda() {
		return begda;
	}
	
	private IT2006ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET Subtype name.
	 * 
	 * @return
	 */
	@JsonProperty("subtype_text")
	public String getSubtyText() {
		return subtyText;
	}
	
	private IT2006ResponseWrapper setSubtyText(String subtyText) {
		this.subtyText = subtyText;
		return this;
	}
	
	/**
	 * GET Absence Quota Type.
	 * 
	 * @return
	 */
	@JsonProperty("absence_quota_type")
	public int getKtart() {
		return ktart;
	}
	
	private IT2006ResponseWrapper setKtart(int ktart) {
		this.ktart = ktart;
		return this;
	}
	
	/**
	 * GET Quota Text.
	 * 
	 * @return
	 */
	@JsonProperty("quota_text")
	public String getKtartText() {
		return ktartText;
	}
	
	private IT2006ResponseWrapper setKtartText(String ktartText) {
		this.ktartText = ktartText;
		return this;
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
	
	private IT2006ResponseWrapper setAnzhl(double anzhl) {
		this.anzhl = anzhl;
		return this;
	}
	
	/**
	 * GET Deduction.
	 * 
	 * @return
	 */
	@JsonProperty("deduction")
	public double getKverb() {
		return kverb;
	}
	
	private IT2006ResponseWrapper setKverb(double kverb) {
		this.kverb = kverb;
		return this;
	}
	
	/**
	 * GET Deduction From (Date).
	 * 
	 * @return
	 */
	@JsonProperty("deduction_from_date")
	public Date getDesta() {
		return desta;
	}
	
	private IT2006ResponseWrapper setDesta(Date desta) {
		this.desta = desta;
		return this;
	}
	
	/**
	 * GET Deduction To (Date).
	 * 
	 * @return
	 */
	@JsonProperty("deduction_to_date")
	public Date getDeend() {
		return deend;
	}
	
	private IT2006ResponseWrapper setDeend(Date deend) { 
		this.deend = deend;
		return this;
	}
}