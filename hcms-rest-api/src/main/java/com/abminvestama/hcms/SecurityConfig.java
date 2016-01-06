package com.abminvestama.hcms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.filter.AuthenticationTokenProcessingFilter;
import com.abminvestama.hcms.rest.api.filter.UnauthorizedEntryPoint;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthenticationConfiguration authConfig;
	private UserQueryService userQueryService;
	
	@Autowired
	public void setAuthenticationConfiguration(AuthenticationConfiguration authConfig) {
		this.authConfig = authConfig;
	}
	
	@Autowired
	public void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	public UserQueryService getUserQueryService() {
		return userQueryService;
	}
	
	@Bean
	public UnauthorizedEntryPoint unauthorizedEntryPoint() {
		return new UnauthorizedEntryPoint();
	}
	
	@Bean
	public AuthenticationTokenProcessingFilter authenticationTokenProcessingFilter() {
		return new AuthenticationTokenProcessingFilter(userQueryService);
	}
	
	@Bean(name = "hcmsAuthenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authConfig.authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.headers().xssProtection().cacheControl()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/api/v1/session/login").permitAll()
			.antMatchers("/api/v1/**").hasAnyAuthority(
					new String[] { "ROLE_EMPLOYEE" })
			.antMatchers("/api/v1/session/logout").hasAnyAuthority(
					new String[] { "ROLE_EMPLOYEE" })
			.anyRequest().anonymous()
			.and()
			.addFilterBefore(authenticationTokenProcessingFilter(), UsernamePasswordAuthenticationFilter.class) //FORM_LOGIN_FILTER
			.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());
	}
}