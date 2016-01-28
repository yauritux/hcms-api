package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T522G;
import com.abminvestama.hcms.core.repository.T522GRepository;
import com.abminvestama.hcms.core.service.api.business.query.T522GQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t522gQueryService")
@Transactional(readOnly = true)
public class T522GQueryServiceImpl implements T522GQueryService {

	private T522GRepository t522gRepository;
	
	@Autowired
	T522GQueryServiceImpl(T522GRepository t522gRepository) {
		this.t522gRepository = t522gRepository;
	}
	
	@Override
	public Optional<T522G> findById(Optional<String> id) throws Exception {
		return id.map(pk -> t522gRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T522G>> fetchAll() {
		List<T522G> listOfT522G = new ArrayList<>();
		Optional<Iterable<T522G>> bunchOfT522G = Optional.ofNullable(t522gRepository.findAll());
		return bunchOfT522G.map(iter -> {
			iter.forEach(t522g -> {
				listOfT522G.add(t522g);
			});
			return listOfT522G;
		});
	}
}