package com.abminvestama.hcms.rest.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import com.abminvestama.hcms.common.util.AuthTokenUtils;
import com.abminvestama.hcms.core.model.entity.User;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Filter to verify whether supplied authentication token is valid or not.
 * 
 */
public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	/**
	 * Holds UserDetailsService that is injected from security configuration
	 */
	private final UserDetailsService userService;
	
	/**
	 * Default constructor
	 * 
	 * @param userService
	 */
	public AuthenticationTokenProcessingFilter(UserDetailsService userService) {
		this.userService = userService;
	}
	
	/**
	 * Method that will be doing actual filter processing.
	 * 
	 * @param request ServletRequest
	 * @param response ServletResponse
	 * @param chain FilterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = this.getAsHttpRequest(request);
		
		String authToken = this.extractAuthTokenFromRequest(httpRequest);
		String username = httpRequest.getParameter("username");
		
		try {
			//Halt if either username or authToken is not available (null/empty)
			if (username == null || authToken == null) {
				return;
			}
			
			//load user with supplied username
			User user = (User) this.userService.loadUserByUsername(username);
			
			//challenge supplied token with actual token in userDetails. Halt if isn't valid.
			if (!AuthTokenUtils.validateToken(authToken, user.getAuthTokenValidThru(), user.getAuthToken())) {
				return;
			}
			
			//set authentication if all is valid
			UsernamePasswordAuthenticationToken authentication 
				= new UsernamePasswordAuthenticationToken(user, null, ((UserDetails) user).getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (UsernameNotFoundException e) {
			
		} finally {
			chain.doFilter(request, response);
		}
	}
	
	/**
	 * Cast request into HttpServletRequest.
	 * 
	 * @param request ServletRequest
	 * @return HttpServletRequest
	 */
	private HttpServletRequest getAsHttpRequest(ServletRequest request) {
		if (!(request instanceof HttpServletRequest)) {
			throw new RuntimeException("Expecting an HTTP Request.");
		}
		
		return (HttpServletRequest) request;
	}
	
	/**
	 * Extract authToken from supplied request.
	 * 
	 * @param httpRequest HttpServletRequest
	 * @return String authToken extracted from httpRequest
	 */
	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		//GET token from HEADER
		String authToken = httpRequest.getHeader("X-Auth-Token");
		
		//If token can't be found than get it from the request parameter
		if (authToken == null || authToken.isEmpty()) {
			authToken = httpRequest.getParameter("auth_token");
		}
		
		return authToken;
	}
}