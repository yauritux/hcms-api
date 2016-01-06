package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.model.entity.T001;
import com.abminvestama.hcms.core.service.api.business.query.T001QueryService;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * REST Resources for Company.
 *
 */
@RestController
@RequestMapping("/api/v1/company")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class T001Controller extends AbstractResource {

	private T001QueryService t001QueryService;
	
	@Autowired
	public void setT001QueryService(T001QueryService t001QueryService) {
		this.t001QueryService = t001QueryService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/pages/{pageNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<Page<T001>> fetchPage(@PathVariable int pageNumber, 
			@RequestParam(required = true, value = "username", defaultValue = "") String username,
			@RequestParam(required = true, value = "auth_token", defaultValue = "") String authToken) throws Exception {
		
		if (authToken == null || authToken.isEmpty()) {
			throw new Exception("No token provided");
		}
		
		Page<T001> resultPage = t001QueryService.fetchAllWithPaging(pageNumber);
		
		APIResponseWrapper<Page<T001>> response = new APIResponseWrapper<>();
		response.setData(resultPage);
		Link self = linkTo(methodOn(T001Controller.class).fetchPage(pageNumber, username, authToken)).withSelfRel();
		response.add(self);
		
		return response;
	}
}