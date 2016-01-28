package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T502T;
import com.abminvestama.hcms.core.repository.T502TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T502TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t502tQueryService")
@Transactional(readOnly = true)
public class T502TQueryServiceImpl implements T502TQueryService {

	private T502TRepository t502tRepository;
	
	@Autowired
	T502TQueryServiceImpl(T502TRepository t502tRepository) {
		this.t502tRepository = t502tRepository;
	}
	
	@Override
	public Optional<T502T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t502tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T502T>> fetchAll() {
		List<T502T> listOfT502T = new ArrayList<>();
		Optional<Iterable<T502T>> bunchOfT502T = Optional.ofNullable(t502tRepository.findAll());
		return bunchOfT502T.map(iter -> {
			iter.forEach(t502t -> {
				listOfT502T.add(t502t);
			});
			return listOfT502T;
		});
	}
}