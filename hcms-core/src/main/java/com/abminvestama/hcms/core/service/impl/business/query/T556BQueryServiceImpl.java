package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T556B;
import com.abminvestama.hcms.core.repository.T556BRepository;
import com.abminvestama.hcms.core.service.api.business.query.T556BQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t556bQueryService")
@Transactional(readOnly = true)
public class T556BQueryServiceImpl implements T556BQueryService {

	private T556BRepository t556bRepository;
	
	@Autowired
	T556BQueryServiceImpl(T556BRepository t556bRepository) {
		this.t556bRepository = t556bRepository;
	}
	
	@Override
	public Optional<T556B> findById(Optional<Integer> id) throws Exception {
		return id.map(pk -> t556bRepository.findOne(pk));
	}

	@Override
	public Optional<Collection<T556B>> fetchAll() {
		List<T556B> listOfT556B = new ArrayList<>();
		Optional<Iterable<T556B>> bunchOfT556B = Optional.ofNullable(t556bRepository.findAll());
		return bunchOfT556B.map(iter -> {
			iter.forEach(t556b -> {
				listOfT556B.add(t556b);
			});
			return listOfT556B;
		});
	}
}