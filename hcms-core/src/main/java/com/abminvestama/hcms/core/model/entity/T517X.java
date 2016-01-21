package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Class that represents master data for <strong>Branch of Study</strong> (i.e. T517X in SAP).
 *
 */
@Entity
@Table(name = "t517x")
public class T517X implements Serializable {

	private static final long serialVersionUID = -7755996140492149846L;
	
	@Id
	@Column(name = "faart", nullable = false, unique = true)
	private String faart;
	
	@Column(name = "ftext", nullable = false)
	private String ftext;
	
	/**
	 * GET Branch of Study Code.
	 * 
	 * @return
	 */
	public String getFaart() {
		return faart;
	}
	
	/**
	 * GET Branch of Study Text.
	 * 
	 * @return
	 */
	public String getFtext() {
		return ftext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T517X obj = (T517X) o;
		
		if (obj.getFaart() != null ? !obj.getFaart().equalsIgnoreCase(faart): faart != null) {
			return false;
		}
		
		if (obj.getFtext() != null ? !obj.getFtext().equalsIgnoreCase(ftext) : ftext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.faart != null ? this.faart.hashCode() : 0;
		result = result * 31 + (this.ftext != null ? this.ftext.hashCode() : 0);
		return result;
	}
}