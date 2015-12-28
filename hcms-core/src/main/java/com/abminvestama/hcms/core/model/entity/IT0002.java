package com.abminvestama.hcms.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * Class that represents <strong>Personal (Employee) Information</strong>.
 *
 */
@Entity
@Table(name = "it0002")
@IdClass(IT0002Key.class)
public class IT0002 implements Serializable {

	private static final long serialVersionUID = 2496232738510047249L;

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
	
	@Column(name = "seqnr", nullable = false)
	private Long seqnr;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "aedtm", nullable = false)
	private Date aedtm;
	
	@Column(name = "uname", nullable = false, length = 15)
	private String uname;
	
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
	
	public IT0002() {}
	
	/**
	 * GET Employee Personnel No. (Employee ID).
	 * 
	 * @return
	 */
	public Long getPernr() {
		return pernr;
	}
	
	/**
	 * 
	 * GET End Date.
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
	 * GET Changed On. (i.e. Last time record was changed.)
	 * 
	 * @return
	 */
	public Date getAedtm() {
		return aedtm;
	}
	
	/**
	 * GET Changed By. (i.e. last changed by user)
	 * 
	 * @return
	 */
	public String getUname() {
		return uname;
	}
	
	/**
	 * GET Last name.
	 * 
	 * @return
	 */
	public String getNachn() {
		return nachn;
	}
	
	/**
	 * GET Full Name.
	 * 
	 * @return
	 */
	public String getCname() {
		return cname;
	}
	
	/**
	 * GET Title.
	 * 
	 * @return
	 */
	public T535N getTitle() {
		return title;
	}
	
	/**
	 * GET Second Title.
	 * 
	 * @return
	 */
	public T535N getTitl2() {
		return titl2;
	}
	
	/**
	 * GET Other Title.
	 * 
	 * @return
	 */
	public T535N getNamzu() {
		return namzu;
	}
	
	/**
	 * GET Nick name.
	 * 
	 * @return
	 */
	public String getRufnm() {
		return rufnm;
	}
	
	/**
	 * GET Name format Ind.
	 * 
	 * @return
	 */
	public String getKnznm() {
		return knznm;
	}
	
	/**
	 * GET Form-of-address key.
	 * 
	 * @return
	 */
	public T522G getAnred() {
		return anred;
	}
	
	/**
	 * GET Gender.
	 * 
	 * @return
	 */
	public String getGesch() {
		return gesch;
	}
	
	/**
	 * GET Date of birth.
	 * 
	 * @return
	 */
	public Date getGbdat() {
		return gbdat;
	}
	
	/**
	 * GET Country of Birth.
	 * 
	 * @return
	 */
	public T005T getGblnd() {
		return gblnd;
	}
	
	/**
	 * GET Birthplace.
	 * 
	 * @return
	 */
	public String getGbort() {
		return gbort;
	}
	
	/**
	 * GET Communication Lang.
	 * 
	 * @return
	 */
	public T002T getSprsl() {
		return sprsl;
	}
	
	/**
	 * GET Religion.
	 * 
	 * @return
	 */
	public T516T getKonfe() {
		return konfe;
	}
	
	/**
	 * GET Marrital Status.
	 * 
	 * @return
	 */
	public T502T getFamst() {
		return famst;
	}
	
	/**
	 * GET Marrital Status Since.
	 * 
	 * @return
	 */
	public Date getFamdt() {
		return famdt;
	}
	
	/**
	 * GET Number of Children.
	 * 
	 * @return
	 */
	public Byte getAnzkd() {
		return anzkd;
	}
}