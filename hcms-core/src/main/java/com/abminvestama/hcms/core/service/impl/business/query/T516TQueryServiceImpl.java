package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T516T;
import com.abminvestama.hcms.core.repository.T516TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T516TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t516tQueryService")
@Transactional(readOnly = true)
public class T516TQueryServiceImpl implements T516TQueryService {

	private T516TRepository t516tRepository;
	
	@Autowired
	T516TQueryServiceImpl(T516TRepository t516tRepository) {
		this.t516tRepository = t516tRepository;
	}
	
	@Override
	public Optional<T516T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t516tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T516T>> fetchAll() {
		List<T516T> listOfT516T = new ArrayList<>();
		Optional<Iterable<T516T>> bunchOfT516T = Optional.ofNullable(t516tRepository.findAll());
		return bunchOfT516T.map(iter -> {
			iter.forEach(t516t -> {
				listOfT516T.add(t516t);
			});
			return listOfT516T;
		});
	}
}