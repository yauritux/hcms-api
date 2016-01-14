package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Class that represents master data for Bank information (i.e. bnka in SAP).
 */
@Entity
@Table(name = "bnka")
public class BNKA implements Serializable {

	private static final long serialVersionUID = 4957564341626864540L;
	
	@Id
	@Column(name = "bankl", unique = true, nullable = false)
	private String bankl;
	
	@Column(name = "banka", nullable = false)
	private String banka;
	
	@Column(name = "stras", nullable = true)
	private String stras;
	
	@Column(name = "ort01", nullable = true)
	private String ort01;
	
	@Column(name = "adrnr", nullable = true)
	private String adrnr;
	
	@Column(name = "brnch", nullable = true)
	private String brnch;
	
	/**
	 * GET Bank Key/ID.
	 * 
	 * @return
	 */
	public String getBankl() {
		return bankl;
	}
	
	/**
	 * GET Bank Name.
	 * 
	 * @return
	 */
	public String getBanka() {
		return banka;
	}
	
	/**
	 * GET Bank Street Address.
	 * 
	 * @return
	 */
	public String getStras() {
		return stras;
	}
	
	/**
	 * GET Bank City.
	 * 
	 * @return
	 */
	public String getOrt01() {
		return ort01;
	}
	
	/**
	 * GET Address Number.
	 * 
	 * @return
	 */
	public String getAdrnr() {
		return adrnr;
	}
	
	/**
	 * GET Branch.
	 * 
	 * @return
	 */
	public String getBrnch() {
		return brnch;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final BNKA obj = (BNKA) o;
		
		if (obj.getBankl() != null ? !obj.getBankl().equalsIgnoreCase(bankl) : bankl != null) {
			return false;
		}
		
		if (obj.getBanka() != null ? !obj.getBanka().equalsIgnoreCase(banka) : banka != null) {
			return false;
		}
		
		if (obj.getStras() != null ? !obj.getStras().equalsIgnoreCase(stras) : stras != null) {
			return false;
		}
		
		if (obj.getOrt01() != null ? !obj.getOrt01().equalsIgnoreCase(ort01) : ort01 != null) {
			return false;
		}
		
		if (obj.getAdrnr() != null ? !obj.getAdrnr().equalsIgnoreCase(adrnr) : adrnr != null) {
			return false;
		}
		
		if (obj.getBrnch() != null ? !obj.getBrnch().equalsIgnoreCase(brnch) : brnch != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getBankl() != null ? this.getBankl().hashCode() : 0;
		result = result * 31 + (this.getBanka() != null ? this.getBanka().hashCode() : 0);
		result = result * 31 + (this.getStras() != null ? this.getStras().hashCode() : 0);
		result = result * 31 + (this.getOrt01() != null ? this.getOrt01().hashCode() : 0);
		result = result * 31 + (this.getAdrnr() != null ? this.getAdrnr().hashCode() : 0);
		result = result * 31 + (this.getBrnch() != null ? this.getBrnch().hashCode() : 0);
		return result;
	}
}