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
 * Class that represents master data for <strong>Unit of Time/Meas.</strong> (i.e. T538T in SAP).
 */
@Entity
@Table(name = "t538t")
public class T538T implements Serializable {

	private static final long serialVersionUID = 6431032233543997837L;
	
	@Id
	@Column(name = "zeinh", nullable = false, unique = true)
	private String zeinh;
	
	@Column(name = "etext", nullable = false)
	private String etext;
	
	/**
	 * GET Unit of Time/Meas.
	 * 
	 * @return
	 */
	public String getZeinh() {
		return zeinh;
	}
	
	/**
	 * GET Unit Text/Description.
	 * 
	 * @return
	 */
	public String getEtext() {
		return etext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T538T obj = (T538T) o;
		
		if (obj.getZeinh() != null ? !obj.getZeinh().equalsIgnoreCase(zeinh) : zeinh != null) {
			return false;
		}
		
		if (obj.getEtext() != null ? !obj.getEtext().equalsIgnoreCase(etext) : etext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.zeinh != null ? this.zeinh.hashCode() : 0;
		result = result * 31 + (this.etext != null ? this.etext.hashCode() : 0);
		return result;
	}
}