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
 * Class that represents <strong>Personal (Employee) Information</strong>.
 *
 */
@Entity
@Table(name = "it0002")
public class IT0002 extends SAPAbstractEntity<ITCompositeKeysNoSubtype> {

	private static final long serialVersionUID = 2496232738510047249L;

	@Column(name = "pernr", nullable = false, insertable = false, updatable = false)
	private Long pernr;
	
	public IT0002() {}
	
	public IT0002(ITCompositeKeysNoSubtype id) {
		this();
		this.id = id;
	}
	
	@Column(name = "seqnr", nullable = false)
	private Long seqnr;
	
	@Column(name = "nachn", nullable = true, length = 40)
	private String nachn;
	
	@Column(name = "cname", nullable = false, length = 80)
	private String cname;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "art", referencedColumnName = "art"),
		@JoinColumn(name = "title", referencedColumnName = "title")
	})
	private T535N title;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "art2", referencedColumnName = "art"),
		@JoinColumn(name = "title2", referencedColumnName = "title")
	})
	private T535N titl2;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "art3", referencedColumnName = "art"),
		@JoinColumn(name = "title3", referencedColumnName = "title")
	})
	private T535N namzu;
	
	@Column(name = "rufnm", length = 40)
	private String rufnm;
	
	@Column(name = "knznm")
	private String knznm;
	
	@ManyToOne
	@JoinColumn(name = "anred", referencedColumnName = "anred")
	private T522G anred;
	
	@Column(name = "gesch")
	private String gesch;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "gbdat")
	private Date gbdat;
	
	@ManyToOne
	@JoinColumn(name = "gblnd", referencedColumnName = "land1")
	private T005T gblnd;
	
	@Column(name = "gbort", length = 40)
	private String gbort;
	
	@ManyToOne
	@JoinColumn(name = "sprsl", referencedColumnName = "sprsl")
	private T002T sprsl;
	
	@ManyToOne
	@JoinColumn(name = "konfe", referencedColumnName = "konfe")
	private T516T konfe;
	
	@ManyToOne
	@JoinColumn(name = "famst", referencedColumnName = "famst")	
	private T502T famst;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "famdt")
	private Date famdt;
	
	@Column(name = "anzkd")
	private Byte anzkd;
	
	/**
	 * GET Employee Personnel No. (Employee ID).
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
	 * GET Last name.
	 * 
	 * @return
	 */
	public String getNachn() {
		return nachn;
	}
	
	public void setNachn(String nachn) {
		this.nachn = nachn;
	}
	
	/**
	 * GET Full Name.
	 * 
	 * @return
	 */
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	/**
	 * GET Title.
	 * 
	 * @return
	 */
	public T535N getTitle() {
		return title;
	}
	
	public void setTitle(T535N title) {
		this.title = title;
	}
	
	/**
	 * GET Second Title.
	 * 
	 * @return
	 */
	public T535N getTitl2() {
		return titl2;
	}
	
	public void setTitl2(T535N titl2) {
		this.titl2 = titl2;
	}
	
	/**
	 * GET Other Title.
	 * 
	 * @return
	 */
	public T535N getNamzu() {
		return namzu;
	}
	
	public void setNamzu(T535N namzu) {
		this.namzu = namzu;
	}
	
	/**
	 * GET Nick name.
	 * 
	 * @return
	 */
	public String getRufnm() {
		return rufnm;
	}
	
	public void setRufnm(String rufnm) {
		this.rufnm = rufnm;
	}
	
	/**
	 * GET Name format Ind.
	 * 
	 * @return
	 */
	public String getKnznm() {
		return knznm;
	}
	
	public void setKnznm(String knznm) {
		this.knznm = knznm;
	}
	
	/**
	 * GET Form-of-address key.
	 * 
	 * @return
	 */
	public T522G getAnred() {
		return anred;
	}
	
	public void setAnred(T522G anred) {
		this.anred = anred;
	}
	
	/**
	 * GET Gender.
	 * 
	 * @return
	 */
	public String getGesch() {
		return gesch;
	}
	
	public void setGesch(String gesch) {
		this.gesch = gesch;
	}
	
	/**
	 * GET Date of birth.
	 * 
	 * @return
	 */
	public Date getGbdat() {
		return gbdat;
	}
	
	public void setGbdat(Date gbdat) {
		this.gbdat = gbdat;
	}
	
	/**
	 * GET Country of Birth.
	 * 
	 * @return
	 */
	public T005T getGblnd() {
		return gblnd;
	}
	
	public void setGblnd(T005T gblnd) {
		this.gblnd = gblnd;
	}
	
	/**
	 * GET Birthplace.
	 * 
	 * @return
	 */
	public String getGbort() {
		return gbort;
	}
	
	public void setGbort(String gbort) {
		this.gbort = gbort;
	}
	
	/**
	 * GET Communication Lang.
	 * 
	 * @return
	 */
	public T002T getSprsl() {
		return sprsl;
	}
	
	public void setSprsl(T002T sprsl) {
		this.sprsl = sprsl;
	}
	
	/**
	 * GET Religion.
	 * 
	 * @return
	 */
	public T516T getKonfe() {
		return konfe;
	}
	
	public void setKonfe(T516T konfe) {
		this.konfe = konfe;
	}
	
	/**
	 * GET Marrital Status.
	 * 
	 * @return
	 */
	public T502T getFamst() {
		return famst;
	}
	
	public void setFamst(T502T famst) {
		this.famst = famst;
	}
	
	/**
	 * GET Marrital Status Since.
	 * 
	 * @return
	 */
	public Date getFamdt() {
		return famdt;
	}
	
	public void setFamdt(Date famdt) {
		this.famdt = famdt;
	}
	
	/**
	 * GET Number of Children.
	 * 
	 * @return
	 */
	public Byte getAnzkd() {
		return anzkd;
	}
	
	public void setAnzkd(Byte anzkd) {
		this.anzkd = anzkd;
	}
}