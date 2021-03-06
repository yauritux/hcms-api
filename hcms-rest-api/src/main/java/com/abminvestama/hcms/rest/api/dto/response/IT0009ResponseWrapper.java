package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0009;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Wrapper class for <strong>Bank Details</strong> (i.e. IT0009 in SAP)
 *
 */
@JsonInclude(Include.NON_NULL)
public class IT0009ResponseWrapper extends ResourceSupport {
	
	private long pernr;
	
	private String subty;
	
	private String subtyText;
	
	private Date endda;
	
	private Date begda;
	
	private double betrg;
	
	private String waers;
	
	private double anzhl;
	
	private String bnksa;
	
	private String zlsch;
	
	private String emftx;
	
	private String bkplz;
	
	private String bkort;
	
	private String banks;
	
	private String bankl;
	
	private String bankn;
	
	private String zweck;	
	
	private IT0009ResponseWrapper() {}
	
	public IT0009ResponseWrapper(IT0009 it0009) {
		if (it0009 == null) {
			new IT0009ResponseWrapper();
		} else {
			this
				.setPernr(it0009.getId().getPernr())
				.setSubty(it0009.getSubty() != null ? 
						StringUtils.defaultString(it0009.getSubty().getId() != null ? it0009.getSubty().getId().getSubty() : StringUtils.EMPTY) : it0009.getId().getSubty())
				.setSubtyText(it0009.getSubty() != null ? StringUtils.defaultString(it0009.getSubty().getStext(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setEndda(it0009.getId().getEndda()).setBegda(it0009.getId().getBegda())
				.setBetrg(it0009.getBetrg() != null ? it0009.getBetrg() : 0.0)
				.setWaers(it0009.getWaers()).setAnzhl(it0009.getAnzhl() != null ? it0009.getAnzhl().doubleValue() : 0.0)
				.setBnksa(it0009.getBnksa() != null ? StringUtils.defaultString(it0009.getBnksa().getStext(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setZlsch(it0009.getZlsch() != null ? it0009.getZlsch().getText1() : StringUtils.EMPTY)
				.setEmftx(StringUtils.defaultString(it0009.getEmftx(), StringUtils.EMPTY))
				.setBkplz(StringUtils.defaultString(it0009.getBkplz(), StringUtils.EMPTY))
				.setBkort(StringUtils.defaultString(it0009.getBkort(), StringUtils.EMPTY))
				.setBanks(it0009.getBanks() != null ? StringUtils.defaultString(it0009.getBanks().getLandx(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setBankl(it0009.getBankl() != null ? StringUtils.defaultString(it0009.getBankl().getBanka(), StringUtils.EMPTY) : StringUtils.EMPTY)
				.setBankn(StringUtils.defaultString(it0009.getBankn(), StringUtils.EMPTY))
				.setZweck(StringUtils.defaultString(it0009.getZweck(), StringUtils.EMPTY));
		}
	}

	/**
	 * GET Employee No./SSN
	 * 
	 * @return
	 */
	@JsonProperty("ssn")
	public long getPernr() {
		return pernr;
	}
	
	private IT0009ResponseWrapper setPernr(Long pernr) {
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
	
	private IT0009ResponseWrapper setSubty(String subty) {
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
	
	private IT0009ResponseWrapper setSubtyText(String subtyText) {
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
	
	private IT0009ResponseWrapper setEndda(Date endda) {
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
	
	private IT0009ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET Standard Value.
	 *  
	 * @return
	 */
	@JsonProperty("standard_value")
	public double getBetrg() {
		return betrg;
	}
	
	private IT0009ResponseWrapper setBetrg(double betrg) {
		this.betrg = betrg;
		return this;
	}

	/**
	 * GET Payment Currency.
	 * 
	 * @return
	 */
	@JsonProperty("payment_currency")
	public String getWaers() {
		return waers;
	}
	
	private IT0009ResponseWrapper setWaers(String waers) {
		this.waers = waers;
		return this;
	}

	/**
	 * GET Standard Percentage.
	 * 
	 * @return
	 */
	@JsonProperty("standard_percentage")
	public double getAnzhl() {
		return anzhl;
	}
	
	private IT0009ResponseWrapper setAnzhl(double anzhl) {
		this.anzhl = anzhl;
		return this;
	}

	/**
	 * GET Bank Details Type.
	 * 
	 * @return
	 */
	@JsonProperty("bank_details_type")
	public String getBnksa() {
		return bnksa;
	}
	
	private IT0009ResponseWrapper setBnksa(String bnksa) {
		this.bnksa = bnksa;
		return this;
	}

	/**
	 * GET Payment Method.
	 * 
	 * @return
	 */
	@JsonProperty("payment_method")
	public String getZlsch() {
		return zlsch;
	}
	
	private IT0009ResponseWrapper setZlsch(String zlsch) {
		this.zlsch = zlsch;
		return this;
	}

	/**
	 * GET Payee.
	 * 
	 * @return
	 */
	@JsonProperty("payee")
	public String getEmftx() {
		return emftx;
	}
	
	private IT0009ResponseWrapper setEmftx(String emftx) {
		this.emftx = emftx;
		return this;
	}

	/**
	 * GET Postal Code
	 * 
	 * @return
	 */
	@JsonProperty("postal_code")
	public String getBkplz() {
		return bkplz;
	}
	
	private IT0009ResponseWrapper setBkplz(String bkplz) {
		this.bkplz = bkplz;
		return this;
	}

	/**
	 * GET City.
	 * 
	 * @return
	 */
	@JsonProperty("city")
	public String getBkort() {
		return bkort;
	}
	
	private IT0009ResponseWrapper setBkort(String bkort) {
		this.bkort = bkort;
		return this;
	}

	/**
	 * GET Bank Country.
	 * 
	 * @return
	 */
	@JsonProperty("bank_country")
	public String getBanks() {
		return banks;
	}
	
	private IT0009ResponseWrapper setBanks(String banks) {
		this.banks = banks;
		return this;
	}

	/**
	 * GET Bank Key.
	 * 
	 * @return
	 */
	@JsonProperty("bank_key")
	public String getBankl() {
		return bankl;
	}
	
	private IT0009ResponseWrapper setBankl(String bankl) {
		this.bankl = bankl;
		return this;
	}

	/**
	 * GET Bank Account.
	 * 
	 * @return
	 */
	@JsonProperty("bank_account")
	public String getBankn() {
		return bankn;
	}
	
	private IT0009ResponseWrapper setBankn(String bankn) {
		this.bankn = bankn;
		return this;
	}

	/**
	 * GET Purpose.
	 * 
	 * @return
	 */
	@JsonProperty("purpose")
	public String getZweck() {
		return zweck;
	}	
	
	private IT0009ResponseWrapper setZweck(String zweck) {
		this.zweck = zweck;
		return this;
	}
}