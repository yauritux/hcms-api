package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
 * Class that represents address.
 */
@Entity
@Table(name = "it0006")
@IdClass(IT0006Key.class)
public class IT0006 implements Serializable {

	private static final long serialVersionUID = -589157851250104698L;

	@Id
	@Column(name = "pernr", nullable = false)
	private Long pernr;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "subty", referencedColumnName = "subty")
	private T591S subty;
	
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
	@Column(name = "aedtm")
	private Date aedtm;
	
	@Column(name = "uname")
	private String uname;
	
	@Column(name = "anssa", length = 4)
	private String anssa;
	
	@Column(name = "name2", length = 40)
	private String name2;
	
	@Column(name = "stras", length = 60)
	private String stras;
	
	@Column(name = "ort01", length = 40)
	private String ort01;
	
	@Column(name = "ort02", length = 40)
	private String ort02;
	
	@Column(name = "pstlz", length = 10)
	private String pstlz;
	
	@ManyToOne
	@JoinColumn(name = "land1", referencedColumnName = "land1")
	private T005T t005t;
	
	@Column(name = "telnr", length = 14)
	private String telnr;
	
	@Column(name = "entkm", precision = 5, scale = 2)
	private Double entkm;
	
	@Column(name = "locat", length = 40)
	private String locat;
	
	@ManyToOne
	@JoinColumn(name = "state", referencedColumnName = "bland")
	private T005U t005u;
	
	@Column(name = "entk2", precision = 5, scale = 2)
	private Double entk2;
	
	@Column(name = "com01", length = 4)
	private String com01;
	
	@Column(name = "num01", length = 20)
	private String num01;
	
	/**
	 * GET Personnel number.
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}
	
	/**
	 * GET Address Type.
	 * 
	 * @return
	 */
	public T591S getSubty() {
		return subty;
	}
	
	/**
	 * GET End Date.
	 * 
	 * @return
	 */
	public Date getEndda() {
		return endda;
	}
	
	/**
	 * GET Begin Date.
	 * 
	 * @return
	 */
	public Date getBegda() {
		return begda;
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
	 * GET Changed On.
	 * 
	 * @return
	 */
	public Date getAedtm() {
		return aedtm;
	}
	
	/**
	 * GET Changed By.
	 * 
	 * @return
	 */
	public String getUname() {
		return uname;
	}
	
	/**
	 * Get Address Type.
	 * 
	 * @return
	 */
	public String getAnssa() {
		return anssa;
	}
	
	/**
	 * GET Care Of.
	 * 
	 * @return
	 */
	public String getName2() {
		return name2;
	}
	
	/**
	 * GET Street and House No.
	 * 
	 * @return
	 */
	public String getStras() {
		return stras;
	}
	
	/**
	 * GET City.
	 * 
	 * @return
	 */
	public String getOrt01() {
		return ort01;
	}
	
	/**
	 * GET District.
	 * 
	 * @return
	 */
	public String getOrt02() {
		return ort02;
	}
	
	/**
	 * GET Postal Code.
	 * 
	 * @return
	 */
	public String getPstlz() {
		return pstlz;
	}
	
	/**
	 * GET Country Key.
	 * 
	 * @return
	 */
	public T005T getT005t() {
		return t005t;
	}
	
	/**
	 * GET Telephone Number.
	 * 
	 * @return
	 */
	public String getTelnr() {
		return telnr;
	}
	
	/**
	 * GET Distaince in Km.
	 * 
	 * @return
	 */
	public Double getEntkm() {
		return entkm;
	}
	
	/**
	 * GET 2nd Address Line.
	 * 
	 * @return
	 */
	public String getLocat() {
		return locat;
	}
	
	/**
	 * GET Region.
	 * 
	 * @return
	 */
	public T005U getT005u() {
		return t005u;
	}
	
	/**
	 * GET Distaince in Km.
	 * 
	 * @return
	 */
	public Double getEntk2() {
		return entk2;
	}
	
	/**
	 * GET Communication Type.
	 * 
	 * @return
	 */
	public String getCom01() {
		return com01;
	}
	
	/**
	 * GET Number.
	 * 
	 * @return
	 */
	public String getNum01() {
		return num01;
	}
}