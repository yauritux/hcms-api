package com.abminvestama.hcms;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Configuration
@ComponentScan({ "com.abminvestama.hcms.core.model.entity", "com.abminvestama.hcms.core.repository",
	"com.abminvestama.hcms.core.service.impl.business.query"
})
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
	
	private CounterService counterService;
	private UserQueryService userQueryService;
	
	@Autowired
	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}
	
	@Autowired
	public void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Optional<com.abminvestama.hcms.core.model.entity.User> user 
					= userQueryService.findByUsername(Optional.ofNullable(username));
				if (user.isPresent()) {
					
					List<String> roles = user.get().getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());
					return new org.springframework.security.core.userdetails.User(
							user.get().getUsername(), user.get().getPassword(), 
							true, true, true, true,
							AuthorityUtils.createAuthorityList(
									roles.toArray(new String[roles.size()])
							));
				}
				
				counterService.increment("counter.login.failure");
				throw new UsernameNotFoundException("Could not find user '" + username + "'");
			}
		};
	}
}