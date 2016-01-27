package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0023;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0023Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0023CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0023CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class IT0023CommandServiceImpl implements IT0023CommandService {

	private IT0023Repository it0023Repository;
	
	@Autowired
	IT0023CommandServiceImpl(IT0023Repository it0023Repository) {
		this.it0023Repository = it0023Repository;
	}
	
	@Override
	public Optional<IT0023> save(IT0023 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0023Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT0023 (Employment History).Reason=" + e.getMessage());
		}				
	}

	@Override
	public boolean delete(IT0023 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0023 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}
}