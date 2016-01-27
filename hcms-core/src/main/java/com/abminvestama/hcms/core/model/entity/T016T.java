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
 * Class that represents master data for <strong>Job Industry</strong>.
 */
@Entity
@Table(name = "t016t")
public class T016T implements Serializable {

	private static final long serialVersionUID = -2661569233028461060L;
	
	@Id
	@Column(name = "brsch", nullable = false, length = 10)
	private String brsch;
	
	@Column(name = "brtxt", nullable = false, length = 255)
	private String brtxt;
	
	public String getBrsch() {
		return brsch;
	}
	
	public String getBrtxt() {
		return brtxt;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		
		final T016T obj = (T016T) o;
		
		if (obj.getBrsch() != null ? !obj.getBrsch().equalsIgnoreCase(brsch) : brsch != null) {
			return false;
		}
		
		if (obj.getBrtxt() != null ? !obj.getBrtxt().equalsIgnoreCase(brtxt) : brtxt != null) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = this.getBrsch() != null ? this.getBrsch().hashCode() : 0;
		result = result * 31 + (this.getBrtxt() != null ? this.getBrtxt().hashCode() : 0);
		return result;
	}
}