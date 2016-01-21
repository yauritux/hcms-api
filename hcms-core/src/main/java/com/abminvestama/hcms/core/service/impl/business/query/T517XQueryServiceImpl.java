package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T517X;
import com.abminvestama.hcms.core.repository.T517XRepository;
import com.abminvestama.hcms.core.service.api.business.query.T517XQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t517xQueryService")
@Transactional(readOnly = true)
public class T517XQueryServiceImpl implements T517XQueryService {
	
	private T517XRepository t517xRepository;
	
	@Autowired
	T517XQueryServiceImpl(T517XRepository t517xRepository) {
		this.t517xRepository = t517xRepository;
	}

	@Override
	public Optional<T517X> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t517xRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T517X>> fetchAll() {
		List<T517X> listOfT517X = new ArrayList<>();
		return Optional.ofNullable(t517xRepository.findAll()).map(iter -> {
			iter.forEach(t517x -> listOfT517X.add(t517x));
			return listOfT517X;
		});
	}
}