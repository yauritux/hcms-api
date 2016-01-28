package com.abminvestama.hcms.core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abminvestama.hcms.core.model.entity.T535N;
import com.abminvestama.hcms.core.model.entity.T535NKey;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface T535NRepository extends CrudRepository<T535N, T535NKey> {
	
	@Query("FROM T535N t535n WHERE t535n.id.art = :art AND t535n.id.title = :title")
	T535N findOneByCompositeKey(@Param("art") String art, @Param("title") String title);
}