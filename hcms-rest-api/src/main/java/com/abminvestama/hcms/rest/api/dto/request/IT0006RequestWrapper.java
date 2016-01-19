package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0006RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = -4315934663734665154L;
	
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
	
	public IT0006RequestWrapper() {}
	
	/**
	 * Address Type.
	 * 
	 * @return
	 */
	@JsonProperty("address_type")
	public String getAnssa() {
		return anssa;
	}

	public void setAnssa(String anssa) {
		this.anssa = anssa;
	}

	/**
	 * Care of.
	 * 
	 * @return
	 */
	@JsonProperty("name2")
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * Street address.
	 * 
	 * @return
	 */
	@JsonProperty("street_address")
	public String getStras() {
		return stras;
	}

	public void setStras(String stras) {
		this.stras = stras;
	}

	/**
	 * District.
	 * 
	 * @return
	 */
	@JsonProperty("district")
	public String getOrt01() {
		return ort01;
	}

	public void setOrt01(String ort01) {
		this.ort01 = ort01;
	}

	/**
	 * City.
	 * 
	 * @return
	 */
	@JsonProperty("city")
	public String getOrt02() {
		return ort02;
	}

	public void setOrt02(String ort02) {
		this.ort02 = ort02;
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

	public void setPstlz(String pstlz) {
		this.pstlz = pstlz;
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

	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}

	/**
	 * Distance in KM.
	 * 
	 * @return
	 */
	@JsonProperty("entkm")
	public double getEntkm() {
		return entkm;
	}

	public void setEntkm(double entkm) {
		this.entkm = entkm;
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

	public void setLocat(String locat) {
		this.locat = locat;
	}

	/**
	 * Distance in KM2.
	 * 
	 * @return
	 */
	@JsonProperty("entk2")
	public double getEntk2() {
		return entk2;
	}

	public void setEntk2(double entk2) {
		this.entk2 = entk2;
	}

	/**
	 * Communication Type.
	 * 
	 * @return
	 */
	@JsonProperty("comm_type")
	public String getCom01() {
		return com01;
	}

	public void setCom01(String com01) {
		this.com01 = com01;
	}

	/**
	 * Communication Type Number/Text.
	 * 
	 * @return
	 */
	@JsonProperty("comm_type_text")
	public String getNum01() {
		return num01;
	}

	public void setNum01(String num01) {
		this.num01 = num01;
	}
}