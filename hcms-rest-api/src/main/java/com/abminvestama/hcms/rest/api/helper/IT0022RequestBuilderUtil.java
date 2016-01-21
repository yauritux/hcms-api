package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.core.model.entity.IT0022;
import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.model.entity.T517T;
import com.abminvestama.hcms.core.model.entity.T517X;
import com.abminvestama.hcms.core.model.entity.T518B;
import com.abminvestama.hcms.core.model.entity.T519T;
import com.abminvestama.hcms.core.model.entity.T538T;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T517TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T517XQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T518BQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T519TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T538TQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0022RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0022RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0022RequestBuilderUtil {
	
	private T517TQueryService t517tQueryService;
	private T005TQueryService t005tQueryService;
	private T518BQueryService t518bQueryService;
	private T519TQueryService t519tQueryService;
	private T538TQueryService t538tQueryService;
	private T517XQueryService t517xQueryService;
	
	@Autowired
	void setT517TQueryService(T517TQueryService t517tQueryService) {
		this.t517tQueryService = t517tQueryService;
	}
	
	@Autowired
	void setT005TQueryService(T005TQueryService t005tQueryService) {
		this.t005tQueryService = t005tQueryService;
	}
	
	@Autowired
	void setT518BQueryService(T518BQueryService t518bQueryService) {
		this.t518bQueryService = t518bQueryService;
	}
	
	@Autowired
	void setT519TQueryService(T519TQueryService t519tQueryService) {
		this.t519tQueryService = t519tQueryService;
	}
	
	@Autowired
	void setT538TQueryService(T538TQueryService t538tQueryService) {
		this.t538tQueryService = t538tQueryService;
	}
	
	@Autowired
	void setT517XQueryService(T517XQueryService t517xQueryService) {
		this.t517xQueryService = t517xQueryService;
	}

	/**
	 * Compare IT0022 request payload with existing IT0022 in the database.
	 * Update existing IT0022 data with the latest data comes from the request payload. 
	 * 
	 * @param requestPayload request data 
	 * @param it0021DB current existing IT0022 in the database.
	 * @return updated IT0022 object to be persisted into the database.
	 */
	public final RequestObjectComparatorContainer<IT0022, IT0022RequestWrapper> compareAndReturnUpdatedData(IT0022RequestWrapper requestPayload, IT0022 it0022DB) {
		if (it0022DB == null) {
			it0022DB = new IT0022();
		} else {
			
			if (StringUtils.isNotBlank(requestPayload.getSlart())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getSlart(), it0022DB.getSlart() != null ? it0022DB.getSlart().getSlart() : StringUtils.EMPTY)) {
					try {
						Optional<T517T> newT517T = t517tQueryService.findById(Optional.ofNullable(requestPayload.getSlart()));
						if (newT517T.isPresent()) {
							it0022DB.setSlart(newT517T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T517T not found... cancel the update process
					}
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getInsti())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getInsti(), it0022DB.getInsti())) {
					it0022DB.setInsti(requestPayload.getInsti());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getSland())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getSland(), it0022DB.getSland() != null ? it0022DB.getSland().getLand1() : StringUtils.EMPTY)) {
					try {
						Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getSland()));
						if (newT005T.isPresent()) {
							it0022DB.setSland(newT005T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T005T not found... cancel the update process
					}
				}
			}
			if (requestPayload.getAusbi() != 0) {
				if (CommonComparatorFunction.isDifferentNumberValues(Long.valueOf(requestPayload.getAusbi()), it0022DB.getAusbi() != null ? it0022DB.getAusbi().getAusbi().longValue() : 0)) {
					try {
						Optional<T518B> newT518B = t518bQueryService.findById(Optional.ofNullable(requestPayload.getAusbi()));
						if (newT518B.isPresent()) {
							it0022DB.setAusbi(newT518B.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T518B not found... cancel the update process
					}
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getSlabs())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getSlabs(), it0022DB.getSlabs() != null ? it0022DB.getSlabs().getSlabs() : StringUtils.EMPTY)) {
					try {
						Optional<T519T> newT519T = t519tQueryService.findById(Optional.ofNullable(requestPayload.getSlabs()));
						if (newT519T.isPresent()) {
							it0022DB.setSlabs(newT519T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T519T not found... cancel the update process
					}
				}
			}
			if (requestPayload.getAnzkl() != 0.0) {
				if (CommonComparatorFunction.isDifferentNumberValues(Double.valueOf(requestPayload.getAnzkl()), it0022DB.getAnzkl().doubleValue())) {
					it0022DB.setAnzkl(requestPayload.getAnzkl());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getAnzeh())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getAnzeh(), it0022DB.getAnzeh() != null ? it0022DB.getAnzeh().getZeinh() : StringUtils.EMPTY)) {
					try {
						Optional<T538T> newT538T = t538tQueryService.findById(Optional.ofNullable(requestPayload.getAnzeh()));
						if (newT538T.isPresent()) {
							it0022DB.setAnzeh(newT538T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T538T not found... cancel the update process
					}
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getSltp1())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getSltp1(), it0022DB.getSltp1() != null ? it0022DB.getSltp1().getFaart() : StringUtils.EMPTY)) {
					try {
						Optional<T517X> newT517X = t517xQueryService.findById(Optional.ofNullable(requestPayload.getSltp1()));
						if (newT517X.isPresent()) {
							it0022DB.setSltp1(newT517X.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T517X not found... cancel the update process
					}
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getSltp2())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getSltp2(), it0022DB.getSltp2() != null ? it0022DB.getSltp2().getFaart() : StringUtils.EMPTY)) {
					try {
						Optional<T517X> newT517X = t517xQueryService.findById(Optional.ofNullable(requestPayload.getSltp2()));
						if (newT517X.isPresent()) {
							it0022DB.setSltp2(newT517X.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T517X not found... cancel the update process
					}
				}
			}			
		}
		
		return new RequestObjectComparatorContainer<IT0022, IT0022RequestWrapper>(it0022DB, requestPayload);
	}						
}