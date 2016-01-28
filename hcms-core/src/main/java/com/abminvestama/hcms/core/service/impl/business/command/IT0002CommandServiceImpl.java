package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0002;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT0002Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT0002CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it0002CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0002CommandServiceImpl implements IT0002CommandService {

	private IT0002Repository it0002Repository;
	
	@Autowired
	IT0002CommandServiceImpl(IT0002Repository it0002Repository) {
		this.it0002Repository = it0002Repository;
	}
	
	@Override
	public Optional<IT0002> save(IT0002 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it0002Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT0002 (Personal Information).Reason=" + e.getMessage());
		}				
	}

	@Override
	public boolean delete(IT0002 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");
	}

	@Override
	public boolean restore(IT0002 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}
}