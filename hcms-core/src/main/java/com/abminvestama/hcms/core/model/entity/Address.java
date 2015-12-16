package com.abminvestama.hcms.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "m_address")
public class Address extends AbstractEntity {

	private static final long serialVersionUID = -7271289185144640889L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate;
	
	/* should be refactored later to get the data from ref table */
	@Column(name = "address_type")
	private String addressType;
	
	@Column(name = "co_name")
	private String coName;
	
	@Column(name = "street_and_house_no")
	private String streetAndHouseNo;
	
	@Column(name = "second_address_line")
	private String secondAddressLine;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	/* should be refactored later to get the data from ref table */
	@Column(name = "state")
	private String state;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	/* should be refactored later to get the data from ref table */
	@Column(name = "country_key")
	private String countryKey; 
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	/* should be refactored later to get the data from ref table */
	@Column(name = "communication_type_1")
	private String commType1;
}