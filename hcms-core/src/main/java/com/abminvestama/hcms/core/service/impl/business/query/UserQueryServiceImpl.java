package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.UserRepository;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("userQueryService")
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {
	
	private UserRepository userRepository;
	
	@Autowired
	UserQueryServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findById(Optional<UUID> id) {
		return id.map(data -> Optional.ofNullable(userRepository.findOne(data)))
				.orElse(Optional.ofNullable(null));
	}

	@Override
	public Optional<Collection<User>> fetchAll() {
		return Optional.ofNullable(userRepository.fetchAllUsers());
	}

	@Override
	public Optional<User> findByUsername(Optional<String> username) {
		return username.map(data -> Optional.ofNullable(userRepository.findByUsername(data)))
				.orElse(Optional.ofNullable(null));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = this.findByUsername(Optional.ofNullable(username));
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("Cannot find user '" + username + "'");
		}
		
		return user.get();
	}
}