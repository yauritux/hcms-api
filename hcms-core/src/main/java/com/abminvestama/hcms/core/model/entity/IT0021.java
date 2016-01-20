package com.abminvestama.hcms.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Class that represents master data for <strong>Emergency Info</strong> (i.t. IT0021 in SAP).
 */
@Entity
@Table(name = "it0021")
public class IT0021 extends SAPAbstractEntity<ITCompositeKeys> {

	private static final long serialVersionUID = 8047464623923365661L;
	
	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	@ManyToOne
	@JoinColumn(name = "subty", referencedColumnName = "subty", insertable = false, updatable = false)
	private T591S subty;
	
	public IT0021() {}
	
	public IT0021(ITCompositeKeys id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@ManyToOne
	@JoinColumn(name = "famsa", referencedColumnName = "subty")
	private T591S famsa;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fgbdt")
	private Date fgbdt;
	
	@ManyToOne
	@JoinColumn(name = "fgbld", referencedColumnName = "land1")
	private T005T fgbld;
	
	@ManyToOne
	@JoinColumn(name = "fanat", referencedColumnName = "land1")
	private T005T fanat;
	
	@Column(name = "fasex")
	private Character fasex;
	
	@Column(name = "favor")
	private String favor;
	
	@Column(name = "fanam")
	private String fanam;
	
	@Column(name = "fgbot")
	private String fgbot;
	
	@Column(name = "fcnam")
	private String fcnam;
	
	@Column(name = "fknzn")
	private Integer fknzn;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "fnmzu", referencedColumnName = "art"),
		@JoinColumn(name = "title", referencedColumnName = "title")
	})
	private T535N t535n;
	
	/**
	 * GET Employee SSN.
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
	 * GET Family Member.
	 * 
	 * @return
	 */
	public T591S getFamsa() {
		return famsa;
	}
	
	public void setFamsa(T591S famsa) {
		this.famsa = famsa;
	}
	
	/**
	 * GET Date of Birth.
	 * 
	 * @return
	 */
	public Date getFgbdt() {
		return fgbdt;
	}
	
	public void setFgbdt(Date fgbdt) {
		this.fgbdt = fgbdt;
	}
	
	/**
	 * GET Country of Birth.
	 * 
	 * @return
	 */
	public T005T getFgbld() {
		return fgbld;
	}
	
	public void setFgbld(T005T fgbld) {
		this.fgbld = fgbld;
	}
	
	/**
	 * GET Nationality.
	 * 
	 * @return
	 */
	public T005T getFanat() {
		return fanat;
	}
	
	public void setFanat(T005T fanat) {
		this.fanat = fanat;
	}
	
	/**
	 * GET Gender (Sex).
	 * 
	 * @return
	 */
	public Character getFasex() {
		return fasex;
	}
	
	public void setFasex(Character fasex) {
		this.fasex = fasex;
	}
	
	/**
	 * GET First Name.
	 * 
	 * @return
	 */
	public String getFavor() {
		return favor;
	}
	
	public void setFavor(String favor) {
		this.favor = favor;
	}
	
	/**
	 * GET Last Name.
	 * 
	 * @return
	 */
	public String getFanam() {
		return fanam;
	}
	
	public void setFanam(String fanam) {
		this.fanam = fanam;
	}
	
	/**
	 * GET Birth place.
	 * 
	 * @return
	 */
	public String getFgbot() {
		return fgbot;
	}
	
	public void setFgbot(String fgbot) {
		this.fgbot = fgbot;
	}
	
	/**
	 * GET Full name.
	 * 
	 * @return
	 */
	public String getFcnam() {
		return fcnam;
	}
	
	public void setFcnam(String fcnam) {
		this.fcnam = fcnam;
	}
	
	/**
	 * GET Name Format Ind.
	 * 
	 * @return
	 */
	public Integer getFknzn() {
		return fknzn;
	}
	
	public void setFknzn(Integer fknzn) {
		this.fknzn = fknzn;
	}
	
	/**
	 * GET Title.
	 * 
	 * @return
	 */
	public T535N getT535n() {
		return t535n;
	}
	
	public void setT535n(T535N t535n) {
		this.t535n = t535n;
	}
}