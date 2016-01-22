package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0022;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0022Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0022CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0022CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class IT0022CommandServiceImpl implements IT0022CommandService {

	private IT0022Repository it0022Repository;
	
	@Autowired
	IT0022CommandServiceImpl(IT0022Repository it0022Repository) {
		this.it0022Repository = it0022Repository;
	}
	
	@Override
	public Optional<IT0022> save(IT0022 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0022Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT0022 (Educational Info).Reason=" + e.getMessage());
		}				
	}

	@Override
	public boolean delete(IT0022 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0022 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}
}