package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0023;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeysNoSubtype;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0023Repository extends CrudRepository<IT0023, ITCompositeKeysNoSubtype> {

	@Query("FROM IT0023 it0023 WHERE it0023.pernr = :pernr AND it0023.id.endda = :endda AND it0023.id.begda = :begda")
	IT0023 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT0023 it0023 WHERE it0023.pernr = :pernr ORDER BY it0023.id.endda DESC")
	Collection<IT0023> findByPernr(@Param("pernr") Long pernr);	
}