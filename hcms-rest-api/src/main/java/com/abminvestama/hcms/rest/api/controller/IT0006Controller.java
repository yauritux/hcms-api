package com.abminvestama.hcms.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.service.api.business.query.IT0006QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/address")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0006Controller extends AbstractResource {

	private IT0006QueryService it0006QueryService;
	
	@Autowired
	public void setIT0006QueryService(IT0006QueryService it0006QueryService) {
		this.it0006QueryService = it0006QueryService;
	}
}