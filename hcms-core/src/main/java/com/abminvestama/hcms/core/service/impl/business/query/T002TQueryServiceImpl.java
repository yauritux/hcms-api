package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T002T;
import com.abminvestama.hcms.core.repository.T002TRepository;
import com.abminvestama.hcms.core.service.api.business.query.T002TQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t002tQueryService")
@Transactional(readOnly = true)
public class T002TQueryServiceImpl implements T002TQueryService {

	private T002TRepository t002tRepository;
	
	@Autowired
	T002TQueryServiceImpl(T002TRepository t002tRepository) {
		this.t002tRepository = t002tRepository;
	}
	
	@Override
	public Optional<T002T> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t002tRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T002T>> fetchAll() {
		List<T002T> listOfT002T = new ArrayList<>();
		Optional<Iterable<T002T>> bunchOfT002T = Optional.ofNullable(t002tRepository.findAll());
		return bunchOfT002T.map(iter -> {
			iter.forEach(t002t -> {
				listOfT002T.add(t002t);
			});
			return listOfT002T;
		});
	}
}