package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.core.model.entity.IT0002;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class IT0002ResponseWrapper extends ResourceSupport {
	
	private long pernr;
	private Date endda;
	private Date begda;
	
	private String nachn;
	private String cname;
	private String art;
	private String title;
	private String art2;
	private String title2;
	private String art3;
	private String title3;
	private String rufnm;
	private String knznm;
	private String anred;
	private String gesch;
	private Date gbdat;
	private String gblnd;
	private String gblndText;
	private String gbort;
	private String sprsl;
	private String sprslText;
	private String konfe;
	private String konfeText;
	private String famst;
	private String famstText;
	private Date famdt;
	private byte anzkd;
	
	private IT0002ResponseWrapper() {}
	
	public IT0002ResponseWrapper(IT0002 it0002) {
		if (it0002 == null) {
			new IT0002ResponseWrapper();
		} else {
			this
			.setPernr(it0002.getId().getPernr())
			.setEndda(it0002.getId().getEndda()).setBegda(it0002.getId().getBegda())
			.setNachn(StringUtils.defaultString(it0002.getNachn(), StringUtils.EMPTY))
			.setCname(StringUtils.defaultString(it0002.getCname(), StringUtils.EMPTY))
			.setArt(it0002.getTitle() != null ? StringUtils.defaultString(it0002.getTitle().getId().getArt(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setTitle(it0002.getTitle() != null ? StringUtils.defaultString(it0002.getTitle().getId().getTitle(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setArt2(it0002.getTitl2() != null ? StringUtils.defaultString(it0002.getTitl2().getId().getArt(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setTitle2(it0002.getTitl2() != null ? StringUtils.defaultString(it0002.getTitl2().getId().getTitle(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setArt3(it0002.getNamzu() != null ? StringUtils.defaultString(it0002.getNamzu().getId().getArt(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setTitle3(it0002.getNamzu() != null ? StringUtils.defaultString(it0002.getNamzu().getId().getTitle(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setRufnm(StringUtils.defaultString(it0002.getRufnm(), StringUtils.EMPTY))
			.setKnznm(StringUtils.defaultString(it0002.getKnznm(), StringUtils.EMPTY))
			.setAnred(it0002.getAnred() != null ? StringUtils.defaultString(it0002.getAnred().getAnred(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setGesch(StringUtils.defaultString(it0002.getGesch(), StringUtils.EMPTY))
			.setGbdat(it0002.getGbdat())
			.setGblnd(it0002.getGblnd() != null ? StringUtils.defaultString(it0002.getGblnd().getLand1(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setGblndText(it0002.getGblnd() != null ? StringUtils.defaultString(it0002.getGblnd().getLandx(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setGbort(StringUtils.defaultString(it0002.getGbort(), StringUtils.EMPTY))
			.setSprsl(it0002.getSprsl() != null ? StringUtils.defaultString(it0002.getSprsl().getSprsl(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setSprslText(it0002.getSprsl() != null ? StringUtils.defaultString(it0002.getSprsl().getLangName(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setKonfe(it0002.getKonfe() != null ? StringUtils.defaultString(it0002.getKonfe().getKonfe(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setKonfeText(it0002.getKonfe() != null ? StringUtils.defaultString(it0002.getKonfe().getKtext(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setFamst(it0002.getFamst() != null ? StringUtils.defaultString(it0002.getFamst().getFamst(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setFamstText(it0002.getFamst() != null ? StringUtils.defaultString(it0002.getFamst().getFText(), StringUtils.EMPTY) : StringUtils.EMPTY)
			.setFamdt(it0002.getFamdt()).setAnzkd(it0002.getAnzkd() != null ? it0002.getAnzkd().byteValue() : 0);			
		}
	}
	
	/**
	 * GET Employee SSN.
	 * 
	 * @return
	 */
	@JsonProperty("ssn")
	public long getPernr() {
		return pernr;
	}
	
	private IT0002ResponseWrapper setPernr(long pernr) {
		this.pernr = pernr;
		return this;
	}
	
	/**
	 * GET End Date.
	 * 
	 * @return
	 */
	@JsonProperty("end_date")
	public Date getEndda() {
		return endda;
	}
	
	private IT0002ResponseWrapper setEndda(Date endda) {
		this.endda = endda;
		return this;
	}
	
	/**
	 * GET Begin Date.
	 * 
	 * @return
	 */
	@JsonProperty("begin_date")
	public Date getBegda() {
		return begda;
	}
	
	private IT0002ResponseWrapper setBegda(Date begda) {
		this.begda = begda;
		return this;
	}
	
	/**
	 * GET Last Name.
	 * 
	 * @return
	 */
	@JsonProperty("last_name")
	public String getNachn() {
		return nachn;
	}
	
	private IT0002ResponseWrapper setNachn(String nachn) {
		this.nachn = nachn;
		return this;
	}
	
	/**
	 * GET Full Name.
	 * 
	 * @return
	 */
	@JsonProperty("full_name")
	public String getCname() {
		return cname;
	}
	
	private IT0002ResponseWrapper setCname(String cname) {
		this.cname = cname;
		return this;
	}
	
	/**
	 * GET Title 1 Name Affix Type.
	 * 
	 * @return
	 */
	@JsonProperty("title1_affix_type")
	public String getArt() {
		return art;
	}
	
	private IT0002ResponseWrapper setArt(String art) {
		this.art = art;
		return this;
	}
	
	/**
	 * GET Title 1.
	 * 
	 * @return
	 */
	@JsonProperty("title1")
	public String getTitle() {
		return title;
	}
	
	private IT0002ResponseWrapper setTitle(String title) {
		this.title = title;
		return this;
	}
	
	/**
	 * GET Title 2 Name Affix Type.
	 * 
	 * @return
	 */
	@JsonProperty("title2_affix_type")
	public String getArt2() {
		return art2;
	}
	
	private IT0002ResponseWrapper setArt2(String art2) {
		this.art2 = art2;
		return this;
	}
	
	/**
	 * GET Title 2.
	 * 
	 * @return
	 */
	@JsonProperty("title2")
	public String getTitle2() {
		return title2;
	}
	
	private IT0002ResponseWrapper setTitle2(String title2) {
		this.title2 = title2;
		return this;
	}
	
	/**
	 * GET Title 3 Name Suffix Type.
	 * 
	 * @return
	 */
	@JsonProperty("title3_affix_type")
	public String getArt3() {
		return art3;
	}
	
	private IT0002ResponseWrapper setArt3(String art3) {
		this.art3 = art3;
		return this;
	}
	
	/**
	 * GET Title 3.
	 * 
	 * @return
	 */
	@JsonProperty("title3")
	public String getTitle3() {
		return title3;
	}
	
	private IT0002ResponseWrapper setTitle3(String title3) {
		this.title3 = title3;
		return this;
	}
	
	/**
	 * GET Nick Name.
	 * 
	 * @return
	 */
	@JsonProperty("nick_name")
	public String getRufnm() {
		return rufnm;
	}
	
	private IT0002ResponseWrapper setRufnm(String rufnm) {
		this.rufnm = rufnm;
		return this;
	}
	
	/**
	 * GET Name Format Ind.
	 * 
	 * @return
	 */
	@JsonProperty("name_format_ind")
	public String getKnznm() {
		return knznm;
	}
	
	private IT0002ResponseWrapper setKnznm(String knznm) {
		this.knznm = knznm;
		return this;
	}
	
	/**
	 * GET Form of Address Key.
	 * 
	 * @return
	 */
	@JsonProperty("form_address_key")
	public String getAnred() {
		return anred;
	}
	
	private IT0002ResponseWrapper setAnred(String anred) {
		this.anred = anred;
		return this;
	}
	
	/**
	 * GET Gender.
	 * 
	 * @return
	 */
	@JsonProperty("gender")
	public String getGesch() {
		return gesch;
	}
	
	private IT0002ResponseWrapper setGesch(String gesch) {
		this.gesch = gesch;
		return this;
	}
	
	/**
	 * GET Date of Birth.
	 * 
	 * @return
	 */
	@JsonProperty("date_of_birth")
	public Date getGbdat() {
		return gbdat;
	}
	
	private IT0002ResponseWrapper setGbdat(Date gbdat) {
		this.gbdat = gbdat;
		return this;
	}
	
	/**
	 * GET Country of Birth (Country Code).
	 * 
	 * @return
	 */
	@JsonProperty("country_of_birth")
	public String getGblnd() {
		return gblnd;
	}
	
	private IT0002ResponseWrapper setGblnd(String gblnd) {
		this.gblnd = gblnd;
		return this;
	}
	
	/**
	 * GET Country of Birth (Country Name).
	 * 
	 * @return
	 */
	@JsonProperty("country_of_birth_name")
	public String getGblndText() {
		return gblndText;
	}
	
	private IT0002ResponseWrapper setGblndText(String gblndText) {
		this.gblndText = gblndText;
		return this;
	}
	
	/**
	 * GET Birth Place.
	 * 
	 * @return
	 */
	@JsonProperty("birth_place")
	public String getGbort() {
		return gbort;
	}
	
	private IT0002ResponseWrapper setGbort(String gbort) {
		this.gbort = gbort;
		return this;
	}
	
	/**
	 * GET Communication Lang (Lang Code).
	 * 
	 * @return
	 */
	@JsonProperty("communication_lang")
	public String getSprsl() {
		return sprsl;
	}
	
	private IT0002ResponseWrapper setSprsl(String sprsl) {
		this.sprsl = sprsl;
		return this;
	}
	
	/**
	 * GET Communication Lang (Language Name).
	 * 
	 * @return
	 */
	@JsonProperty("communication_lang_name")
	public String getSprslText() {
		return sprslText;
	}
	
	private IT0002ResponseWrapper setSprslText(String sprslText) {
		this.sprslText = sprslText;
		return this;
	}
	
	/**
	 * GET Religion (Religion Code).
	 * 
	 * @return
	 */
	@JsonProperty("religion")
	public String getKonfe() {
		return konfe;
	}
	
	private IT0002ResponseWrapper setKonfe(String konfe) {
		this.konfe = konfe;
		return this;
	}
	
	/**
	 * GET Religion (Religion Name).
	 * 
	 * @return
	 */
	@JsonProperty("religion_name")
	public String getKonfeText() {
		return konfeText;
	}
	
	private IT0002ResponseWrapper setKonfeText(String konfeText) {
		this.konfeText = konfeText;
		return this;
	}
	
	/**
	 * GET Marrital Status (Code).
	 * 
	 * @return
	 */
	@JsonProperty("marrital_status")
	public String getFamst() {
		return famst;
	}
	
	private IT0002ResponseWrapper setFamst(String famst) {
		this.famst = famst;
		return this;
	}
	
	/**
	 * GET Marrital Status (Description).
	 * 
	 * @return
	 */
	@JsonProperty("marrital_status_desc")
	public String getFamstText() {
		return famstText;
	}
	
	private IT0002ResponseWrapper setFamstText(String famstText) {
		this.famstText = famstText;
		return this;
	}
	
	/**
	 * GET Marrital Status (Since Date).
	 * 
	 * @return
	 */
	@JsonProperty("marrital_status_since_date")
	public Date getFamdt() {
		return famdt;
	}
	
	private IT0002ResponseWrapper setFamdt(Date famdt) {
		this.famdt = famdt;
		return this;
	}
	
	/**
	 * GET Number of Children.
	 * 
	 * @return
	 */
	@JsonProperty("num_of_children")
	public byte getAnzkd() {
		return anzkd;
	}
	
	private IT0002ResponseWrapper setAnzkd(byte anzkd) {
		this.anzkd = anzkd;
		return this;
	}
}