package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T517T;
import com.abminvestama.hcms.core.repository.T517TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T517TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t517tQueryService")
@Transactional(readOnly = true)
public class T517TQueryServiceImpl implements T517TQueryService {

	private T517TRepository t517tRepository;
	
	@Autowired
	T517TQueryServiceImpl(T517TRepository t517tRepository) {
		this.t517tRepository = t517tRepository;
	}
	
	@Override
	public Optional<T517T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t517tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T517T>> fetchAll() {
		List<T517T> listOfT517T = new ArrayList<>();
		Optional<Iterable<T517T>> iterableT517T = Optional.ofNullable(t517tRepository.findAll());
		return iterableT517T.map(iter -> {
			iter.forEach(t517t -> {
				listOfT517T.add(t517t);
			});
			return listOfT517T;
		});
	}
}