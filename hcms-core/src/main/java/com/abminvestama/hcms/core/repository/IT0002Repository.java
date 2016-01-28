package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0002;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeysNoSubtype;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0002Repository extends CrudRepository<IT0002, ITCompositeKeysNoSubtype> {
	
	@Query("FROM IT0002 it0002 WHERE it0002.pernr = :pernr AND it0002.id.endda = :endda AND it0002.id.begda = :begda")
	IT0002 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT0002 it0002 WHERE it0002.pernr = :pernr ORDER BY it0002.id.endda DESC")
	Collection<IT0002> findByPernr(@Param("pernr") Long pernr);		
}