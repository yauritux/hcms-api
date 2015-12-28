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
 * Class that represents master data of <strong>title</strong>.
 */
@Entity
@Table(name = "t535n")
@IdClass(T535NKey.class)
public class T535N implements Serializable {

	private static final long serialVersionUID = -7457185428195703486L;
	
	@Id
	@Column(name = "art", nullable = false, length = 1)
	private String art;
	
	@Id
	@Column(name = "title", nullable = false, length = 15)
	private String title;
	
	@Column(name = "duevo", nullable = true, length = 1)
	private String duevo;
	
	@Column(name = "ttout", nullable = false, length = 15)
	private String ttout;

	public T535N() {}
	
	/**
	 * GET Name affix type (title's type).
	 * 
	 * @return
	 */
	public String getArt() {
		return art;
	}
	
	/**
	 * GET name affix / title.
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * GET DUEVO Compliant.
	 * 
	 * @return
	 */
	public String getDuevo() {
		return duevo;
	}
	
	/**
	 * GET output text (title's output text).
	 * 
	 * @return
	 */
	public String getTtout() {
		return ttout;
	}
}