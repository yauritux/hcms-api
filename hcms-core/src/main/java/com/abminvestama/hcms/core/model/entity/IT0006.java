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
 * Class that represents address.
 */
@Entity
@Table(name = "it0006")
public class IT0006 extends SAPAbstractEntity<ITCompositeKeys> {

	private static final long serialVersionUID = -589157851250104698L;

	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "infty", referencedColumnName = "infty", insertable = false, updatable = false),
		@JoinColumn(name = "subty", referencedColumnName = "subty", insertable = false, updatable = false)
	})
	private T591S subty;
	
	public IT0006() {}
	
	public IT0006(ITCompositeKeys id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr")
	private Long seqnr;
	
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
	 * GET Infotype Record No.
	 * 
	 * @return
	 */
	public Long getSeqnr() {
		return seqnr;
	}
	
	/**
	 * GET Address Subtype.
	 * 
	 * @return
	 */
	public T591S getSubty() {
		return subty;
	}
	
	/**
	 * Get Address Type.
	 * 
	 * @return
	 */
	public String getAnssa() {
		return anssa;
	}
	
	public void setAnssa(String anssa) {
		this.anssa = anssa;
	}
	
	/**
	 * GET Care Of.
	 * 
	 * @return
	 */
	public String getName2() {
		return name2;
	}
	
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	/**
	 * GET Street and House No.
	 * 
	 * @return
	 */
	public String getStras() {
		return stras;
	}
	
	public void setStras(String stras) {
		this.stras = stras;
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
	 * GET District.
	 * 
	 * @return
	 */
	public String getOrt02() {
		return ort02;
	}
	
	public void setOrt02(String ort02) {
		this.ort02 = ort02;
	}
	
	/**
	 * GET Postal Code.
	 * 
	 * @return
	 */
	public String getPstlz() {
		return pstlz;
	}
	
	public void setPstlz(String pstlz) {
		this.pstlz = pstlz;
	}
	
	/**
	 * GET Country Key.
	 * 
	 * @return
	 */
	public T005T getT005t() {
		return t005t;
	}
	
	public void setT005t(T005T t005t) {
		this.t005t = t005t;
	}
	
	/**
	 * GET Telephone Number.
	 * 
	 * @return
	 */
	public String getTelnr() {
		return telnr;
	}
	
	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}
	
	/**
	 * GET Distaince in Km.
	 * 
	 * @return
	 */
	public Double getEntkm() {
		return entkm;
	}
	
	public void setEntkm(Double entkm) {
		this.entkm = entkm;
	}
	
	/**
	 * GET 2nd Address Line.
	 * 
	 * @return
	 */
	public String getLocat() {
		return locat;
	}
	
	public void setLocat(String locat) {
		this.locat = locat;
	}
	
	/**
	 * GET Region.
	 * 
	 * @return
	 */
	public T005U getT005u() {
		return t005u;
	}
	
	public void setT005u(T005U t005u) {
		this.t005u = t005u;
	}
	
	/**
	 * GET Distaince in Km.
	 * 
	 * @return
	 */
	public Double getEntk2() {
		return entk2;
	}
	
	public void setEntk2(Double entk2) {
		this.entk2 = entk2;
	}
	
	/**
	 * GET Communication Type.
	 * 
	 * @return
	 */
	public String getCom01() {
		return com01;
	}
	
	public void setCom01(String com01) {
		this.com01 = com01;
	}
	
	/**
	 * GET Number.
	 * 
	 * @return
	 */
	public String getNum01() {
		return num01;
	}
	
	public void setNum01(String num01) {
		this.num01 = num01;
	}
}