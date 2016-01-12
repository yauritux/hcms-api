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
 * Class that represents master data for <strong>Country</strong>.
 *
 */
@Entity
@Table(name = "t005t")
public class T005T implements Serializable {

	private static final long serialVersionUID = 5547823293523908788L;

	@Id
	@Column(name = "land1", nullable = false, unique = true, length = 3)
	private String land1;
	
	@Column(name = "landx", nullable = false, length = 15)
	private String landx;
	
	@Column(name = "natio", nullable = false, length = 15)
	private String natio;
	
	public T005T() {}
	
	/**
	 * GET Country ID.
	 * 
	 * @return
	 */
	public String getLand1() {
		return land1;
	}
	
	/**
	 * GET Country Name.
	 * 
	 * @return
	 */
	public String getLandx() {
		return landx;
	}
	
	/**
	 * GET Nationality.
	 * 
	 * @return
	 */
	public String getNatio() {
		return natio;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T005T obj = (T005T) o;
		
		if (obj.getLand1() != null ? !obj.getLand1().equalsIgnoreCase(land1) : land1 != null) {
			return false;
		}
		
		if (obj.getLandx() != null ? !obj.getLandx().equalsIgnoreCase(landx) : landx != null) {
			return false;
		}
		
		if (obj.getNatio() != null ? !obj.getNatio().equalsIgnoreCase(natio) : natio != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getLand1() != null ? this.getLand1().hashCode() : 0;
		result = result * 31 + (this.getLandx() != null ? this.getLandx().hashCode() : 0);
		result = result * 31 + (this.getNatio() != null ? this.getNatio().hashCode() : 0);
		return result;
	}
}