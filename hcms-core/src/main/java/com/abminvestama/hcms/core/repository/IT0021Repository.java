package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0021Repository extends CrudRepository<IT0021, ITCompositeKeys> {
	
	@Query("FROM IT0021 it0021 WHERE it0021.pernr = :pernr AND it0021.id.subty = :subty AND it0021.id.endda = :endda AND it0021.id.begda = :begda")
	IT0021 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("subty") String subty,
			@Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT0021 it0021 WHERE it0021.pernr = :pernr ORDER BY it0021.id.subty ASC, it0021.id.endda DESC")
	Collection<IT0021> findByPernr(@Param("pernr") Long pernr);
	
	@Query("FROM IT0021 it0021 WHERE it0021.pernr = :pernr AND it0021.id.subty = :subty ORDER BY it0021.id.endda DESC")
	Collection<IT0021> findByPernrAndSubty(@Param("pernr") Long pernr, @Param("subty") String subty);		
}