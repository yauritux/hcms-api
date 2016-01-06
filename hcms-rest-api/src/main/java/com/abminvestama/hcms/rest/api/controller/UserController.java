package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.UserResponseWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 * 
 * User's REST API
 *
 */
@RestController
@RequestMapping("/api/v1/user")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserController extends AbstractResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private UserQueryService userQueryService;
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/profile/{username:.+}",
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<UserResponseWrapper> getUserProfileByUsername(@PathVariable String username) throws Exception {
		UserResponseWrapper userResponse = null;
		try {
			Function<User, UserResponseWrapper> userResponseWrapperFunction 
				= (User user) -> new UserResponseWrapper(user);
			
			userResponse = userResponseWrapperFunction.apply(userQueryService.findByUsername(
					Optional.ofNullable(username)).get());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw e;
		}
		
		APIResponseWrapper<UserResponseWrapper> response = new APIResponseWrapper<>(userResponse);
		response.add(linkTo(methodOn(UserController.class).getUserProfileByUsername(username)).withSelfRel());
		
		return response;
	}
}