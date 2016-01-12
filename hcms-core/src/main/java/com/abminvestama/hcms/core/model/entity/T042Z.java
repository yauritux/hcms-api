package com.abminvestama.hcms.core.model.entity;

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
 * Class that represents master data for <strong>payment method</strong> (i.e. T042Z in SAP).
 */
@Entity
@Table(name = "t042z")
public class T042Z implements java.io.Serializable {

	private static final long serialVersionUID = 3689663464150423946L;
	
	@Id
	@Column(name = "zlsch", nullable = false, unique = true)
	private String zlsch;
	
	@Column(name = "text1", nullable = false)
	private String text1;
	
	/**
	 * GET Payment Method Code.
	 * 
	 * @return
	 */
	public String getZlsch() {
		return zlsch;
	}
	
	/**
	 * GET payment method name.
	 * 
	 * @return
	 */
	public String getText1() {
		return text1;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T042Z obj = (T042Z) o;
		
		if (obj.getZlsch() != null ? !obj.getZlsch().equalsIgnoreCase(zlsch) : zlsch != null) {
			return false;
		}
		
		if (obj.getText1() != null ? !obj.getText1().equalsIgnoreCase(text1) : text1 != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getZlsch() != null ? this.getZlsch().hashCode() : 0;
		result = result * 31 + (this.getText1() != null ? this.getText1().hashCode() : 0);
		return result;
	}
}