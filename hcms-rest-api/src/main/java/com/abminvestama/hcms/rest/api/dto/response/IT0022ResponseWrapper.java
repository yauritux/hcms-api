package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0022;
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
public class IT0022ResponseWrapper extends ResourceSupport {

	private long pernr;
	private String subty;
	private Date endda;
	private Date begda;
	
	private String subtyText;
	
	private String slart;
	private String slartText;
	private String insti;
	private String sland;
	private String slandText;
	private long ausbi;
	private String ausbiText;
	private String slabs;
	private String slabsText;
	private double anzkl;
	private String anzeh;
	private String anzehText;
	private String sltp1;
	private String sltp1Text;
	private String sltp2;
	private String sltp2Text;

	private IT0022ResponseWrapper() {}
	
	public IT0022ResponseWrapper(IT0022 it0022) {
		if (it0022 == null) {
			new IT0022ResponseWrapper();
		} else {
			this
				.setPernr(it0022.getId().getPernr())
				.setSubty(it0022.getSubty() != null ? StringUtils.defaultString(it0022.getSubty().getSubty(), StringUtils.EMPTY) : it0022.getId().getSubty())
				.setEndda(it0022.getId().getEndda()).setBegda(it0022.getId().getBegda())
				.setSubtyText(it0022.getSubty() != null ? StringUtils.defaultString(it0022.getSubty().getStext(), StringUtils.EMPTY) : it0022.getId().getSubty())
				.setSlart(it0022.getSlart() != null ? StringUtils.defaultString(it0022.getSlart().getSlart(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setSlartText(it0022.getSlart() != null ? StringUtils.defaultString(it0022.getSlart().getStext(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setInsti(StringUtils.defaultString(it0022.getInsti(), StringUtils.EMPTY))
				.setSland(it0022.getSland() != null ? StringUtils.defaultString(it0022.getSland().getLand1(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setSlandText(it0022.getSland() != null ? StringUtils.defaultString(it0022.getSland().getLandx(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setAusbi(it0022.getAusbi() != null ? it0022.getAusbi().getAusbi().longValue() : 0)
				.setAusbiText(StringUtils.defaultString(it0022.getAusbi() != null ? it0022.getAusbi().getAtext() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setSlabs(StringUtils.defaultString(it0022.getSlabs() != null ? it0022.getSlabs().getSlabs() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setSlabsText(StringUtils.defaultString(it0022.getSlabs() != null ? it0022.getSlabs().getStext() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setAnzkl(it0022.getAnzkl() != null ? it0022.getAnzkl().doubleValue() : 0.0)
				.setAnzeh(StringUtils.defaultString(it0022.getAnzeh() != null ? it0022.getAnzeh().getZeinh() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setAnzehText(StringUtils.defaultString(it0022.getAnzeh() != null ? it0022.getAnzeh().getEtext() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setSltp1(StringUtils.defaultString(it0022.getSltp1() != null ? it0022.getSltp1().getFaart() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setSltp1Text(StringUtils.defaultString(it0022.getSltp1() != null ? it0022.getSltp1().getFtext() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setSltp2(StringUtils.defaultString(it0022.getSltp2() != null ? it0022.getSltp2().getFaart() : StringUtils.EMPTY, StringUtils.EMPTY))
				.setSltp2Text(StringUtils.defaultString(it0022.getSltp2() != null ? it0022.getSltp2().getFtext() : StringUtils.EMPTY, StringUtils.EMPTY));
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
	
	private IT0022ResponseWrapper setPernr(long pernr) {
		this.pernr = pernr;
		return this;
	}
	
	/**
	 * GET Subtype.
	 * 
	 * @return
	 */
	@JsonProperty("subtype")
	public String getSubty() {
		return subty;
	}
	
	private IT0022ResponseWrapper setSubty(String subty) {
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
	
	private IT0022ResponseWrapper setEndda(Date endda) {
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
	
	private IT0022ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET Subtype Text.
	 * 
	 * @return
	 */
	@JsonProperty("subtype_text")
	public String getSubtyText() {
		return subtyText;
	}
	
	private IT0022ResponseWrapper setSubtyText(String subtyText) {
		this.subtyText = subtyText;
		return this;
	}
	
	/**
	 * GET Education Est. Code.
	 * 
	 * @return
	 */
	@JsonProperty("education_est_code")
	public String getSlart() {
		return slart;
	}
	
	private IT0022ResponseWrapper setSlart(String slart) {
		this.slart = slart;
		return this;
	}
	
	/**
	 * GET Education Est.Text
	 * 
	 * @return
	 */
	@JsonProperty("education_est_text")
	public String getSlartText() {
		return slartText;
	}
	
	private IT0022ResponseWrapper setSlartText(String slartText) {
		this.slartText = slartText;
		return this;
	}
	
	/**
	 * GET Institute /Location.
	 * 
	 * @return
	 */
	@JsonProperty("institute")
	public String getInsti() {
		return insti;
	}
	
	private IT0022ResponseWrapper setInsti(String insti) {
		this.insti = insti;
		return this;
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
	
	private IT0022ResponseWrapper setSland(String sland) { 
		this.sland = sland;
		return this;
	}
	
	/**
	 * GET Country Name.
	 * 
	 * @return
	 */
	@JsonProperty("country_name")
	public String getSlandText() {
		return slandText;
	}
	
	private IT0022ResponseWrapper setSlandText(String slandText) {
		this.slandText = slandText;
		return this;
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
	
	private IT0022ResponseWrapper setAusbi(long ausbi) {
		this.ausbi = ausbi;
		return this;
	}
	
	/**
	 * GET Education/Training Text.
	 * 
	 * @return
	 */
	@JsonProperty("edu_or_training_text")
	public String getAusbiText() {
		return ausbiText;
	}
	
	private IT0022ResponseWrapper setAusbiText(String ausbiText) {
		this.ausbiText = ausbiText;
		return this;
	}
	
	/**
	 * GET Certificate.
	 * 
	 * @return
	 */
	@JsonProperty("certificate_code")
	public String getSlabs() {
		return slabs;
	}
	
	private IT0022ResponseWrapper setSlabs(String slabs) {
		this.slabs = slabs;
		return this;
	}
	
	/**
	 * GET Certificate Name/Description.
	 * 
	 * @return
	 */
	@JsonProperty("certificate_name")
	public String getSlabsText() {
		return slabsText;
	}
	
	private IT0022ResponseWrapper setSlabsText(String slabsText) {
		this.slabsText = slabsText;
		return this;
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
	
	private IT0022ResponseWrapper setAnzkl(double anzkl) {
		this.anzkl = anzkl;
		return this;
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
	
	private IT0022ResponseWrapper setAnzeh(String anzeh) {
		this.anzeh = anzeh;
		return this;
	}
	
	/**
	 * GET Unit of Time/Meas. Description Text.
	 * 
	 * @return
	 */
	@JsonProperty("unit_of_time_name")
	public String getAnzehText() {
		return anzehText;
	}
	
	private IT0022ResponseWrapper setAnzehText(String anzehText) {
		this.anzehText = anzehText;
		return this;
	}
	
	/**
	 * GET Branch of Study 1 Code.
	 * 
	 * @return
	 */
	@JsonProperty("branch_study1_code")
	public String getSltp1() {
		return sltp1;
	}
	
	private IT0022ResponseWrapper setSltp1(String sltp1) {
		this.sltp1 = sltp1;
		return this;
	}
	
	/**
	 * GET Branch of Study 1 Name/Description.
	 * 
	 * @return
	 */
	@JsonProperty("branch_study1_name")
	public String getSltp1Text() {
		return sltp1Text;
	}
	
	private IT0022ResponseWrapper setSltp1Text(String sltp1Text) {
		this.sltp1Text = sltp1Text;
		return this;
	}
	
	/**
	 * GET Branch of Study 2 Code.
	 * @return
	 */
	@JsonProperty("branch_study2_code")
	public String getSltp2() {
		return sltp2;
	}
	
	private IT0022ResponseWrapper setSltp2(String sltp2) {
		this.sltp2 = sltp2;
		return this;
	}
	
	/**
	 * GET Branch of Study 2 Name/Description.
	 * 
	 * @return
	 */
	@JsonProperty("branch_study2_name")
	public String getSltp2Text() {
		return sltp2Text;
	}
	
	private IT0022ResponseWrapper setSltp2Text(String sltp2Text) {
		this.sltp2Text = sltp2Text;
		return this;
	}
}