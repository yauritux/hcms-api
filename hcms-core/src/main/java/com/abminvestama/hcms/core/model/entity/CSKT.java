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
 * This class represents <strong>Cost Center</strong>.
 *
 */
@Entity
@Table(name = "cskt")
@IdClass(CSKTKey.class)
public class CSKT implements Serializable {

	private static final long serialVersionUID = 666082749895062689L;

	@Id
	@Column(name = "kokrs", length = 10, nullable = false)
	private String kokrs;
	
	@Id
	@Column(name = "kostl", length = 10, nullable = false)
	private String kostl;
	
	@Column(name = "ktext", length = 150, nullable = false)
	private String ktext;
	
	@Column(name = "kltxt", length = 255)
	private String kltxt;
	
	@Column(name = "mcds3", length = 255, nullable = false)
	private String mcds3;
	
	/**
	 * Get Controlling Area Code
	 * @return the code of controlling area
	 */
	public String getKokrs() {
		return kokrs;
	}
	
	/**
	 * Get Cost Center Code
	 * @return code of cost center
	 */
	public String getKostl() {
		return kostl;
	}
	
	/**
	 * Get name of cost center
	 * @return name of cost center
	 */
	public String getKtext() {
		return ktext;
	}
	
	/**
	 * Get cost center description
	 * @return text description of cost center
	 */
	public String getKltxt() {
		return kltxt;
	}
	
	/**
	 * Get Cost Center short text
	 * @return 
	 */
	public String getMcds3() {
		return mcds3;
	}
}