package com.abminvestama.hcms.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.service.api.business.query.IT0009QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.helper.IT0009RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/bank")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0009Controller extends AbstractResource {

	private IT0009QueryService it0009QueryService;
	private IT0009RequestBuilderUtil it0009RequestBuilderUtil;
	private UserQueryService userQueryService;
	private Validator it0009Validator;
	
	@Autowired
	void setIT0009QueryService(IT0009QueryService it0009QueryService) {
		this.it0009QueryService = it0009QueryService;
	}
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	void setIT0009RequestBuilderUtil(IT0009RequestBuilderUtil it0009RequestBuilderUtil) {
		this.it0009RequestBuilderUtil = it0009RequestBuilderUtil;
	}
	
	@Autowired
	@Qualifier("it0009Validator")
	void setIT0009Validator(Validator it0009Validator) {
		this.it0009Validator = it0009Validator;
	}
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(it0009Validator);
	}
}