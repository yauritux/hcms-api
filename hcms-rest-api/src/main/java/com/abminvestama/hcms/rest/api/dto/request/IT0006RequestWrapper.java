package com.abminvestama.hcms.rest.api.dto.request;

import org.apache.commons.lang3.StringUtils;

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0006RequestWrapper {

	private long pernr;
	private String subty;
	private String endda;
	private String begda;
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
	
	@JsonIgnore
	private IT0006RequestBuilder requestBuilder;
	
	final class IT0006RequestBuilder {
		
		private IT0006 it0006;
		private boolean isDataChanged;
		
		private IT0006RequestBuilder(IT0006 it0006Param) {
			if (it0006Param == null) {
				it0006 = new IT0006();
			} else {
				it0006 = it0006Param;
				if (StringUtils.isNotBlank(anssa) && !anssa.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getAnssa()))) {
					it0006.setAnssa(StringUtils.defaultString(anssa));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(name2) && !name2.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getName2()))) {
					it0006.setName2(StringUtils.defaultString(name2));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(stras) && !stras.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getStras()))) {
					it0006.setStras(StringUtils.defaultString(stras));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(ort01) && !ort01.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getOrt01()))) {
					it0006.setOrt01(StringUtils.defaultString(ort01));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(ort02) && !ort02.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getOrt02()))) {
					it0006.setOrt02(StringUtils.defaultString(ort02));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(pstlz) && !pstlz.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getPstlz()))) {
					it0006.setPstlz(StringUtils.defaultString(pstlz));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(telnr) && !telnr.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getTelnr()))) {
					it0006.setTelnr(StringUtils.defaultString(telnr));
					isDataChanged = true;
				}
				if (it0006Param.getEntkm() != null && it0006Param.getEntkm().doubleValue() != entkm) {
					it0006.setEntkm(Double.valueOf(entkm));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(locat) && !locat.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getLocat()))) {
					it0006.setLocat(StringUtils.defaultString(locat));
					isDataChanged = true;
				}
				if (it0006Param.getEntk2() != null && it0006Param.getEntk2().doubleValue() != entk2) {
					it0006.setEntk2(Double.valueOf(entk2));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(com01) && !com01.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getCom01()))) {
					it0006.setCom01(StringUtils.defaultString(com01));
					isDataChanged = true;
				}
				if (StringUtils.isNotBlank(num01) && !num01.trim().equalsIgnoreCase(StringUtils.defaultString(it0006Param.getNum01()))) {
					it0006.setNum01(StringUtils.defaultString(num01));
					isDataChanged = true;
				}
			}
		}
		
		IT0006 getUpdatedObject() {
			return it0006;
		}
		
		boolean isDataChanged() {
			return isDataChanged;
		}
	}
	
	public IT0006RequestWrapper() {}
	
	public IT0006 compareAndBuildFromRequest(IT0006 it0006) {
		this.requestBuilder = new IT0006RequestBuilder(it0006);
		return this.requestBuilder.getUpdatedObject();
	}
	
	public boolean isDataChanged() {
		return this.requestBuilder.isDataChanged();
	}

	/**
	 * Employee SSN (pernr).
	 * 
	 * @return
	 */
	@JsonProperty("ssn")
	public long getPernr() {
		return pernr;
	}
	
	public void setPernr(long pernr) {
		this.pernr = pernr;
	}
	
	/**
	 * Address Subtype.
	 * 
	 * @return
	 */
	@JsonProperty("address_subtype")
	public String getSubty() {
		return subty;
	}
	
	public void setSubty(String subty) {
		this.subty = subty;
	}
	
	/**
	 * End Date.
	 * 
	 * @return
	 * @throws Exception
	 */
	@JsonProperty("end_date")
	public String getEndda() throws Exception {
		return endda;
	}
	
	public void setEndda(String endda) {
		this.endda = endda;
	}
	
	/**
	 * Begin Date.
	 * 
	 * @return
	 * @throws Exception
	 */
	@JsonProperty("begin_date")
	public String getBegda() throws Exception {
		return begda;
	}
	
	public void setBegda(String begda) {
		this.begda = begda;
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