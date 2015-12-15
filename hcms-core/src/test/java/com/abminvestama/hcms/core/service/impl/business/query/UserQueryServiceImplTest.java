package com.abminvestama.hcms.core.service.impl.business.query;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.withSettings;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.UserRepository;
import com.abminvestama.hcms.core.service.BaseCoreServiceTester;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RunWith(PowerMockRunner.class)
@PowerMockIgnore("org.slf4j.Logger")
@SuppressStaticInitializationFor("org.slf4j.Logger")
public class UserQueryServiceImplTest extends BaseCoreServiceTester {
	
	// SUT
	private UserQueryService userQueryService;
	
	// Collaborator
	private UserRepository mockUserRepository;
	
	@Before
	public void setup() {
		mockUserRepository = mock(UserRepository.class, withSettings().name("UserRepository").verboseLogging());
		userQueryService = spy(new UserQueryServiceImpl(mockUserRepository));		
	}

	@Test(timeout = 1000)
	public void findByUsername_existingUsername_userIsReturned() {
		when(mockUserRepository.findByUsername(any(String.class))).thenReturn(fetchUser());
		Optional<User> user = userQueryService.findByUsername(Optional.of("yauritux"));
		assertNotNull(user.get());		
	}
	
	@Test(timeout = 1000, expected = UsernameNotFoundException.class)
	public void loadUserByUsername_nonExistingUser_throwUsernameNotFoundException() {
		when(mockUserRepository.findByUsername(any(String.class))).thenReturn(null);
		userQueryService.loadUserByUsername("yauritux");
	}
	
	@Test(timeout = 1000)
	public void loadUserByUsername_existingUser_userIsReturned() {
		when(mockUserRepository.findByUsername(any(String.class))).thenReturn(fetchUser());
		UserDetails currentUser = userQueryService.loadUserByUsername("yauritux");
		assertNotNull(currentUser);
	}
}