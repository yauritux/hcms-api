package com.abminvestama.hcms.rest.api.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Entry point that will catch all unauthorized access.
 * 
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Returns proper response for unauthorized access.
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param authException AuthenticationException
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {		
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);		
		response.getWriter().println("{\"error\": \"Unauthorized: Authentication token was either missing or invalid.\"}");
	}
}