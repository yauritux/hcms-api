package com.abminvestama.hcms.rest.api.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.SecurityConfig;
import com.abminvestama.hcms.core.service.api.business.command.UserCommandService;
import com.abminvestama.hcms.core.service.api.business.query.RoleQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SessionController extends AbstractResource {

	private CounterService counterService;
	
	private SecurityConfig securityConfig;
	
	private UserCommandService userCommandService;
	
	private RoleQueryService roleQueryService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}
	
	@Autowired
	public void setSecurityConfig(SecurityConfig securityConfig) {
		this.securityConfig = securityConfig;
	}
	
	@Autowired
	public void setUserCommandService(UserCommandService userCommandService) {
		this.userCommandService = userCommandService;
	}
	
	@Autowired
	public void setRoleQueryService(RoleQueryService roleQueryService) {
		this.roleQueryService = roleQueryService;
	}
	
	
}