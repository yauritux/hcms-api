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
 * Class that represents <strong>Company</strong> object.
 *
 */
@Entity
@Table(name = "t001")
public class T001 implements java.io.Serializable {

	private static final long serialVersionUID = -7491480581768432565L;

	@Id
	@Column(name = "bukrs", length = 10, nullable = false, unique = true, updatable = false)
	private String bukrs;
	
	@Column(name = "butxt", length = 255, nullable = false)
	private String butxt;
	
	/**
	 * Get company code/ID 
	 * @return Company Code
	 */
	public String getBukrs() {
		return bukrs;
	}
	
	/**
	 * Get company name
	 * @return company name
	 */
	public String getButxt() {
		return butxt;
	}
	
	public void setButxt(String butxt) {
		this.butxt = butxt;
	}
}