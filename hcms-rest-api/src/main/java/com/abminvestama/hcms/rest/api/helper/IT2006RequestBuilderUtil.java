package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.model.entity.IT2006;
import com.abminvestama.hcms.core.model.entity.T556B;
import com.abminvestama.hcms.core.service.api.business.query.T556BQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT2006RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it2006RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT2006RequestBuilderUtil {

	private T556BQueryService t556bQueryService;
	
	@Autowired
	void setT556BQueryService(T556BQueryService t556bQueryService) {
		this.t556bQueryService = t556bQueryService;
	}
	
	/**
	 * Compare IT2006 requested payload with an existing IT2006 in the database.
	 * Update the existing IT2006 data with the latest data comes from the requested payload. 
	 * 
	 * @param requestPayload requested data 
	 * @param it2006DB current existing IT2006 in the database.
	 * @return updated IT2006 object to be persisted into the database.
	 */
	public RequestObjectComparatorContainer<IT2006, IT2006RequestWrapper> compareAndReturnUpdatedData(IT2006RequestWrapper requestPayload, IT2006 it2006DB) {
		if (it2006DB == null) {
			it2006DB = new IT2006();
		} else {
			
			if (requestPayload.getKtart() != 0) {
				if (CommonComparatorFunction.isDifferentNumberValues(requestPayload.getKtart(), it2006DB.getKtart() != null ? it2006DB.getKtart().getKtart().intValue() : 0)) {
					try {
						Optional<T556B> newT556B = t556bQueryService.findById(Optional.ofNullable(requestPayload.getKtart()));
						if (newT556B.isPresent()) {
							it2006DB.setKtart(newT556B.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T517T not found... cancel the update process
					}
				}
			}
			
			if (CommonComparatorFunction.isDifferentNumberValues(requestPayload.getAnzhl(), it2006DB.getAnzhl() != null ? it2006DB.getAnzhl().doubleValue() : 0.0)) {
				it2006DB.setAnzhl(requestPayload.getAnzhl());
				requestPayload.setIsDataChanged(true);
			}
			
			if (CommonComparatorFunction.isDifferentNumberValues(requestPayload.getKverb(), it2006DB.getKverb() != null ? it2006DB.getKverb().doubleValue() : 0.0)) {
				it2006DB.setKverb(requestPayload.getKverb());
				requestPayload.setIsDataChanged(true);
			}
			
			if (StringUtils.isNotBlank(requestPayload.getDesta())) {
				if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getDesta()), it2006DB.getDesta())) {
					it2006DB.setDesta(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getDesta()));
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getDeend())) {
				if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getDeend()), it2006DB.getDeend())) {
					it2006DB.setDeend(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getDeend()));
					requestPayload.setIsDataChanged(true);
				}
			}
		}
		
		return new RequestObjectComparatorContainer<IT2006, IT2006RequestWrapper>(it2006DB, requestPayload);
	}							
}
