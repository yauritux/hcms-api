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
 * Class that represents master data transaction for <strong>Absence Quotas</strong>.
 *
 */
@Entity
@Table(name = "it2006")
public class IT2006 extends SAPAbstractEntity<ITCompositeKeys> {

	private static final long serialVersionUID = 3453508796911221509L;
	
	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "infty", referencedColumnName = "infty", insertable = false, updatable = false),
		@JoinColumn(name = "subty", referencedColumnName = "subty", insertable = false, updatable = false)
	})
	private T591S subty;
	
	public IT2006() {}
	
	public IT2006(ITCompositeKeys id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@ManyToOne
	@JoinColumn(name = "ktart", referencedColumnName = "ktart")
	private T556B ktart;
	
	@Column(name = "anzhl")
	private Double anzhl;
	
	@Column(name = "kverb")
	private Double kverb;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "desta")
	private Date desta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "deend")
	private Date deend;
	
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
	 * GET Absence Quota Types.
	 *  
	 * @return
	 */
	public T556B getKtart() {
		return ktart;
	}
	
	public void setKtart(T556B ktart) {
		this.ktart = ktart;
	}
	
	/**
	 * GET Quota Number.
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
	 * GET Quota Deduction.
	 * 
	 * @return
	 */
	public Double getKverb() {
		return kverb;
	}
	
	public void setKverb(Double kverb) {
		this.kverb = kverb;
	}
	
	/**
	 * GET Deduction from.
	 * 
	 * @return
	 */
	public Date getDesta() {
		return desta;
	}
	
	public void setDesta(Date desta) {
		this.desta = desta;
	}
	
	/**
	 * GET Deduction To.
	 * 
	 * @return
	 */
	public Date getDeend() {
		return deend;
	}
	
	public void setDeend(Date deend) {
		this.deend = deend;
	}
}