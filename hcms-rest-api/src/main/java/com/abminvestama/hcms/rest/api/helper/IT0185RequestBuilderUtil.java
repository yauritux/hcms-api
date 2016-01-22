package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.model.entity.IT0185;
import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.model.entity.T5R06;
import com.abminvestama.hcms.core.service.api.business.command.T5R06QueryService;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0185RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0185RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0185RequestBuilderUtil {
	
	private T5R06QueryService t5r06QueryService;
	private T005TQueryService t005tQueryService;
	
	@Autowired
	void setT5R06QueryService(T5R06QueryService t5r06QueryService) {
		this.t5r06QueryService = t5r06QueryService;
	}
	
	@Autowired
	void setT005TQueryService(T005TQueryService t005tQueryService) {
		this.t005tQueryService = t005tQueryService;
	}

	/**
	 * Compare IT0185 request payload with existing IT0185 in the database.
	 * Update existing IT0185 data with the latest data comes from the request payload. 
	 * 
	 * @param requestPayload request data 
	 * @param it0185DB current existing IT0185 in the database.
	 * @return updated IT0185 object to be persisted into the database.
	 */
	public RequestObjectComparatorContainer<IT0185, IT0185RequestWrapper> compareAndReturnUpdatedData(IT0185RequestWrapper requestPayload, IT0185 it0185DB) {
		if (it0185DB == null) {
			it0185DB = new IT0185();
		} else {
			if (requestPayload.getIctyp() != null) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getIctyp(), it0185DB.getIctyp() != null ? it0185DB.getIctyp().getIctyp() : "")) {
					try {
						Optional<T5R06> newT5R06 = t5r06QueryService.findById(Optional.ofNullable(requestPayload.getIctyp()));
						if (newT5R06.isPresent()) {
							it0185DB.setIctyp(newT5R06.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						// T5R06 not found...cancel the update process
					}
				}
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getIcnum(), it0185DB.getIcnum())) {
				it0185DB.setIcnum(StringUtils.defaultString(requestPayload.getIcnum(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getAuth1(), it0185DB.getAuth1())) {
				it0185DB.setAuth1(StringUtils.defaultString(requestPayload.getAuth1(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getFpdat()), it0185DB.getFpdat())) {
				it0185DB.setFpdat(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getFpdat()));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getExpid()), it0185DB.getExpid())) {
				it0185DB.setExpid(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getExpid()));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getIsspl(), it0185DB.getIsspl())) {
				it0185DB.setIsspl(requestPayload.getIsspl());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getIscot(), it0185DB.getIscot() != null ? it0185DB.getIscot().getLand1() : "")) {
				try {
					Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getIscot()));
					if (newT005T.isPresent()) {
						it0185DB.setIscot(newT005T.get());
						requestPayload.setIsDataChanged(true);
					}
				} catch (Exception e) {
					// T005T not found... cancel the update process
				}
			}
		}
		
		return new RequestObjectComparatorContainer<IT0185, IT0185RequestWrapper>(it0185DB, requestPayload);
	}				
}