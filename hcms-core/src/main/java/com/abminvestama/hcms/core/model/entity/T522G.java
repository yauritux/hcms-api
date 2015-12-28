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
 * Class that represents master data for Gender (T522G in SAP).
 *
 */
@Entity
@Table(name = "t522g")
public class T522G implements Serializable {

	private static final long serialVersionUID = 4427132800445742190L;

	@Id
	@Column(name = "anred", nullable = false, length = 1)
	private String anred;
	
	@Column(name = "gesch", nullable = false, length = 1)
	private String gesch;
	
	@Column(name = "atext", nullable = false, length = 5)
	private String atext;
	
	@Column(name = "anrlt", nullable = false, length = 15)
	private String anrlt;
	
	public T522G() {}
	
	/**
	 * GET Form of address key
	 * 
	 * @return
	 */
	public String getAnred() {
		return anred;
	}
	
	/**
	 * GET Gender
	 * 
	 * @return
	 */
	public String getGesch() {
		return gesch;
	}
	
	/**
	 * GET Form of Address
	 * 
	 * @return
	 */
	public String getAtext() {
		return atext;
	}
	
	/**
	 * GET Long Text Description
	 * 
	 * @return
	 */
	public String getAnrlt() {
		return anrlt;
	}
}