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
 * Class that represents master data for <strong>Absence Quota Types</strong>.
 *
 */
@Entity
@Table(name = "t556b")
public class T556B implements Serializable {

	private static final long serialVersionUID = 4632068094883230420L;
	
	@Id
	@Column(name = "ktart", nullable = false, unique = true)
	private Integer ktart;
	
	@Column(name = "ktext", nullable = false, length = 50)
	private String ktext;
	
	/**
	 * GET Absence Quota Type.
	 * 
	 * @return
	 */
	public Integer getKtart() {
		return ktart;
	}
	
	/**
	 * GET Quota Text.
	 * 
	 * @return
	 */
	public String getKtext() {
		return ktext;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T556B obj = (T556B) o;
		
		if (obj.getKtart() != null ? obj.getKtart().intValue() != (ktart != null ? ktart.intValue() : 0) : ktart != null) {
			return false;
		}
		
		if (obj.getKtext() != null ? !obj.getKtext().equalsIgnoreCase(ktext) : ktext != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.ktart != null ? this.ktart.hashCode() : 0;
		result = result * 31 + (this.ktext != null ? ktext.hashCode() : 0);
		return result;
	}
}