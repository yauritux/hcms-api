package com.abminvestama.hcms.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * Class that represents master data transaction for <strong>Employment History</strong>.
 *
 */
@Entity
@Table(name = "it0023")
public class IT0023 extends SAPAbstractEntity<ITCompositeKeysNoSubtype> {

	private static final long serialVersionUID = 7939907011267678419L;
	
	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	public IT0023() {}
	
	public IT0023(ITCompositeKeysNoSubtype id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@Column(name = "arbgb")
	private String arbgb;
	
	@Column(name = "ort01", length = 100)
	private String ort01;
	
	@ManyToOne
	@JoinColumn(name = "land1", referencedColumnName = "land1")
	private T005T land1;
	
	@ManyToOne
	@JoinColumn(name = "branc", referencedColumnName = "brsch")
	private T016T branc;
	
	@ManyToOne
	@JoinColumn(name = "taete", referencedColumnName = "taete")
	private T513C taete;
	
	@Column(name = "ansvx", length = 20)
	private String ansvx;
	
	/**
	 * GET Employee SSN.
	 * 
	 * @return
	 */
	public Long getSeqnr() {
		return seqnr;
	}
	
	public void setSeqnr(Long seqnr) {
		this.seqnr = seqnr;
	}
	
	/**
	 * GET Employer.
	 * 
	 * @return
	 */
	public String getArbgb() {
		return arbgb;
	}
	
	public void setArbgb(String arbgb) {
		this.arbgb = arbgb;
	}
	
	/**
	 * GET City.
	 * 
	 * @return
	 */
	public String getOrt01() {
		return ort01;
	}
	
	public void setOrt01(String ort01) {
		this.ort01 = ort01;
	}
	
	/**
	 * GET Country Key.
	 * 
	 * @return
	 */
	public T005T getLand1() {
		return land1;
	}
	
	public void setLand1(T005T land1) {
		this.land1 = land1;
	}
	
	/**
	 * GET Industry.
	 * 
	 * @return
	 */
	public T016T getBranc() {
		return branc;
	}
	
	public void setBranc(T016T branc) {
		this.branc = branc;
	}
	
	/**
	 * GET Job.
	 * 
	 * @return
	 */
	public T513C getTaete() {
		return taete;
	}
	
	public void setTaete(T513C taete) {
		this.taete = taete;
	}
	
	/**
	 * GET Work Contract.
	 * 
	 * @return
	 */
	public String getAnsvx() {
		return ansvx;
	}
	
	public void setAnsvx(String ansvx) {
		this.ansvx = ansvx;
	}
}