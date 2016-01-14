package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0009;
import com.abminvestama.hcms.core.model.entity.IT0009Key;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0009Repository extends CrudRepository<IT0009, IT0009Key> {

	@Query("FROM IT0009 it0009 WHERE it0009.pernr = :pernr AND it0009.id.subty = :subty AND it0009.id.endda = :endda AND it0009.id.begda = :begda")
	IT0009 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("subty") String subty,
			@Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT0009 it0009 WHERE it0009.pernr = :pernr ORDER BY it0009.id.subty ASC, it0009.id.endda DESC")
	Collection<IT0009> findByPernr(@Param("pernr") Long pernr);
	
	@Query("FROM IT0009 it0009 WHERE it0009.pernr = :pernr AND it0009.id.subty = :subty ORDER BY it0009.id.endda DESC")
	Collection<IT0009> findByPernrAndSubty(@Param("pernr") Long pernr, @Param("subty") String subty);	
}