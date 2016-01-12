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
 * Class that represents master data for bank details (i.e. IT0009 in SAP).
 */
@Entity
@Table(name = "it0009")
public class IT0009 extends SAPAbstractEntity<IT0009Key> {

	private static final long serialVersionUID = 1872625393714924996L;

	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	@ManyToOne
	@JoinColumn(name = "subty", referencedColumnName = "subty", insertable = false, updatable = false)
	private T591S subty;
	
	public IT0009() {}
	
	public IT0009(IT0009Key id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@Column(name = "betrg")
	private Double betrg;
	
	@Column(name = "waers")
	private String waers;
	
	@Column(name = "anzhl")
	private Double anzhl;
	
	@ManyToOne
	@JoinColumn(name = "bnksa", referencedColumnName = "subty")
	private String bnksa;
	
	@ManyToOne
	@JoinColumn(name = "zlsch", referencedColumnName = "zlsch")
	private T042Z t042z;
	
	@Column(name = "emftx")
	private String emftx;
	
	@Column(name = "bkplz")
	private String bkplz;
	
	@Column(name = "bkort")
	private String bkort;
	
	@ManyToOne
	@JoinColumn(name = "banks", referencedColumnName = "land1")
	private T005T t005t;
	
	@ManyToOne
	@JoinColumn(name = "bankl", referencedColumnName = "bankl")
	private Bnka bnka;
	
	@Column(name = "bankn")
	private String bankn;
	
	@Column(name = "zweck")
	private String zweck;

	/**
	 * GET Employee SSN (pernr).
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}

	/**
	 * GET Subtype.
	 * 
	 * @return
	 */
	public T591S getSubty() {
		return subty;
	}

	/**
	 * GET Infotype Record No.
	 * 
	 * @return
	 */
	public Long getSeqnr() {
		return seqnr;
	}

	/**
	 * GET Standard Value.
	 * 
	 * @return
	 */
	public Double getBetrg() {
		return betrg;
	}

	/**
	 * GET Payment Currency.
	 * 
	 * @return
	 */
	public String getWaers() {
		return waers;
	}

	/**
	 * GET Standard Percentage.
	 * 
	 * @return
	 */
	public Double getAnzhl() {
		return anzhl;
	}

	/**
	 * GET Bank Details Type.
	 * 
	 * @return
	 */
	public String getBnksa() {
		return bnksa;
	}

	/**
	 * GET Payment Method.
	 * 
	 * @return
	 */
	public T042Z getT042z() {
		return t042z;
	}

	/**
	 * GET Payee.
	 * 
	 * @return
	 */
	public String getEmftx() {
		return emftx;
	}

	/**
	 * GET Postal Code.
	 * 
	 * @return
	 */
	public String getBkplz() {
		return bkplz;
	}

	/**
	 * GET City.
	 * 
	 * @return
	 */
	public String getBkort() {
		return bkort;
	}

	/**
	 * GET Bank Country.
	 * 
	 * @return
	 */
	public T005T getT005t() {
		return t005t;
	}

	/**
	 * GET Bank Key.
	 * 
	 * @return
	 */
	public Bnka getBnka() {
		return bnka;
	}

	/**
	 * GET Bank Account.
	 * 
	 * @return
	 */
	public String getBankn() {
		return bankn;
	}

	/**
	 * GET Purpose.
	 * 
	 * @return
	 */
	public String getZweck() {
		return zweck;
	}
}