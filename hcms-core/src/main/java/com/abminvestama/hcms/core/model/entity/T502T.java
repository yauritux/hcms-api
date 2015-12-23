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
 * Class that represents master data for Marrital Status (T502T in SAP). 
 */
@Entity
@Table(name = "t502t")
public class T502T implements Serializable {

	private static final long serialVersionUID = 4747706564427397557L;

	@Id
	@Column(name = "famst", nullable = false, unique = true, length = 1)
	private String famst;
	
	@Column(name = "ftext", nullable = false, length = 40)
	private String ftext;
	
	/**
	 * Get Marrital Status Code
	 * 
	 * @return
	 */
	public String getFamst() {
		return famst;
	}
	
	/**
	 * Get Marrital Status Text (Description)
	 * 
	 * @return
	 */
	public String getFText() {
		return ftext;
	}
}