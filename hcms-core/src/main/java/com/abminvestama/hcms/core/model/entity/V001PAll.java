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
 * Class that represents Master table for Personnel Area in SAP.
 *
 */
@Entity
@Table(name = "v_001p_all")
@IdClass(V001PAllKey.class)
public class V001PAll implements Serializable {

	private static final long serialVersionUID = 6169098070134203796L;

	@Id
	@Column(name = "werks", length = 10, nullable = false)
	private String werks;
	
	@Id
	@Column(name = "btrtl", length = 10, nullable = false)
	private String btrtl;
	
	@Column(name = "name1", length = 255)
	private String name1;
	
	@Column(name = "btext", length = 255, nullable = false)
	private String btext;
	
	/**
	 * Get Code of Personnel Area
	 * @return
	 */
	public String getWerks() {
		return werks;
	}
	
	/**
	 * Get Code of Personnel Sub-Area
	 * @return
	 */
	public String getBtrtl() {
		return btrtl;
	}
	
	/**
	 * Get Personnel Area text.
	 * @return
	 */
	public String getName1() {
		return name1;
	}
	
	/**
	 * Get Personnel Sub-Area text.
	 * @return
	 */
	public String getBtext() {
		return btext;
	}
}