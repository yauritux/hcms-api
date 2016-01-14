package com.abminvestama.hcms.core.service.impl.business.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.model.entity.BNKA;
import com.abminvestama.hcms.core.repository.BNKARepository;
import com.abminvestama.hcms.core.service.api.business.query.BNKAQueryService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("bnkaQueryService")
@Transactional(readOnly = true)
public class BNKAQueryServiceImpl implements BNKAQueryService {
	
	private BNKARepository bnkaRepository;
	
	@Autowired
	BNKAQueryServiceImpl(BNKARepository bnkaRepository) {
		this.bnkaRepository = bnkaRepository;
	}

	@Override
	public Optional<BNKA> findById(Optional<String> id) throws Exception {
		return id.map(pk -> {
			return Optional.ofNullable(bnkaRepository.findOne(pk));
		}).orElse(Optional.empty());
	}

	@Override
	public Optional<Collection<BNKA>> fetchAll() {
		Optional<Iterable<BNKA>> bnkaIterable = Optional.ofNullable(bnkaRepository.findAll());		
		
		List<BNKA> listOfBNKA = new ArrayList<>();
		
		return bnkaIterable.map(bnkaIterators -> {
			bnkaIterators.forEach(bnka -> {
				listOfBNKA.add(bnka);
			});
			
			return listOfBNKA;
		});
	}
}