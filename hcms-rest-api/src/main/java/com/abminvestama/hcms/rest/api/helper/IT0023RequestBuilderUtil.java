package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.core.model.entity.IT0023;
import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.model.entity.T016T;
import com.abminvestama.hcms.core.model.entity.T513C;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T016TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T513CQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0023RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0023RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0023RequestBuilderUtil {

	private T513CQueryService t513cQueryService;
	private T005TQueryService t005tQueryService;
	private T016TQueryService t016tQueryService;
	
	@Autowired
	void setT513CQueryService(T513CQueryService t513cQueryService) {
		this.t513cQueryService = t513cQueryService;
	}
	
	@Autowired
	void setT005TQueryService(T005TQueryService t005tQueryService) {
		this.t005tQueryService = t005tQueryService;
	}
	
	@Autowired
	void setT016TQueryService(T016TQueryService t016tQueryService) {
		this.t016tQueryService = t016tQueryService;
	}
	
	/**
	 * Compare IT0023 requested payload with an existing IT0023 in the database.
	 * Update the existing IT0023 data with the latest data comes from the requested payload. 
	 * 
	 * @param requestPayload requested data 
	 * @param it0023DB current existing IT0023 in the database.
	 * @return updated IT0023 object to be persisted into the database.
	 */
	public RequestObjectComparatorContainer<IT0023, IT0023RequestWrapper> compareAndReturnUpdatedData(IT0023RequestWrapper requestPayload, IT0023 it0023DB) {
		if (it0023DB == null) {
			it0023DB = new IT0023();
		} else {
			
			if (StringUtils.isNotBlank(requestPayload.getArbgb())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getArbgb(), it0023DB.getArbgb())) {
					it0023DB.setArbgb(requestPayload.getArbgb());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getOrt01())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getOrt01(), it0023DB.getOrt01())) {
					it0023DB.setOrt01(requestPayload.getOrt01());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getLand1())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getLand1(), it0023DB.getLand1() != null ? it0023DB.getLand1().getLand1() : StringUtils.EMPTY)) {
					try {
						Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getLand1().trim()));
						if (newT005T.isPresent()) {
							it0023DB.setLand1(newT005T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T005T not found... cancel the update process
					}
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getBranc())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBranc(), it0023DB.getBranc() != null ? it0023DB.getBranc().getBrsch() : StringUtils.EMPTY)) {
					try {
						Optional<T016T> newT016T = t016tQueryService.findById(Optional.ofNullable(requestPayload.getBranc()));
						if (newT016T.isPresent()) {
							it0023DB.setBranc(newT016T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T016T not found... cancel the update process
					}
				}
			}
			if (requestPayload.getTaete() != 0) {
				if (CommonComparatorFunction.isDifferentNumberValues(Long.valueOf(requestPayload.getTaete()), it0023DB.getTaete() != null ? it0023DB.getTaete().getTaete().longValue() : 0l)) {
					try {
						Optional<T513C> newT513C = t513cQueryService.findById(Optional.ofNullable(requestPayload.getTaete()));
						if (newT513C.isPresent()) {
							it0023DB.setTaete(newT513C.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T513C not found... cancel the update process
					}
				}
			}
		}
		
		return new RequestObjectComparatorContainer<IT0023, IT0023RequestWrapper>(it0023DB, requestPayload);
	}							
}