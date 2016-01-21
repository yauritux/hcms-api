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
 * Class that represents master data for <strong>Education/Training</strong> (i.e. T518B in SAP)
 */
@Entity
@Table(name = "t518b")
public class T518B implements Serializable {

	private static final long serialVersionUID = 5228435810187422836L;

	@Id
	@Column(name = "ausbi", nullable = false, unique = true)
	private Long ausbi;
	
	@Column(name = "atext", nullable = false)
	private String atext;
	
	/**
	 * GET Education/Training Code.
	 * 
	 * @return
	 */
	public Long getAusbi() {
		return ausbi;
	}
	
	/**
	 * GET Education/Training Text.
	 * 
	 * @return
	 */
	public String getAtext() {
		return atext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T518B obj = (T518B) o;
		
		if (obj.getAusbi() != null ? obj.getAusbi().longValue() != (ausbi != null ? ausbi.longValue() : 0) : ausbi != null) {
			return false;
		}
		
		if (obj.getAtext() != null ? !obj.getAtext().equalsIgnoreCase(atext) : atext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.ausbi != null ? this.ausbi.hashCode() : 0;
		result = result * 31 + (this.atext != null ? this.atext.hashCode() : 0);
		return result;
	}
}