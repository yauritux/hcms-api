package com.abminvestama.hcms.core.repository;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0185;
import com.abminvestama.hcms.core.model.entity.ITCompositeKeys;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0185Repository extends CrudRepository<IT0185, ITCompositeKeys> {
	
	@Query("FROM IT0185 it0185 WHERE it0185.pernr = :pernr AND it0185.id.infty = :infty AND it0185.id.subty = :subty AND it0185.id.endda = :endda AND it0185.id.begda = :begda")
	IT0185 findOneByCompositeKey(@Param("pernr") Long pernr, @Param("infty") String infty, @Param("subty") String subty,
			@Param("endda") @Temporal(TemporalType.DATE) Date endda,
			@Param("begda") @Temporal(TemporalType.DATE) Date begda);
	
	@Query("FROM IT0185 it0185 WHERE it0185.pernr = :pernr AND it0185.id.infty = :infty ORDER BY it0185.id.subty ASC, it0185.id.endda DESC")
	Collection<IT0185> findByPernr(@Param("pernr") Long pernr, @Param("infty") String infty);
	
	@Query("FROM IT0185 it0185 WHERE it0185.pernr = :pernr AND it0185.id.infty = :infty AND it0185.id.subty = :subty ORDER BY it0185.id.endda DESC")
	Collection<IT0185> findByPernrAndSubty(@Param("pernr") Long pernr, @Param("infty") String infty, @Param("subty") String subty);		
}