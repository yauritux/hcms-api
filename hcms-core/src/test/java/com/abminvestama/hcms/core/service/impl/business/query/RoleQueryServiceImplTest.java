package com.abminvestama.hcms.core.service.impl.business.query;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.withSettings;
import static org.mockito.Matchers.any;
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

import com.abminvestama.hcms.core.model.entity.Role;
import com.abminvestama.hcms.core.repository.RoleRepository;
import com.abminvestama.hcms.core.service.BaseCoreServiceTester;
import com.abminvestama.hcms.core.service.api.business.query.RoleQueryService;

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
public class RoleQueryServiceImplTest extends BaseCoreServiceTester {

	//SUT
	private RoleQueryService roleQueryService;
	
	//Collaborator
	private RoleRepository mockRoleRepository;
	
	@Before
	public void setup() {
		mockRoleRepository = mock(RoleRepository.class, withSettings().name("RoleRepository").verboseLogging());
		roleQueryService = spy(new RoleQueryServiceImpl(mockRoleRepository));
	}
	
	@Test(timeout = 1000)
	public void findByName_existingName_roleObjectIsNotNull() {
		when(mockRoleRepository.findByName(any(String.class))).thenReturn(fetchRole());
		Optional<Role> role = roleQueryService.findByName(Optional.of("ROLE_EMPLOYEE"));
		assertNotNull(role.get());
	}
	
	@Test(timeout = 1000)
	public void findByName_noNameSupplied_noRoleObjectIsPresent() {
		Optional<Role> role = roleQueryService.findByName(Optional.ofNullable(null));
		assertFalse(role.isPresent());
	}
	
	@Test(timeout = 1000)
	public void findByName_nonExistingName_emptyObjectIsReturned() {
		Optional<Role> role = roleQueryService.findByName(Optional.of("ROLE_HR"));
		assertTrue(!role.isPresent());
	}
}