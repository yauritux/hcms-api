package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT2006;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT2006Repository extends CrudRepository<IT2006, ITCompositeKeys> {

	@Query("FROM IT2006 it2006 WHERE it2006.pernr = :pernr AND it2006.id.infty = '2006' AND it2006.id.subty = :subty AND it2006.id.endda = :endda AND it2006.id.begda = :begda")
	IT2006 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("subty") String subty,
			@Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT2006 it2006 WHERE it2006.pernr = :pernr AND it2006.id.infty = '2006' ORDER BY it2006.id.subty ASC, it2006.id.endda DESC")
	Collection<IT2006> findByPernr(@Param("pernr") Long pernr);
	
	@Query("FROM IT2006 it2006 WHERE it2006.pernr = :pernr AND it2006.id.infty = '2006' AND it2006.id.subty = :subty ORDER BY it2006.id.endda DESC")
	Collection<IT2006> findByPernrAndSubty(@Param("pernr") Long pernr, @Param("subty") String subty);			
}