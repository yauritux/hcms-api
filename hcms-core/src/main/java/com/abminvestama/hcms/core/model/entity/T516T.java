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
 * Class that represents master data for Religion (T516T in SAP).
 */
@Entity
@Table(name = "t516t")
public class T516T implements Serializable {

	private static final long serialVersionUID = 2667445736887072458L;

	@Id
	@Column(name = "konfe", nullable = false, unique = true, length = 2)
	private String konfe;
	
	@Column(name = "kitxt", nullable = false, length = 4)
	private String kitxt;
	
	@Column(name = "ktext", nullable = false, length = 25)
	private String ktext;
	
	public T516T() {}
	
	/**
	 * GET Religion Code
	 * 
	 * @return
	 */
	public String getKonfe() {
		return konfe;
	}
	
	/**
	 * GET Religion
	 * @return
	 */
	public String getKitxt() {
		return kitxt;
	}
	
	/**
	 * GET Religious denomination
	 * 
	 * @return
	 */
	public String getKtext() {
		return ktext;
	}
}