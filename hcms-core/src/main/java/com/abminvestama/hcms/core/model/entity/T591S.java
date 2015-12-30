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
 * Class that represents master data for Address Type.
 * 
 */
@Entity
@Table(name = "t591s")
public class T591S implements Serializable {

	private static final long serialVersionUID = 4399458964581160475L;
	
	@Id
	@Column(name = "subty", length = 4, nullable = false, unique = true)
	private String subty;
	
	@Column(name = "stext", length = 40, nullable = false)
	private String stext;
	
	/**
	 * GET Subtype.
	 * 
	 * @return
	 */
	public String getSubty() {
		return subty;
	}
	
	/**
	 * GET Name.
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
		
		final T591S obj = (T591S) o;
		
		if (obj.getSubty() != null ? !obj.getSubty().equals(this.getSubty()) : this.getSubty() != null) {
			return false;
		}
		
		if (obj.getStext() != null ? !obj.getStext().equals(this.getStext()) : this.getStext() != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getSubty() != null ? this.getSubty().hashCode() : 0;
		result = result * 31 + (this.getStext() != null ? this.getStext().hashCode() : 0);
		return result;
	}
}