package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0021;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Wrapper class for <strong>Emergency Info</strong> (i.e. IT0021 in SAP).
 */
@JsonInclude(Include.NON_NULL)
public class IT0021ResponseWrapper extends ResourceSupport {

	private long pernr;
	private String subty;
	private String subtyText;
	private Date endda;
	private Date begda;
	
	private String famsa;
	private Date fgbdt;
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
	
	private IT0021ResponseWrapper() {}
	
	public IT0021ResponseWrapper(IT0021 it0021) {
		if (it0021 == null) {
			new IT0021ResponseWrapper();
		} else {
			this
				.setPernr(it0021.getId().getPernr())
				.setSubty(it0021.getSubty() != null ? 
						StringUtils.defaultString(it0021.getSubty().getId() != null ? it0021.getSubty().getId().getSubty() :  StringUtils.EMPTY, StringUtils.EMPTY) 
						: it0021.getId().getSubty())
				.setSubtyText(it0021.getSubty() != null ? StringUtils.defaultString(it0021.getSubty().getStext(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setEndda(it0021.getId().getEndda()).setBegda(it0021.getId().getBegda())
				.setFamsa(it0021.getFamsa() != null ? StringUtils.defaultString(it0021.getFamsa().getStext(), 
						it0021.getFamsa().getId() != null ? it0021.getFamsa().getId().getSubty() : StringUtils.EMPTY) : StringUtils.EMPTY)
				.setFgbdt(it0021.getFgbdt() != null ? it0021.getFgbdt() : null)
				.setFgbld(it0021.getFgbld() != null ? StringUtils.defaultString(it0021.getFgbld().getLandx(), it0021.getFgbld().getLand1()) : StringUtils.EMPTY)
				.setFanat(it0021.getFanat() != null ? StringUtils.defaultString(it0021.getFanat().getLandx(), it0021.getFanat().getLand1()) : StringUtils.EMPTY)
				.setFasex(StringUtils.defaultString(it0021.getFasex(), StringUtils.EMPTY))
				.setFavor(StringUtils.defaultString(it0021.getFavor(), StringUtils.EMPTY))
				.setFanam(StringUtils.defaultString(it0021.getFanam(), StringUtils.EMPTY))
				.setFgbot(StringUtils.defaultString(it0021.getFgbot(), StringUtils.EMPTY))
				.setFcnam(StringUtils.defaultString(it0021.getFcnam(), StringUtils.EMPTY))
				.setFknzn(it0021.getFknzn() != null ? it0021.getFknzn().intValue() : 0)
				.setFnmzu(it0021.getT535n() != null ? StringUtils.defaultString(it0021.getT535n().getId().getArt(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setTitle(it0021.getT535n() != null ? StringUtils.defaultString(it0021.getT535n().getId().getTitle(), StringUtils.EMPTY) : StringUtils.EMPTY);
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
	
	private IT0021ResponseWrapper setPernr(long pernr) {
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
	
	private IT0021ResponseWrapper setSubty(String subty) {
		this.subty = subty;
		return this;
	}
	
	/**
	 * GET Subtype Name/Text.
	 * 
	 * @return
	 */
	@JsonProperty("subtype_text")
	public String getSubtyText() {
		return subtyText;
	}
	
	private IT0021ResponseWrapper setSubtyText(String subtyText) {
		this.subtyText = subtyText;
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
	
	private IT0021ResponseWrapper setEndda(Date endda) {
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
	
	private IT0021ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET Family Member.
	 * 
	 * @return
	 */
	@JsonProperty("family_member")
	public String getFamsa() {
		return famsa;
	}
	
	private IT0021ResponseWrapper setFamsa(String famsa) {
		this.famsa = famsa;
		return this;
	}
	
	/**
	 * GET Date of Birth.
	 * 
	 * @return
	 */
	@JsonProperty("date_of_birth")
	public Date getFgbdt() {
		return fgbdt;
	}
	
	private IT0021ResponseWrapper setFgbdt(Date fgbdt) {
		this.fgbdt = fgbdt;
		return this;
	}
	
	/**
	 * GET Country of Birth.
	 * 
	 * @return
	 */
	@JsonProperty("country_of_birth")
	public String getFgbld() {
		return fgbld;
	}
	
	private IT0021ResponseWrapper setFgbld(String fgbld) {
		this.fgbld = fgbld;
		return this;
	}
	
	/**
	 * GET Nationality.
	 * 
	 * @return
	 */
	@JsonProperty("nationality")
	public String getFanat() {
		return fanat;
	}
	
	private IT0021ResponseWrapper setFanat(String fanat) {
		this.fanat = fanat;
		return this;
	}
	
	/**
	 * GET Gender.
	 * 
	 * @return
	 */
	@JsonProperty("gender")
	public String getFasex() {
		return fasex;
	}
	
	private IT0021ResponseWrapper setFasex(String fasex) {
		this.fasex = fasex;
		return this;
	}
	
	/**
	 * GET First Name.
	 * 
	 * @return
	 */
	@JsonProperty("first_name")
	public String getFavor() {
		return favor;
	}
	
	private IT0021ResponseWrapper setFavor(String favor) {
		this.favor = favor;
		return this;
	}
	
	/**
	 * GET Last Name.
	 * 
	 * @return
	 */
	@JsonProperty("last_name")
	public String getFanam() {
		return fanam;
	}
	
	private IT0021ResponseWrapper setFanam(String fanam) {
		this.fanam = fanam;
		return this;
	}
	
	/**
	 * GET Birth Place.
	 * 
	 * @return
	 */
	@JsonProperty("birth_place")
	public String getFgbot() {
		return fgbot;
	}
	
	private IT0021ResponseWrapper setFgbot(String fgbot) {
		this.fgbot = fgbot;
		return this;
	}
	
	/**
	 * GET Full Name.
	 * 
	 * @return
	 */
	@JsonProperty("full_name")
	public String getFcnam() {
		return fcnam;
	}
	
	private IT0021ResponseWrapper setFcnam(String fcnam) {
		this.fcnam = fcnam;
		return this;
	}
	
	/**
	 * GET Ind.Name
	 * 
	 * @return
	 */
	@JsonProperty("ind_name")
	public int getFknzn() {
		return fknzn;
	}
	
	private IT0021ResponseWrapper setFknzn(int fknzn) {
		this.fknzn = fknzn;
		return this;
	}
	
	/**
	 * GET Other Title.
	 * 
	 * @return
	 */
	@JsonProperty("other_title")
	public String getFnmzu() {
		return fnmzu;
	}
	
	private IT0021ResponseWrapper setFnmzu(String fnmzu) {
		this.fnmzu = fnmzu;
		return this;
	}
	
	/**
	 * GET Title.
	 * 
	 * @return
	 */
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
	
	private IT0021ResponseWrapper setTitle(String title) {
		this.title = title;
		return this;
	}
}