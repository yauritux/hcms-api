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
 * Class that represents master data for <strong>Education Est./Grade</strong> (i.e. T517T in SAP).
 *
 */
@Entity
@Table(name = "t517t")
public class T517T implements Serializable {

	private static final long serialVersionUID = 1784180960457087398L;

	@Id
	@Column(name = "slart", nullable = false, unique = true)
	private String slart;
	
	@Column(name = "stext", nullable = false, length = 50)
	private String stext;
	
	/**
	 * GET Education Est.
	 * 
	 * @return
	 */
	public String getSlart() {
		return slart;
	}
	
	/**
	 * GET Education Est. Text.
	 * 
	 * @return
	 */
	public String getStext() {
		return stext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T517T obj = (T517T) o;
		
		if (obj.getSlart() != null ? !obj.getSlart().equalsIgnoreCase(slart) : slart != null) {
			return false;
		}
		
		if (obj.getStext() != null ? !obj.getStext().equalsIgnoreCase(stext) : stext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.slart != null ? this.slart.hashCode() : 0;
		result = result * 31 + (this.stext != null ? this.stext.hashCode() : 0);
		return result;
	}
}