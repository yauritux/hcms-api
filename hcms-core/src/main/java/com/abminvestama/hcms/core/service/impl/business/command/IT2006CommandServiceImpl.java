package com.abminvestama.hcms.core.service.impl.business.command;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT2006;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.repository.IT2006Repository;
import com.abminvestama.hcms.core.service.api.business.command.IT2006CommandService;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service("it2006CommandService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT2006CommandServiceImpl implements IT2006CommandService {

	private IT2006Repository it2006Repository;
	
	@Autowired
	IT2006CommandServiceImpl(IT2006Repository it2006Repository) {
		this.it2006Repository = it2006Repository;
	}
	
	@Override
	public Optional<IT2006> save(IT2006 entity, User user)
			throws CannotPersistException, NoSuchMethodException, ConstraintViolationException {
		if (user != null) {
			entity.setUname(user.getId());
		}
		
		try {
			return Optional.ofNullable(it2006Repository.save(entity));
		} catch (Exception e) {
			throw new CannotPersistException("Cannot persist IT2006 (Absence Quota Types).Reason=" + e.getMessage());
		}						
	}

	@Override
	public boolean delete(IT2006 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// no delete at this version.
		throw new NoSuchMethodException("There's no deletion on this version. Please consult to your Consultant.");		
	}

	@Override
	public boolean restore(IT2006 entity, User user) throws NoSuchMethodException, ConstraintViolationException {
		// since we don't have delete operation, then we don't need the 'restore' as well
		throw new NoSuchMethodException("Invalid Operation. Please consult to your Consultant.");
	}

}
