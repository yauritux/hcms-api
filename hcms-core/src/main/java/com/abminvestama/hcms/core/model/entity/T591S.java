package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@IdClass(T591SKey.class)
public class T591S implements Serializable {

	private static final long serialVersionUID = 4399458964581160475L;
	
	@Id
	@Column(name = "infty", length = 4, nullable = false)
	private String infty;
	
	@Id
	@Column(name = "subty", length = 4, nullable = false)
	private String subty;
	
	@Column(name = "stext", length = 40, nullable = false)
	private String stext;
	
	/**
	 * GET Info Type.
	 * 
	 * @return
	 */
	public String getInfty() {
		return infty;
	}
	
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
}