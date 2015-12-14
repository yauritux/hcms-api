package com.abminvestama.hcms.rest.api.controller;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.abminvestama.hcms.core.model.entity.User;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Base class for all REST API Classes. 
 */
public abstract class AbstractResource {

	protected Optional<String> currentUser() throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		
		if (principal instanceof String && ((String) principal).equalsIgnoreCase("anonymousUser")) {
			throw new UsernameNotFoundException("No user logged in.");
		}
		
		String username = null;
		if (principal instanceof User) {
			username = ((User) principal).getUsername();
		} else if (principal instanceof org.springframework.security.core.userdetails.User) {
			username = ((org.springframework.security.core.userdetails.User) principal).getUsername();
		} else {
			throw new UsernameNotFoundException("No user logged in.");
		}
		
		return Optional.ofNullable(username);
	}
}