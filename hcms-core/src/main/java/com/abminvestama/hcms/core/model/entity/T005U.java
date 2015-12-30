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
 * Class that represents master data for Province.
 */
@Entity
@Table(name = "t005u")
public class T005U implements Serializable {

	private static final long serialVersionUID = -1499286126589996824L;
	
	@Id
	@Column(name = "bland", length = 3, nullable = false, unique = true)
	private String bland;
	
	@Column(name = "bezei", length = 20, nullable = false)
	private String bezei;
	
	public T005U() {}
	
	/**
	 * GET Region Code.
	 * 
	 * @return
	 */
	public String getBland() {
		return bland;
	}
	
	/**
	 * GET Description.
	 * 
	 * @return
	 */
	public String getBezei() {
		return bezei;
	}
}