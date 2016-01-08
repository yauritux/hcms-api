package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

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
	
	public IT0006ResponseWrapper() {
	}
	
	@JsonProperty("pernr")
	public long getPernr() {
		return pernr;
	}
	
	public IT0006ResponseWrapper setPernr(long pernr) {
		this.pernr = pernr;
		return this;
	}
	
	@JsonProperty("changed_on")
	public Date getAedtm() {
		return aedtm;
	}
	
	public IT0006ResponseWrapper setAedtm(Date aedtm) {
		this.aedtm = aedtm;
		return this;
	}
	
	@JsonProperty("changed_by")
	public String getUname() {
		return uname;
	}
	
	public IT0006ResponseWrapper setUname(String uname) {
		this.uname = uname;
		return this;
	}
	
	@JsonProperty("address_type")
	public String getAnssa() {
		return anssa;
	}
	
	public IT0006ResponseWrapper setAnssa(String anssa) {
		this.anssa = anssa;
		return this;
	}
	
	@JsonProperty("care_of")
	public String getName2() {
		return name2;
	}
	
	public IT0006ResponseWrapper setName2(String name2) {
		this.name2 = name2;
		return this;
	}
	
	@JsonProperty("street_house_no")
	public String getStras() {
		return stras;
	}
	
	public IT0006ResponseWrapper setStras(String stras) {
		this.stras = stras;
		return this;
	}
	
	@JsonProperty("city")
	public String getOrt01() {
		return ort01;
	}
	
	public IT0006ResponseWrapper setOrt01(String ort01) {
		this.ort01 = ort01;
		return this;
	}
	
	@JsonProperty("district")
	public String getOrt02() {
		return ort02;
	}
	
	public IT0006ResponseWrapper setOrt02(String ort02) {
		this.ort02 = ort02;
		return this;
	}
	
	@JsonProperty("postal_code")
	public String getPstlz() {
		return pstlz;
	}
	
	public IT0006ResponseWrapper setPstlz(String pstlz) {
		this.pstlz = pstlz;
		return this;
	}
	
	@JsonProperty("phone_no")
	public String getTelnr() {
		return telnr;
	}
	
	public IT0006ResponseWrapper setTelnr(String telnr) {
		this.telnr = telnr;
		return this;
	}
	
	@JsonProperty("distance_km")
	public double getEntkm() {
		return entkm;
	}
	
	public IT0006ResponseWrapper setEntkm(double entkm) {
		this.entkm = entkm;
		return this;
	}
	
	@JsonProperty("second_address")
	public String getLocat() {
		return locat;
	}
	
	public IT0006ResponseWrapper setLocat(String locat) {
		this.locat = locat;
		return this;
	}
	
	@JsonProperty("distance_km2")
	public double getEntk2() {
		return entk2;
	}
	
	public IT0006ResponseWrapper setEntk2(double entk2) {
		this.entk2 = entk2;
		return this;
	}
	
	@JsonProperty("communication_type")
	public String getCom01() {
		return com01;
	}
	
	public IT0006ResponseWrapper setCom01(String com01) {
		this.com01 = com01;
		return this;
	}
	
	@JsonProperty("number")
	public String getNum01() {
		return num01;
	}
	
	public IT0006ResponseWrapper setNum01(String num01) {
		this.num01 = num01;
		return this;
	}
}