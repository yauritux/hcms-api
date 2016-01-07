package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.UserCommandService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.request.UserRequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.AuthorResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.UserResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * User's RESTful API
 *
 */
@RestController
@RequestMapping("/api/v1/user")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserController extends AbstractResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	private UserCommandService userCommandService;
	private UserQueryService userQueryService;
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	void setUserCommandService(UserCommandService userCommandService) {
		this.userCommandService = userCommandService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{username:.+}",
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
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated UserRequestWrapper userRequestWrapper,
			BindingResult result) throws Exception {
		if (result.hasErrors()) {
		      if (result.hasErrors()) {
                  return new APIResponseWrapper<>(new ArrayData<>(
                                  ExceptionResponseWrapper.getErrors(result.getFieldErrors())), "Validation error!");
          }
		}
		
		APIResponseWrapper<?> response = null;
		
		try {
			boolean isDataChanged = false;
			
			Optional<User> currentUser = userQueryService.findByUsername(currentUser());
			if (StringUtils.isNotBlank(userRequestWrapper.getEmail()) 
					&& !userRequestWrapper.getEmail().equalsIgnoreCase(currentUser.get().getEmail())) {
				currentUser.get().setEmail(userRequestWrapper.getEmail());
				isDataChanged = true;
			}
			
			if (StringUtils.isNotBlank(userRequestWrapper.getPassword())) {
				currentUser.get().setPassword(BCrypt.hashpw(userRequestWrapper.getPassword(), BCrypt.gensalt()));
				isDataChanged = true;
			}
			
			if (isDataChanged) {
				currentUser = userCommandService.save(currentUser.get(), currentUser.get());
			}
			
			UserResponseWrapper userResponse = new UserResponseWrapper(currentUser.get());
			
			userResponse.setUpdatedBy(isDataChanged ? new AuthorResponseWrapper(
					currentUser.get()) : null);
			userResponse.add(linkTo(methodOn(UserController.class)
					.getUserProfileByUsername(currentUser().get())).withRel(UserResponseWrapper.RESOURCE));
			response = new APIResponseWrapper<UserResponseWrapper>(userResponse);
			response.setMessage(isDataChanged ? "User profile has been successfully updated." : "No changes in the data.");
			response.add(linkTo(methodOn(UserController.class).edit(userRequestWrapper, result)).withSelfRel());
		} catch (Exception e) {
			throw e;
		}
		
		return response;
	}
}