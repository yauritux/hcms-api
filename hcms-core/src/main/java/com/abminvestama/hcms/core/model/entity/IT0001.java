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
}