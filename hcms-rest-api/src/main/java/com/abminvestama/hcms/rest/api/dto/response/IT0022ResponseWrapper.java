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
				.setSlart(it0022.getSlart() != null ? StringUtils.defaultString(it0022.getSlart().getSlart(), StringUtils.EMPTY) : StringUtils.EMPTY);
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
	public String getSlart() {
		return slart;
	}
	
	private IT0022ResponseWrapper setSlart(String slart) {
		this.slart = slart;
		return this;
	}
}