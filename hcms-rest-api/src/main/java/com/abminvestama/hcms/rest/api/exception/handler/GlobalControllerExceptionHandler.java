package com.abminvestama.hcms.rest.api.exception.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionViewResolver;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
	
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
	public ModelAndView usernameNotFoundExceptionHandler(HttpServletRequest req, UsernameNotFoundException e) {
		LOG.error("Username not found", e);
		ExceptionResponseWrapper response = new ExceptionResponseWrapper("Username not found: " + e.getMessage(),
				HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		return generateViewResolver(req, new ExceptionViewResolver(response));
	}
	
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ModelAndView authenticationExceptionHandler(HttpServletRequest req, AuthenticationException e) {
		LOG.error("Authentication failed", e);
		ExceptionResponseWrapper response = new ExceptionResponseWrapper("Authentication failed. Either missing or invalid token.",
				HttpStatus.UNAUTHORIZED);
		return generateViewResolver(req, new ExceptionViewResolver(response));
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		LOG.error("Internal Server Error", e);
		ExceptionResponseWrapper response = new ExceptionResponseWrapper("Internal Server Error: " + e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
		return generateViewResolver(req, new ExceptionViewResolver(response));
	}
	
	private ModelAndView generateViewResolver(HttpServletRequest req, ExceptionViewResolver exceptionViewResolver) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("url", req.getRequestURL());
		mv.addObject("status", exceptionViewResolver.getExceptionResponse().getHttpStatus().value());
		mv.addObject("message", exceptionViewResolver.getExceptionResponse().getMessage());
		mv.addObject("error", exceptionViewResolver.getExceptionResponse().getHttpStatus().name());
		mv.addObject("timestamp", new Date());
		mv.setView(exceptionViewResolver);
		return mv;
	}
}