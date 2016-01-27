package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0023;
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
public class IT0023ResponseWrapper extends ResourceSupport {

	private long pernr;
	private Date endda;
	private Date begda;
	
	private String arbgb;
	private String ort01;
	private String land1;
	private String land1Text;
	private String branc;
	private String brancText;
	private long taete;
	private String taeteText;
	private String ansvx;
	
	private IT0023ResponseWrapper() {}
	
	public IT0023ResponseWrapper(IT0023 it0023) {
		if (it0023 == null) {
			new IT0023ResponseWrapper();
		} else {
			this
				.setPernr(it0023.getId().getPernr())
				.setEndda(it0023.getId().getEndda()).setBegda(it0023.getId().getBegda())
				.setArbgb(StringUtils.defaultString(it0023.getArbgb(), StringUtils.EMPTY))
				.setOrt01(StringUtils.defaultString(it0023.getOrt01(), StringUtils.EMPTY))
				.setLand1(it0023.getLand1() != null ? StringUtils.defaultString(it0023.getLand1().getLand1(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setLand1Text(it0023.getLand1() != null ? StringUtils.defaultString(it0023.getLand1().getLandx(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setBranc(it0023.getBranc() != null ? StringUtils.defaultString(it0023.getBranc().getBrsch(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setBrancText(it0023.getBranc() != null ? StringUtils.defaultString(it0023.getBranc().getBrtxt(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setTaete(it0023.getTaete() != null ? it0023.getTaete().getTaete() : 0L)
				.setTaeteText(it0023.getTaete() != null ? StringUtils.defaultString(it0023.getTaete().getLtext(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setAnsvx(StringUtils.defaultString(it0023.getAnsvx(), StringUtils.EMPTY));				
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
	
	private IT0023ResponseWrapper setPernr(long pernr) {
		this.pernr = pernr;
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
	
	private IT0023ResponseWrapper setEndda(Date endda) {
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
	
	private IT0023ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET Employer.
	 * 
	 * @return
	 */
	@JsonProperty("employer")
	public String getArbgb() {
		return arbgb;
	}

	private IT0023ResponseWrapper setArbgb(String arbgb) {
		this.arbgb = arbgb;
		return this;
	}
	
	/**
	 * GET City.
	 * 
	 * @return
	 */
	@JsonProperty("city")
	public String getOrt01() {
		return ort01;
	}
	
	private IT0023ResponseWrapper setOrt01(String ort01) {
		this.ort01 = ort01;
		return this;
	}
	
	/**
	 * GET Country Key.
	 * 
	 * @return
	 */
	@JsonProperty("country_key")
	public String getLand1() {
		return land1;
	}
	
	private IT0023ResponseWrapper setLand1(String land1) {
		this.land1 = land1;
		return this;
	}
	
	/**
	 * GET Country Name.
	 * 
	 * @return
	 */
	@JsonProperty("country_name")
	public String getLand1Text() {
		return land1Text;
	}
	
	private IT0023ResponseWrapper setLand1Text(String land1Text) {
		this.land1Text = land1Text;
		return this;
	}
	
	/**
	 * GET Industry Code.
	 * 
	 * @return
	 */
	@JsonProperty("industry_code")
	public String getBranc() {
		return branc;
	}
	
	private IT0023ResponseWrapper setBranc(String branc) {
		this.branc = branc;
		return this;
	}
	
	/**
	 * GET Industry Name.
	 * 
	 * @return
	 */
	@JsonProperty("industry_name")
	public String getBrancText() {
		return brancText;
	}
	
	private IT0023ResponseWrapper setBrancText(String brancText) {
		this.brancText = brancText;
		return this;
	}
	
	/**
	 * GET Job Code.
	 * 
	 * @return
	 */
	@JsonProperty("job_code")
	public long getTaete() {
		return taete;
	}
	
	private IT0023ResponseWrapper setTaete(long taete) {
		this.taete = taete;
		return this;
	}
	
	/**
	 * GET Job Name.
	 * 
	 * @return
	 */
	@JsonProperty("taete_name")
	public String getTaeteText() {
		return taeteText;
	}
	
	private IT0023ResponseWrapper setTaeteText(String taeteText) {
		this.taeteText = taeteText;
		return this;
	}
	
	/**
	 * GET Work Contract.
	 * 
	 * @return
	 */
	@JsonProperty("work_contract")
	public String getAnsvx() {
		return ansvx;
	}
	
	private IT0023ResponseWrapper setAnsvx(String ansvx) {
		this.ansvx = ansvx;
		return this;
	}
}