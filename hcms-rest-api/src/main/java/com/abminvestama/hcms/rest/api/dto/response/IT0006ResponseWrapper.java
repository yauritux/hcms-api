package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Wrapper class for <strong>Address</strong> (i.e. IT0006 in SAP)
 *
 */
@JsonInclude(Include.NON_NULL)
public class IT0006ResponseWrapper extends ResourceSupport {

	private long pernr;
	
	private String subty;
	
	private Date endda;
	
	private Date begda;
	
	private Date aedtm;
	
	private String uname;
	
	private String anssa;
	
	private String name2;
	
	private String stras;
	
	private String ort01;
	
	private String ort02;
	
	private String pstlz;
	
	private String telnr;
	
	private double entkm;
	
	private String locat;
	
	private double entk2;
	
	private String com01;
	
	private String num01;
	
	private IT0006ResponseWrapper() {}
	
	public IT0006ResponseWrapper(IT0006 it0006) {
		if (it0006 == null) {
			new IT0006ResponseWrapper();
		} else {
			this
				.setPernr(it0006.getId().getPernr())
				.setSubty(it0006.getSubty() != null ? it0006.getSubty().getStext() : it0006.getId().getSubty())
				.setEndda(it0006.getId().getEndda()).setBegda(it0006.getId().getBegda())
				.setAedtm(it0006.getAedtm()).setUname(it0006.getUname())
				.setAnssa(it0006.getAnssa()).setName2(it0006.getName2())
				.setStras(it0006.getStras())
				.setOrt01(it0006.getOrt01()).setOrt02(it0006.getOrt02())
				.setPstlz(it0006.getPstlz()).setTelnr(it0006.getTelnr())
				.setEntkm(it0006.getEntkm() != null ? it0006.getEntkm() : 0.0)
				.setLocat(it0006.getLocat())
				.setEntk2(it0006.getEntk2() != null ? it0006.getEntk2() : 0.0)
				.setCom01(it0006.getCom01()).setNum01(it0006.getNum01());
		}
	}
	
	/**
	 * Employee SSN (PERNR)
	 * 
	 * @return
	 */
	@JsonProperty("pernr")
	public long getPernr() {
		return pernr;
	}
	
	private IT0006ResponseWrapper setPernr(long pernr) {
		this.pernr = pernr;
		return this;
	}
	
	/**
	 * Address Subtype.
	 * 
	 * @return
	 */
	@JsonProperty("subtype")
	public String getSubty() {
		return subty;
	}
	
	private IT0006ResponseWrapper setSubty(String subty) {
		this.subty = subty;
		return this;
	}
	
	/**
	 * End Date.
	 * 
	 * @return
	 */
	@JsonProperty("end_date")
	public Date getEndda() {
		return endda;
	}
	
	private IT0006ResponseWrapper setEndda(Date endda) {
		this.endda = endda;
		return this;
	}
	
	/**
	 * Begin Date.
	 * 
	 * @return
	 */
	@JsonProperty("begin_date")
	public Date getBegda() {
		return begda;
	}
	
	private IT0006ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * Date of Record Changed.
	 * 
	 * @return
	 */
	@JsonProperty("changed_on")
	public Date getAedtm() {
		return aedtm;
	}
	
	private IT0006ResponseWrapper setAedtm(Date aedtm) {
		this.aedtm = aedtm;
		return this;
	}
	
	/**
	 * Last User that changed the Record.
	 * 
	 * @return
	 */
	@JsonProperty("changed_by")
	public String getUname() {
		return uname;
	}
	
	private IT0006ResponseWrapper setUname(String uname) {
		this.uname = uname;
		return this;
	}
	
	/**
	 * Address Type.
	 * 
	 * @return
	 */
	@JsonProperty("address_type")
	public String getAnssa() {
		return anssa;
	}
	
	private IT0006ResponseWrapper setAnssa(String anssa) {
		this.anssa = anssa;
		return this;
	}
	
	@JsonProperty("care_of")
	public String getName2() {
		return name2;
	}
	
	private IT0006ResponseWrapper setName2(String name2) {
		this.name2 = name2;
		return this;
	}
	
	/**
	 * Street and House No.
	 * 
	 * @return
	 */
	@JsonProperty("street_house_no")
	public String getStras() {
		return stras;
	}
	
	private IT0006ResponseWrapper setStras(String stras) {
		this.stras = stras;
		return this;
	}
	
	/**
	 * City.
	 * 
	 * @return
	 */
	@JsonProperty("city")
	public String getOrt01() {
		return ort01;
	}
	
	private IT0006ResponseWrapper setOrt01(String ort01) {
		this.ort01 = ort01;
		return this;
	}

	/**
	 * District.
	 * 
	 * @return
	 */
	@JsonProperty("district")
	public String getOrt02() {
		return ort02;
	}
	
	private IT0006ResponseWrapper setOrt02(String ort02) {
		this.ort02 = ort02;
		return this;
	}
	
	/**
	 * Postal Code.
	 * 
	 * @return
	 */
	@JsonProperty("postal_code")
	public String getPstlz() {
		return pstlz;
	}
	
	private IT0006ResponseWrapper setPstlz(String pstlz) {
		this.pstlz = pstlz;
		return this;
	}
	
	/**
	 * Phone No.
	 * 
	 * @return
	 */
	@JsonProperty("phone_no")
	public String getTelnr() {
		return telnr;
	}
	
	private IT0006ResponseWrapper setTelnr(String telnr) {
		this.telnr = telnr;
		return this;
	}
	
	/**
	 * Distance in KM.
	 * 
	 * @return
	 */
	@JsonProperty("distance_km")
	public double getEntkm() {
		return entkm;
	}
	
	private IT0006ResponseWrapper setEntkm(double entkm) {
		this.entkm = entkm;
		return this;
	}
	
	/**
	 * Second Address.
	 * 
	 * @return
	 */
	@JsonProperty("second_address")
	public String getLocat() {
		return locat;
	}
	
	private IT0006ResponseWrapper setLocat(String locat) {
		this.locat = locat;
		return this;
	}
	
	/**
	 * Distaince in KM2.
	 * 
	 * @return
	 */
	@JsonProperty("distance_km2")
	public double getEntk2() {
		return entk2;
	}
	
	private IT0006ResponseWrapper setEntk2(double entk2) {
		this.entk2 = entk2;
		return this;
	}
	
	/**
	 * Communication Type.
	 * 
	 * @return
	 */
	@JsonProperty("communication_type")
	public String getCom01() {
		return com01;
	}
	
	private IT0006ResponseWrapper setCom01(String com01) {
		this.com01 = com01;
		return this;
	}
	
	/**
	 * Communication Type Number/Text.
	 * 
	 * @return
	 */
	@JsonProperty("number")
	public String getNum01() {
		return num01;
	}
	
	private IT0006ResponseWrapper setNum01(String num01) {
		this.num01 = num01;
		return this;
	}
}