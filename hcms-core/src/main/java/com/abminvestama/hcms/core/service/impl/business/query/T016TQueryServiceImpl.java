package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T016T;
import com.abminvestama.hcms.core.repository.T016TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T016TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t016tQueryService")
@Transactional(readOnly = true)
public class T016TQueryServiceImpl implements T016TQueryService {

	private T016TRepository t016tRepository;
	
	@Autowired
	public T016TQueryServiceImpl(T016TRepository t016tRepository) {
		this.t016tRepository = t016tRepository;
	}
	
	@Override
	public Optional<T016T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t016tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T016T>> fetchAll() {
		List<T016T> listOfT016T = new ArrayList<>();
		Optional<Iterable<T016T>> bunchOfT016T = Optional.ofNullable(t016tRepository.findAll());
		return bunchOfT016T.map(iter -> {
			iter.forEach(t016t -> {
				listOfT016T.add(t016t);
			});
			return listOfT016T;
		});
	}
}