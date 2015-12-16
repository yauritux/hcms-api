package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T001;
import com.abminvestama.hcms.core.repository.T001Repository;
import com.abminvestama.hcms.core.service.api.business.query.T001QueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t001QueryService")
@Transactional(readOnly = true)
public class T001QueryServiceImpl implements T001QueryService {
	
	private T001Repository t001Repository;
	
	@Autowired
	T001QueryServiceImpl(T001Repository t001Repository) {
		this.t001Repository = t001Repository;
	}

	@Override
	public Optional<T001> findById(Optional<String> id) {
		return id.map(data -> Optional.ofNullable(t001Repository.findByBukrs(data))).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<T001>> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T001> findByBukrs(String bukrs) {
		// TODO Auto-generated method stub
		return null;
	}

}
