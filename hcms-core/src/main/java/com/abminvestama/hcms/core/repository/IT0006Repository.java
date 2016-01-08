package com.abminvestama.hcms.core.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.model.entity.IT0006Key;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IT0006Repository extends CrudRepository<IT0006, IT0006Key> {
	
	@Query("FROM IT0006 it0006 WHERE it0006.pernr = :pernr ORDER BY it0006.id.subty ASC, it0006.endda DESC")
	Collection<IT0006> findByPernr(@Param("pernr") Long pernr);
	
	@Query("FROM IT0006 it0006 WHERE it0006.pernr = :pernr AND it0006.id.subty = :subty ORDER BY endda DESC")
	Collection<IT0006> findByPernrAndSubty(@Param("pernr") Long pernr, @Param("subty") String subty);
}