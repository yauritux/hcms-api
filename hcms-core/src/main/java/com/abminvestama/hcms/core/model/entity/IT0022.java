package com.abminvestama.hcms.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Class that represents master data for <strong>Employee Education</strong> (i.e. IT0022 in SAP).
 */
@Entity
@Table(name = "it0022")
public class IT0022 extends SAPAbstractEntity<ITCompositeKeys> {

	private static final long serialVersionUID = -2095362603847128831L;

	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "infty", referencedColumnName = "infty", insertable = false, updatable = false),
		@JoinColumn(name = "subty", referencedColumnName = "subty", insertable = false, updatable = false)
	})
	private T591S subty;
	
	public IT0022() {}
	
	public IT0022(ITCompositeKeys id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@ManyToOne
	@JoinColumn(name = "slart", referencedColumnName = "slart")
	private T517T slart;
	
	@Column(name = "insti")
	private String insti;
	
	@ManyToOne
	@JoinColumn(name = "sland", referencedColumnName = "land1")
	private T005T sland;
	
	@ManyToOne
	@JoinColumn(name = "ausbi", referencedColumnName = "ausbi")
	private T518B ausbi;
	
	@ManyToOne
	@JoinColumn(name = "slabs", referencedColumnName = "slabs")
	private T519T slabs;
	
	@Column(name = "anzkl")
	private Double anzkl;
	
	@ManyToOne
	@JoinColumn(name = "anzeh", referencedColumnName = "zeinh")
	private T538T anzeh;
	
	@ManyToOne
	@JoinColumn(name = "sltp1", referencedColumnName = "faart")
	private T517X sltp1;

	@ManyToOne
	@JoinColumn(name = "sltp2", referencedColumnName = "faart")	
	private T517X sltp2;
	
	/**
	 * GET Employee SSN.
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}
	
	public void setPernr(Long pernr) {
		this.pernr = pernr;
	}
	
	/**
	 * GET Subtype.
	 * 
	 * @return
	 */
	public T591S getSubty() {
		return subty;
	}
	
	public void setSubty(T591S subty) {
		this.subty = subty;
	}
	
	/**
	 * GET Infotype Record No.
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
	 * GET Education Est.
	 * 
	 * @return
	 */
	public T517T getSlart() {
		return slart;
	}
	
	public void setSlart(T517T slart) {
		this.slart = slart;
	}
	
	/**
	 * GET Institute / Location.
	 * 
	 * @return
	 */
	public String getInsti() {
		return insti;
	}
	
	public void setInsti(String insti) {
		this.insti = insti;
	}
	
	/**
	 * GET Country Key.
	 * 
	 * @return
	 */
	public T005T getSland() {
		return sland;
	}
	
	public void setSland(T005T sland) {
		this.sland = sland;
	}
	
	/**
	 * GET Education/Training.
	 * 
	 * @return
	 */
	public T518B getAusbi() {
		return ausbi;
	}
	
	public void setAusbi(T518B ausbi) {
		this.ausbi = ausbi;
	}
	
	/**
	 * GET Certificate.
	 * 
	 * @return
	 */
	public T519T getSlabs() {
		return slabs;
	}
	
	public void setSlabs(T519T slabs) {
		this.slabs = slabs;
	}
	
	/**
	 * GET Duration of Course.
	 * 
	 * @return
	 */
	public Double getAnzkl() {
		return anzkl;
	}
	
	public void setAnzkl(Double anzkl) {
		this.anzkl = anzkl;
	}
	
	/**
	 * GET Unit of Time/Meas.
	 * 
	 * @return
	 */
	public T538T getAnzeh() {
		return anzeh;
	}
	
	public void setAnzeh(T538T anzeh) {
		this.anzeh = anzeh;
	}
	
	/**
	 * GET Branch of Study 1.
	 * 
	 * @return
	 */
	public T517X getSltp1() {
		return sltp1;
	}
	
	public void setSltp1(T517X sltp1) {
		this.sltp1 = sltp1;
	}
	
	/**
	 * GET Branch of Study 2.
	 * 
	 * @return
	 */
	public T517X getSltp2() {
		return sltp2;
	}
	
	public void setSltp2(T517X sltp2) {
		this.sltp2 = sltp2;
	}
}