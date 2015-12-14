package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.Role;
import com.abminvestama.hcms.core.repository.RoleRepository;
import com.abminvestama.hcms.core.service.api.business.query.RoleQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("roleQueryService")
@Transactional(readOnly = true)
public class RoleQueryServiceImpl implements RoleQueryService {

	private RoleRepository roleRepository;
	
	@Autowired
	RoleQueryServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public Optional<Role> findById(Optional<UUID> id) {
		return id.map(data -> Optional.ofNullable(roleRepository.findOne(data)))
				.orElse(Optional.ofNullable(null));
	}

	@Override
	public Optional<Collection<Role>> fetchAll() {
		List<Role> roleList = new ArrayList<>();
		Optional<Iterable<Role>> roles = Optional.ofNullable(roleRepository.findAll());
		return roles.map(iter -> {
			iter.forEach(role -> roleList.add(role));
			return roleList;
		});
	}

	@Override
	public Optional<Role> findByName(Optional<String> name) {
		return name.map(role -> Optional.ofNullable(roleRepository.findByName(role)))
				.orElse(Optional.empty());
	}
}