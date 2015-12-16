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
 * Class that represents <strong>Payroll Area</strong>
 *
 */
@Entity
@Table(name = "t549t")
public class T549T implements Serializable {

	private static final long serialVersionUID = 1687217694650531445L;

	@Id
	@Column(name = "abkrs", length = 10, nullable = false, unique = true, updatable = false)
	private String abkrs;
	
	@Column(name = "abktx", length = 255, nullable = false)
	private String abktx;
	
	/**
	 * Get Payroll Code
	 * @return Code of Payroll Area
	 */
	public String getAbkrs() {
		return abkrs;
	}
	
	/**
	 * Get Payroll Area Text
	 * @return description of payroll area
	 */
	public String getAbktx() {
		return abktx;
	}
	
	public void setAbktx(String abktx) {
		this.abktx = abktx;
	}
}