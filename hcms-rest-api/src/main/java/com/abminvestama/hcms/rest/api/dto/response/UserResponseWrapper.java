package com.abminvestama.hcms.rest.api.dto.response;

import java.util.Calendar;

import org.springframework.hateoas.ResourceSupport;

import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.model.entity.Role;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.rest.api.model.constant.HCMSResourceIdentifier;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class UserResponseWrapper extends ResourceSupport {

	public static final String RESOURCE = HCMSResourceIdentifier.USER.label();
	
	private String uuid;
	private String username;
	private String emailAddress;
	private Long pernr;
	private String fullname;
	private String photoLink;
	private String employeeStartDate;
	private String employeePosition;
	private String companyName;
	private String companyLocation;
	private String workArea;
	private String workSubArea;
	private String organizationalUnit;
	private String position;
	private String job;
	private String empGroup;
	private String empSubGroup;
	private String payrollArea;
	private Role[] roles;
	
	public UserResponseWrapper(User user) {
		this.uuid = user.getId();
		this.username = user.getUsername();
		this.emailAddress = user.getEmail();
		this.pernr = user.getEmployee().getPernr();
		this.fullname = user.getEmployee().getSname();
		this.photoLink = user.getPhotoLink();
		Calendar dateOfJoined = Calendar.getInstance();
		dateOfJoined.setTime(user.getEmployee().getBegda());
		this.employeeStartDate = new StringBuilder(
				CommonDateFunction.getMonthFullName(dateOfJoined.get(Calendar.MONTH))
				).append(" ").append(dateOfJoined.get(Calendar.DAY_OF_MONTH))
				.append(", ").append(dateOfJoined.get(Calendar.YEAR)).toString();
		this.employeePosition = user.getEmployee().getT528t().getPlstx();
		this.companyName = user.getEmployee().getT500p().getBukrs().getButxt();
		this.companyLocation = user.getEmployee().getV001pall().getBtext();
		this.workArea = user.getEmployee().getT500p().getPbtxt();
		this.workSubArea = user.getEmployee().getV001pall().getBtext();
		this.organizationalUnit = user.getEmployee().getT527x().getOrgtx();
		this.position = user.getEmployee().getT528t().getPlstx();
		this.job = user.getEmployee().getT513s().getStltx();
		this.empGroup = user.getEmployee().getT501t().getPgtxt();
		this.empSubGroup = user.getEmployee().getT503k().getPersk();
		this.payrollArea = user.getEmployee().getT549t().getAbktx();
		this.roles = user.getRoles().toArray(new Role[user.getRoles().size()]);
	}
	
	@JsonProperty("system-id")
	public String getUuid() {
		return uuid;
	}
	
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}
	
	@JsonProperty("email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	
	@JsonProperty("pernr")
	public Long getPernr() {
		return pernr;
	}
	
	@JsonProperty("fullname")
	public String getFullname() {
		return fullname;
	}
	
	@JsonProperty("photo_link")
	public String getPhotoLink() {
		return photoLink;
	}
	
	@JsonProperty("employee_start_date")
	public String getEmployeeStartDate() {
		return employeeStartDate;
	}
	
	@JsonProperty("employee_position")
	public String getEmployeePosition() {
		return employeePosition;
	}
	
	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName;
	}
	
	@JsonProperty("company_location")
	public String getCompanyLocation() {
		return companyLocation;
	}
	
	@JsonProperty("work_area")
	public String getWorkArea() {
		return workArea;
	}
	
	@JsonProperty("work_sub_area")
	public String getWorkSubArea() {
		return workSubArea;
	}
	
	@JsonProperty("org_unit")
	public String getOrganizationalUnit() {
		return organizationalUnit;
	}
	
	@JsonProperty("position")
	public String getPosition() {
		return position;
	}
	
	@JsonProperty("job")
	public String getJob() {
		return job;
	}
	
	@JsonProperty("emp_group")
	public String getEmpGroup() {
		return empGroup;
	}
	
	@JsonProperty("emp_sub_group")
	public String getEmpSubGroup() {
		return empSubGroup;
	}
	
	@JsonProperty("payroll_area")
	public String getPayrollArea() {
		return payrollArea;
	}
	
	@JsonProperty("roles")
	public Role[] getRoles() {
		return roles;
	}
}