package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.T042Z;
import com.abminvestama.hcms.core.repository.T042ZRepository;
import com.abminvestama.hcms.core.service.api.business.query.T042ZQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("t042zQueryService")
@Transactional(readOnly = true)
public class T042ZQueryServiceImpl implements T042ZQueryService {
	
	private T042ZRepository t042zRepository;
	
	@Autowired
	T042ZQueryServiceImpl(T042ZRepository t042ZRepository) {
		this.t042zRepository = t042ZRepository;
	}

	@Override
	public Optional<T042Z> findById(Optional<String> id) throws Exception {
		return id.map(pk -> {
			return Optional.ofNullable(t042zRepository.findOne(pk));
		}).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<T042Z>> fetchAll() {
		Optional<Iterable<T042Z>> iterableT042Z = Optional.ofNullable(t042zRepository.findAll());

		List<T042Z> listOfT042Z = new ArrayList<>();
		
		return iterableT042Z.map(iterT042Z -> {
			iterT042Z.forEach(t042z -> {
				listOfT042Z.add(t042z);
			});;
			return listOfT042Z;
		});
	}
}