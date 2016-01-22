package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.model.entity.T535N;
import com.abminvestama.hcms.core.model.entity.T535NKey;
import com.abminvestama.hcms.core.model.entity.T591S;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T535NQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T591SQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0021RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0021RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0021RequestBuilderUtil {
	
	private T005TQueryService t005tQueryService;
	private T591SQueryService t591sQueryService;
	private T535NQueryService t535nQueryService;
	
	@Autowired
	void setT005TQueryService(T005TQueryService t005tQueryService) {
		this.t005tQueryService = t005tQueryService;
	}
	
	@Autowired
	void setT591SQueryService(T591SQueryService t591sQueryService) {
		this.t591sQueryService = t591sQueryService;
	}
	
	@Autowired
	void setT535NQueryService(T535NQueryService t535nQueryService) {
		this.t535nQueryService = t535nQueryService;
	}

	/**
	 * Compare IT0021 request payload with existing IT0021 in the database.
	 * Update existing IT0021 data with the latest data comes from the request payload. 
	 * 
	 * @param requestPayload request data 
	 * @param it0021DB current existing IT0021 in the database.
	 * @return updated IT0021 object to be persisted into the database.
	 */
	public RequestObjectComparatorContainer<IT0021, IT0021RequestWrapper> compareAndReturnUpdatedData(IT0021RequestWrapper requestPayload, IT0021 it0021DB) {
		if (it0021DB == null) {
			it0021DB = new IT0021();
		} else {
			if (StringUtils.isNotBlank(requestPayload.getFamsa())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFamsa(), it0021DB.getFamsa() != null ? it0021DB.getFamsa().getSubty() : "")) {
					try {
						Optional<T591S> newT591S = t591sQueryService.findById(Optional.ofNullable(requestPayload.getFamsa()));
						if (newT591S.isPresent()) {
							it0021DB.setFamsa(newT591S.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T591S not found...cancel the update process
					}
				}
			}
			if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getFgbdt()), it0021DB.getFgbdt())) {
				it0021DB.setFgbdt(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getFgbdt()));
				requestPayload.setIsDataChanged(true);
			}
			if (StringUtils.isNotBlank(requestPayload.getFgbld())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFgbld(), it0021DB.getFgbld() != null ? it0021DB.getFgbld().getLand1() : "")) {
					try {
						Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getFgbld()));
						if (newT005T.isPresent()) {
							it0021DB.setFgbld(newT005T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						// T005T not found...cancel the update process
					}
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getFanat())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFanat(), it0021DB.getFanat() != null ? it0021DB.getFanat().getLand1() : "")) {
					try {
						Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getFanat()));
						if (newT005T.isPresent()) {
							it0021DB.setFanat(newT005T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						// T005T not found...cancel the update process
					}
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getFasex())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFasex(), it0021DB.getFasex())) {
					it0021DB.setFasex(requestPayload.getFasex());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getFavor())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFavor(), it0021DB.getFavor())) {
					it0021DB.setFavor(requestPayload.getFavor());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getFanam())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFanam(), it0021DB.getFanam())) {
					it0021DB.setFanam(requestPayload.getFanam());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getFgbot())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFgbot(), it0021DB.getFgbot())) {
					it0021DB.setFgbot(requestPayload.getFgbot());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (StringUtils.isNotBlank(requestPayload.getFcnam())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFcnam(), it0021DB.getFcnam())) {
					it0021DB.setFcnam(requestPayload.getFcnam());
					requestPayload.setIsDataChanged(true);
				}
			}
			if (CommonComparatorFunction.isDifferentNumberValues(Integer.valueOf(requestPayload.getFknzn()), it0021DB.getFknzn())) {
				it0021DB.setFknzn(requestPayload.getFknzn());
				requestPayload.setIsDataChanged(true);
			}
			if (StringUtils.isNotBlank(requestPayload.getFnmzu()) && StringUtils.isNotBlank(requestPayload.getTitle())) {
				try {
					T535NKey key = new T535NKey(requestPayload.getFnmzu(), requestPayload.getTitle());
					Optional<T535N> newT535N = t535nQueryService.findById(Optional.ofNullable(key));
					if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFnmzu(), it0021DB.getT535n().getId().getArt())
						|| CommonComparatorFunction.isDifferentStringValues(requestPayload.getTitle(), it0021DB.getT535n().getId().getTitle())) {
						it0021DB.setT535n(newT535N.get());
						requestPayload.setIsDataChanged(true);
					}					
				} catch (Exception e) {
					// T535N not found...cancel update process
				}
			}
		}
		
		return new RequestObjectComparatorContainer<IT0021, IT0021RequestWrapper>(it0021DB, requestPayload);
	}					
}