package com.abminvestama.hcms.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
 */
@Entity
@Table(name = "it0185")
public class IT0185 extends SAPAbstractEntity<ITCompositeKeys> {

	private static final long serialVersionUID = 601435978623702194L;
	
	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	@ManyToOne
	@JoinColumn(name = "subty", referencedColumnName = "subty", insertable = false, updatable = false)
	private T591S subty;
	
	public IT0185() {}
	
	public IT0185(ITCompositeKeys id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@ManyToOne
	@JoinColumn(name = "ictyp", referencedColumnName = "ictyp")
	private T5R06 ictyp;
	
	@Column(name = "icnum", length = 30)
	private String icnum;
	
	@Column(name = "auth1", length = 30)
	private String auth1;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fpdat")
	private Date fpdat;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expid")
	private Date expid;
	
	@Column(name = "isspl", length = 30)
	private String isspl;
	
	@ManyToOne
	@JoinColumn(name = "iscot", referencedColumnName = "land1")
	private T005T iscot;
	
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
	 * GET IC Type.
	 * 
	 * @return
	 */
	public T5R06 getIctyp() {
		return ictyp;
	}
	
	public void setIctyp(T5R06 ictyp) {
		this.ictyp  = ictyp;
	}
	
	/**
	 * GET Identity Number.
	 * 
	 * @return
	 */
	public String getIcnum() {
		return icnum;
	}
	
	public void setIcnum(String icnum) {
		this.icnum = icnum;
	}
	
	/**
	 * GET Issuing Authority.
	 * 
	 * @return
	 */
	public String getAuth1() {
		return auth1;
	}
	
	public void setAuth1(String auth1) {
		this.auth1 = auth1;
	}
	
	/**
	 * GET Issuing Date.
	 * 
	 * @return
	 */
	public Date getFpdat() {
		return fpdat;
	}
	
	public void setFpdat(Date fpdat) {
		this.fpdat = fpdat;
	}
	
	/**
	 * GET Expiry Date.
	 * 
	 * @return
	 */
	public Date getExpid() {
		return expid;
	}
	
	public void setExpid(Date expid) {
		this.expid = expid;
	}
	
	/**
	 * GET Place of Issue.
	 * 
	 * @return
	 */
	public String getIsspl() {
		return isspl;
	}
	
	public void setIsspl(String isspl) {
		this.isspl = isspl;
	}
	
	/**
	 * GET Country of Issue.
	 * 
	 * @return
	 */
	public T005T getIscot() {
		return iscot;
	}
	
	public void setIscot(T005T iscot) {
		this.iscot = iscot;
	}
}