package com.abminvestama.hcms.rest.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IT0002RequestWrapper extends ITRequestWrapper {

	private static final long serialVersionUID = -2317050437190237970L;
	
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
	private String gbdat;
	private String gblnd;
	private String gbort;
	private String sprsl;
	private String konfe;
	private String famst;
	private String famdt;
	private byte anzkd;
	
	/**
	 * GET Last Name.
	 * 
	 * @return
	 */
	@JsonProperty("last_name")
	public String getNachn() {
		return nachn;
	}
	
	/**
	 * GET First Name.
	 * 
	 * @return
	 */
	@JsonProperty("full_name")
	public String getCname() {
		return cname;
	}
	
	/**
	 * GET Title1 Name Affix Type.
	 * 
	 * @return
	 */
	@JsonProperty("title1_affix_type")
	public String getArt() {
		return art;
	}
	
	/**
	 * GET Title 1
	 * @return
	 */
	@JsonProperty("title1")
	public String getTitle() {
		return title;
	}
	
	/**
	 * GET Title2 Name Affix Type.
	 * 
	 * @return
	 */
	@JsonProperty("title2_affix_type")
	public String getArt2() {
		return art2;
	}
	
	/**
	 * GET Title 2
	 * 
	 * @return
	 */
	@JsonProperty("title2")
	public String getTitle2() {
		return title2;
	}
	
	/**
	 * GET Title3 Name Affix Type.
	 * 
	 * @return
	 */
	@JsonProperty("title3_affix_type")
	public String getArt3() {
		return art3;
	}
	
	/**
	 * GET Title 3
	 * 
	 * @return
	 */
	@JsonProperty("title3")
	public String getTitle3() {
		return title3;
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
	
	/**
	 * GET Name Format Ind.
	 * 
	 * @return
	 */
	@JsonProperty("name_format_ind")
	public String getKnznm() {
		return knznm;
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
	
	/**
	 * GET Gender.
	 * 
	 * @return
	 */
	@JsonProperty("gender")
	public String getGesch() {
		return gesch;
	}
	
	/**
	 * GET Date of Birth.
	 * 
	 * @return
	 */
	@JsonProperty("date_of_birth")
	public String getGbdat() {
		return gbdat;
	}
	
	/**
	 * GET Country of Birth.
	 * 
	 * @return
	 */
	@JsonProperty("country_of_birth")
	public String getGblnd() {
		return gblnd;
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
	
	/**
	 * GET Communication Lang.
	 * 
	 * @return
	 */
	@JsonProperty("communication_lang")
	public String getSprsl() {
		return sprsl;
	}
	
	/**
	 * GET Religion.
	 * 
	 * @return
	 */
	@JsonProperty("religion")
	public String getKonfe() {
		return konfe;
	}
	
	/**
	 * GET Marrital Status.
	 * 
	 * @return
	 */
	@JsonProperty("marrital_status")
	public String getFamst() {
		return famst;
	}
	
	/**
	 * GET Marrital Status Since (Date).
	 * 
	 * @return
	 */
	@JsonProperty("marrital_status_since_date")
	public String getFamdt() {
		return famdt;
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
}