package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0022;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0022Repository extends CrudRepository<IT0022, ITCompositeKeys> {
	
	@Query("FROM IT0022 it0022 WHERE it0022.pernr = :pernr AND it0022.id.infty = '0022' AND it0022.id.subty = :subty AND it0022.id.endda = :endda AND it0022.id.begda = :begda")
	IT0022 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("subty") String subty,
			@Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT0022 it0022 WHERE it0022.pernr = :pernr AND it0022.id.infty = '0022' ORDER BY it0022.id.subty ASC, it0022.id.endda DESC")
	Collection<IT0022> findByPernr(@Param("pernr") Long pernr);
	
	@Query("FROM IT0022 it0022 WHERE it0022.pernr = :pernr AND it0022.id.infty = '0022' AND it0022.id.subty = :subty ORDER BY it0022.id.endda DESC")
	Collection<IT0022> findByPernrAndSubty(@Param("pernr") Long pernr, @Param("subty") String subty);		
}