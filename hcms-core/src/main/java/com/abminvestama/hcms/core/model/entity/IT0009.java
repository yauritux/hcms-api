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
	private T591S bnksa;
	
	@ManyToOne
	@JoinColumn(name = "zlsch", referencedColumnName = "zlsch")
	private T042Z zlsch;
	
	@Column(name = "emftx")
	private String emftx;
	
	@Column(name = "bkplz")
	private String bkplz;
	
	@Column(name = "bkort")
	private String bkort;
	
	@ManyToOne
	@JoinColumn(name = "banks", referencedColumnName = "land1")
	private T005T banks;
	
	@ManyToOne
	@JoinColumn(name = "bankl", referencedColumnName = "bankl")
	private BNKA bankl;
	
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
	
	public void setBetrg(Double betrg) {
		this.betrg = betrg;
	}

	/**
	 * GET Payment Currency.
	 * 
	 * @return
	 */
	public String getWaers() {
		return waers;
	}
	
	public void setWaers(String waers) {
		this.waers = waers;
	}

	/**
	 * GET Standard Percentage.
	 * 
	 * @return
	 */
	public Double getAnzhl() {
		return anzhl;
	}
	
	public void setAnzhl(Double anzhl) {
		this.anzhl = anzhl;
	}

	/**
	 * GET Bank Details Type.
	 * 
	 * @return
	 */
	public T591S getBnksa() {
		return bnksa;
	}
	
	public void setBnksa(T591S bnksa) {
		this.bnksa = bnksa;
	}

	/**
	 * GET Payment Method.
	 * 
	 * @return
	 */
	public T042Z getZlsch() {
		return zlsch;
	}
	
	public void setZlsch(T042Z zlsch) {
		this.zlsch = zlsch;
	}

	/**
	 * GET Payee.
	 * 
	 * @return
	 */
	public String getEmftx() {
		return emftx;
	}
	
	public void setEmftx(String emftx) {
		this.emftx = emftx;
	}

	/**
	 * GET Postal Code.
	 * 
	 * @return
	 */
	public String getBkplz() {
		return bkplz;
	}
	
	public void setBkplz(String bkplz) {
		this.bkplz = bkplz;
	}

	/**
	 * GET City.
	 * 
	 * @return
	 */
	public String getBkort() {
		return bkort;
	}
	
	public void setBkort(String bkort) {
		this.bkort = bkort;
	}

	/**
	 * GET Bank Country.
	 * 
	 * @return
	 */
	public T005T getBanks() {
		return banks;
	}
	
	public void setBanks(T005T banks) {
		this.banks = banks;
	}

	/**
	 * GET Bank Key.
	 * 
	 * @return
	 */
	public BNKA getBankl() {
		return bankl;
	}
	
	public void setBankl(BNKA bankl) {
		this.bankl = bankl;
	}

	/**
	 * GET Bank Account.
	 * 
	 * @return
	 */
	public String getBankn() {
		return bankn;
	}
	
	public void setBankn(String bankn) {
		this.bankn = bankn;
	}

	/**
	 * GET Purpose.
	 * 
	 * @return
	 */
	public String getZweck() {
		return zweck;
	}
	
	public void  setZweck(String zweck) {
		this.zweck = zweck;
	}
}