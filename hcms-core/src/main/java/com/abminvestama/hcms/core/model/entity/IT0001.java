package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
 * Class that represents Personal Organization Assignments (i.e. IT0001 in SAP)
 *
 */
@Entity
@Table(name = "it0001")
@IdClass(IT0001Key.class)
public class IT0001 implements Serializable {

	private static final long serialVersionUID = -1658087600792527800L;

	@Id
	@Column(name = "pernr", nullable = false)
	private Long pernr;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "endda", nullable = false)
	private Date endda;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "begda", nullable = false)
	private Date begda;
	
	@Column(name = "seqnr")
	private Long seqnr;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "aedtm", nullable = false)
	private Date aedtm;
	
	@Column(name = "uname", length = 100, nullable = false)
	private String uname;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "werks", referencedColumnName = "persa"),
		@JoinColumn(name = "bukrs", referencedColumnName = "bukrs")
	})
	private T500P t500p;
	
	@ManyToOne
	@JoinColumn(name = "persg", referencedColumnName = "persg")
	private T501T t501t;
	
	@ManyToOne
	@JoinColumn(name = "persk", referencedColumnName = "mandt")
	private T503K t503k;
	
	@Column(name = "vdsk1", length = 14)
	private String vdsk1;
	
	@Column(name = "gsber", length = 10)
	private String gsber;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "werks2", referencedColumnName = "werks"),
		@JoinColumn(name = "btrtl", referencedColumnName = "btrtl")
	})
	private V001PAll v001pall;
	
	@ManyToOne
	@JoinColumn(name = "abkrs", referencedColumnName = "abkrs")
	private T549T t549t;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "kokrs", referencedColumnName = "kokrs"),
		@JoinColumn(name = "kostl", referencedColumnName = "kostl")
	})
	private CSKT cskt;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "orgeh", referencedColumnName = "orgeh"),
		@JoinColumn(name = "endda_orgunit", referencedColumnName = "endda")
	})
	private T527X t527x;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "plans", referencedColumnName = "plans"),
		@JoinColumn(name = "endda_emposition", referencedColumnName = "endda")
	})
	private T528T t528t;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "stell", referencedColumnName = "stell"),
		@JoinColumn(name = "endda_empjob", referencedColumnName = "endda")
	})
	private T513S t513s;
	
	@Column(name = "mstbr", length = 8)
	private String mstbr;
	
	@Column(name = "sacha", length = 3)
	private String sacha;
	
	@Column(name = "sachp", length = 3)
	private String sachp;
	
	@Column(name = "sachz", length = 3)
	private String sachz;
	
	@Column(name = "sname", length = 30)
	private String sname;
	
	@Column(name = "ename", length = 40)
	private String ename;
	
	@Column(name = "otype", length = 2)
	private String otype;
	
	@Column(name = "sbmod", length = 4)
	private String sbmod;
	
	public IT0001() {}
	
	/**
	 * GET Personnel number.
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}
	
	/**
	 * GET end date.
	 * 
	 * @return
	 */
	public Date getEndda() {
		return endda;
	}
	
	/**
	 * GET begin date.
	 * 
	 * @return
	 */
	public Date getBegda() {
		return begda;
	}
	
	/**
	 * GET Info type record no.
	 * 
	 * @return
	 */
	public Long getSeqnr() {
		return seqnr;
	}
	
	/**
	 * GET Changed on. (last time record was changed.)
	 *  
	 * @return
	 */
	public Date getAedtm() {
		return aedtm;
	}
	
	/**
	 * GET Changed by. (last username that changed the record.)
	 * 
	 * @return
	 */
	public String getUname() {
		return uname;
	}
	
	/**
	 * GET Personnel Area.
	 * 
	 * @return
	 */
	public T500P getT500p() {
		return t500p;
	}
	
	/**
	 * GET Employee Group.
	 * 
	 * @return
	 */
	public T501T getT501t() {
		return t501t;
	}
	
	/**
	 * GET Employee Sub Group.
	 * 
	 * @return
	 */
	public T503K getT503k() {
		return t503k;
	}
	
	/**
	 * GET Organizational Key.
	 * 
	 * @return
	 */
	public String getVdsk1() {
		return vdsk1;
	}
	
	/**
	 * GET Business Area.
	 * 
	 * @return
	 */
	public String getGsber() {
		return gsber;
	}
	
	/**
	 * GET Personnel Sub Area.
	 * 
	 * @return
	 */
	public V001PAll getV001pall() {
		return v001pall;
	}
	
	/**
	 * GET Payroll Area.
	 * 
	 * @return
	 */
	public T549T getT549t() {
		return t549t;
	}
	
	/**
	 * GET Cost Center.
	 * 
	 * @return
	 */
	public CSKT getCskt() {
		return cskt;
	}
	
	/**
	 * GET Organizational Unit.
	 * 
	 * @return
	 */
	public T527X getT527x() {
		return t527x;
	}
	
	/**
	 * GET Position.
	 * 
	 * @return
	 */
	public T528T getT528t() {
		return t528t;
	}
	
	/**
	 * GET Job Key.
	 * 
	 * @return
	 */
	public T513S getT513s() {
		return t513s;
	}
	
	/**
	 * GET Supervisor Area.
	 * 
	 * @return
	 */
	public String getMstbr() {
		return mstbr;
	}
	
	/**
	 * GET Payroll Administrator.
	 * 
	 * @return
	 */
	public String getSacha() {
		return sacha;
	}
	
	/**
	 * GET Pers.Administrator.
	 * 
	 * @return
	 */
	public String getSachp() {
		return sachp;
	}
	
	/**
	 * GET Time Administrator.
	 * 
	 * @return
	 */
	public String getSachz() {
		return sachz;
	}
	
	/**
	 * GET Last name first name.
	 * 
	 * @return
	 */
	public String getSname() {
		return sname;
	}
	
	/**
	 * GET Employee/Appl.Name.
	 * 
	 * @return
	 */
	public String getEname() {
		return ename;
	}
	
	/**
	 * GET Object Type.
	 * 
	 * @return
	 */
	public String getOtype() {
		return otype;
	}
	
	/**
	 * GET Administrator Group.
	 * 
	 * @return
	 */
	public String getSbmod() {
		return sbmod;
	}	
}