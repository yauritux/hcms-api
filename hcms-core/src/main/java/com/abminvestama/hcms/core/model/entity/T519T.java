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
 * Class that represents master data for <strong>Certificate</strong> (i.e. T519T in SAP)
 */
@Entity
@Table(name = "t519t")
public class T519T implements Serializable {

	private static final long serialVersionUID = -2989464514565597031L;
	
	@Id
	@Column(name = "slabs", nullable = false, unique = true)
	private String slabs;
	
	@Column(name = "stext", nullable = false)
	private String stext;
	
	/**
	 * GET Certificate Code.
	 * 
	 * @return
	 */
	public String getSlabs() {
		return slabs;
	}
	
	/**
	 * GET Certificate Description/Text.
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
		
		final T519T obj = (T519T) o;
		
		if (obj.getSlabs() != null ? !obj.getSlabs().equalsIgnoreCase(slabs) : slabs != null) {
			return false;
		}
		
		if (obj.getStext() != null ? !obj.getStext().equalsIgnoreCase(stext) : stext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.slabs != null ? this.slabs.hashCode() : 0;
		result = result * 31 + (this.stext != null ? this.stext.hashCode() : 0);
		
		return result;
	}
}