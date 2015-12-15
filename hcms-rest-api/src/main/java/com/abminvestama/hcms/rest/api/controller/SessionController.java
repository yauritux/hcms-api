package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.SecurityConfig;
import com.abminvestama.hcms.common.util.AuthTokenUtils;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.UserCommandService;
import com.abminvestama.hcms.rest.api.dto.request.SessionRequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.SessionResponseWrapper;

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
	
	@RequestMapping(method = RequestMethod.POST, value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<SessionResponseWrapper> login(@RequestBody SessionRequestWrapper sessionRequest) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				sessionRequest.getUsername(), sessionRequest.getPassword());
		
		Authentication authentication = securityConfig.authenticationManagerBean().authenticate(authenticationToken);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Constructing and save token
		Object principal = authentication.getPrincipal();
		String username = null;
		
		if (principal instanceof User) {
			username = ((User) principal).getUsername();
		} else if (principal instanceof org.springframework.security.core.userdetails.User) {
			username = ((org.springframework.security.core.userdetails.User) principal).getUsername();
		} else {
			counterService.increment("counter.login.failure");
			throw new UsernameNotFoundException("Login failed. Either missing token or invalid token is provided.");
		}
		
		Optional<User> user = securityConfig.getUserQueryService().findByUsername(Optional.ofNullable(username));
		user.ifPresent((u) -> {
			u.setAuthToken(AuthTokenUtils.createToken(u));
			u.setAuthTokenValidThru(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 3)));
		});
		
		userCommandService.save(user.get(), user.get());

		counterService.increment("counter.login.success");
		
		SessionResponseWrapper sessionResponse = new SessionResponseWrapper();
		sessionResponse.setUsername(sessionRequest.getUsername());
		sessionResponse.setAuthToken(user.get().getAuthToken());
		
		Link self = linkTo(methodOn(SessionController.class).login(sessionRequest)).withSelfRel();
		//Link detail = linkTo(UserController.class).slash(sessionRequest.getUsername()).withRel(UserResponseWrapper.RESOURCE);
		//sessionResponse.add(detail);
		
		APIResponseWrapper<SessionResponseWrapper> response = new APIResponseWrapper<>(sessionResponse);
		response.add(self);
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<SessionResponseWrapper> logout(
			@RequestParam(required = false, defaultValue = "", value = "username") String userName,
			@RequestParam(required = false, defaultValue = "", value = "auth_token") String authToken) throws Exception {
		
		//Destroy token
		if (!currentUser().isPresent()) {
			return new APIResponseWrapper<>("No user logged in.");
		}
		
		String username = currentUser().get();
		
		Optional<User> user = securityConfig.getUserQueryService().findByUsername(currentUser());
		user.ifPresent(u -> {
			u.setAuthToken(null);
			u.setAuthTokenValidThru(null);
		});
		
		userCommandService.save(user.get(), user.get());
		
		//removes authentication
		SecurityContextHolder.getContext().setAuthentication(null);
		
		//Constructing and return response
		SessionResponseWrapper sessionResponse = new SessionResponseWrapper();
		sessionResponse.setUsername(username);
		sessionResponse.setAuthToken(null);
		Link self = linkTo(methodOn(SessionController.class).logout(username, authToken)).withSelfRel();
		//Link detail = linkTo(UserController.class).slash(username).withRel(UserResponseWrapper.RESOURCE);
		//sessionResponse.add(Arrays.asList(self, detail));
		sessionResponse.add(self);
		
		APIResponseWrapper<SessionResponseWrapper> response = new APIResponseWrapper<>(sessionResponse);
		response.setMessage("You've successfully logged out.");
		return response;
	}
}