package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0185;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Wrapper class for <strong>Personal IDs</strong> (i.e. IT0185 in SAP)
 *
 */
@JsonInclude(Include.NON_NULL)
public class IT0185ResponseWrapper extends ResourceSupport {
	
	private long pernr;
	private String subty;
	private Date endda;
	private Date begda;
	
	private String ictyp;
	private String icnum;
	private String auth1;
	private Date fpdat;
	private Date expid;
	private String isspl;
	private String iscot;
	
	private IT0185ResponseWrapper() {}
	
	public IT0185ResponseWrapper(IT0185 it0185) {
		if (it0185 == null) {
			new IT0185ResponseWrapper();
		} else {
			this
				.setPernr(it0185.getId().getPernr())
				.setSubty(it0185.getSubty() != null ? StringUtils.defaultString(it0185.getSubty().getStext(), "") : it0185.getId().getSubty())
				.setEndda(it0185.getId().getEndda()).setBegda(it0185.getId().getBegda())
				.setIctyp(it0185.getIctyp() != null ? StringUtils.defaultString(it0185.getIctyp().getIctxt(), it0185.getIctyp().getIctyp()) : "")
				.setIcnum(StringUtils.defaultString(it0185.getIcnum(), ""))
				.setAuth1(StringUtils.defaultString(it0185.getAuth1(), ""))
				.setFpdat(it0185.getFpdat() != null ? it0185.getFpdat() : null)
				.setExpid(it0185.getExpid() != null ? it0185.getExpid() : null)
				.setIsspl(StringUtils.defaultString(it0185.getIsspl(), ""))
				.setIscot(it0185.getIscot() != null ? StringUtils.defaultString(it0185.getIscot().getLandx(), it0185.getIscot().getLand1()) : "");
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
	
	private IT0185ResponseWrapper setPernr(long pernr) {
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
	
	private IT0185ResponseWrapper setSubty(String subty) {
		this.subty = subty;
		return this;
	}
	
	/**
	 * GET End Date.
	 * 
	 * @return
	 */
	public Date getEndda() {
		return endda;
	}
	
	private IT0185ResponseWrapper setEndda(Date endda) {
		this.endda = endda;
		return this;
	}
	
	/**
	 * GET Begin Date.
	 * 
	 * @return
	 */
	public Date getBegda() {
		return begda;
	}
	
	private IT0185ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET IC Type.
	 * 
	 */
	@JsonProperty("ic_type")
	public String getIctyp() {
		return ictyp;
	}
	
	private IT0185ResponseWrapper setIctyp(String ictyp) {
		this.ictyp = ictyp;
		return this;
	}
	
	/**
	 * GET IC Number.
	 * 
	 * @return
	 */
	@JsonProperty("ic_number")
	public String getIcnum() {
		return icnum;
	}
	
	private IT0185ResponseWrapper setIcnum(String icnum) {
		this.icnum = icnum;
		return this;
	}
	
	/**
	 * GET Issuing Authority.
	 * 
	 * @return
	 */
	@JsonProperty("issuing_authority")
	public String getAuth1() {
		return auth1;
	}
	
	private IT0185ResponseWrapper setAuth1(String auth1) {
		this.auth1 = auth1;
		return this;
	}
	
	/**
	 * GET Issuing Date.
	 * 
	 * @return
	 */
	@JsonProperty("issuing_date")
	public Date getFpdat() {
		return fpdat;
	}
	
	private IT0185ResponseWrapper setFpdat(Date fpdat) {
		this.fpdat = fpdat;
		return this;
	}
	
	/**
	 * GET Expiry Date.
	 * 
	 * @return
	 */
	@JsonProperty("expiry_date")
	public Date getExpid() {
		return expid;
	}
	
	private IT0185ResponseWrapper setExpid(Date expid) {
		this.expid = expid;
		return this;
	}
	
	/**
	 * GET Place of Issue.
	 * 
	 * @return
	 */
	@JsonProperty("place_of_issue")
	public String getIsspl() {
		return isspl;
	}
	
	private IT0185ResponseWrapper setIsspl(String isspl) {
		this.isspl = isspl;
		return this;
	}
	
	/**
	 * GET Issuing Country.
	 * 
	 * @return
	 */
	@JsonProperty("country_of_issue")
	public String getIscot() {
		return iscot;
	}
	
	private IT0185ResponseWrapper setIscot(String iscot) {
		this.iscot = iscot;
		return this;
	}
}