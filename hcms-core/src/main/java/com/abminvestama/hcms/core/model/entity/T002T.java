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
 * Class that represents master data for <strong>language</strong>.
 */
@Entity
@Table(name = "t002t")
public class T002T implements Serializable {

	private static final long serialVersionUID = 1559146305848573770L;

	@Id
	@Column(name = "sprsl", unique = true, nullable = false, length = 3)
	private String sprsl;
	
	@Column(name = "langname", nullable = false)
	private String langName;
	
	public T002T() {}
	
	/**
	 * GET Language Key/Code.
	 * 
	 * @return
	 */
	public String getSprsl() {
		return sprsl;
	}
	
	/**
	 * GET Language Name/Text.
	 * 
	 * @return
	 */
	public String getLangName() {
		return langName;
	}
}