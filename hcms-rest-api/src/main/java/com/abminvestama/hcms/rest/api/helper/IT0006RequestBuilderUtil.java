package com.abminvestama.hcms.rest.api.helper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0006RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0006RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0006RequestBuilderUtil {

	/**
	 * Compare IT0006 request payload with existing IT0006 in the database.
	 * Update existing IT0006 data with the latest data comes from the request payload. 
	 * 
	 * @param requestPayload request data 
	 * @param it0006DB current existing IT0006 in the database.
	 * @return updated IT0006 object to be persisted into the database.
	 */
	public final RequestObjectComparatorContainer<IT0006, IT0006RequestWrapper> compareAndReturnUpdatedData(IT0006RequestWrapper requestPayload, IT0006 it0006DB) {
		if (it0006DB == null) {
			it0006DB = new IT0006();
		} else {
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getAnssa(), it0006DB.getAnssa())) {
				it0006DB.setAnssa(StringUtils.defaultString(requestPayload.getAnssa(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getName2(), it0006DB.getName2())) {
				it0006DB.setName2(StringUtils.defaultString(requestPayload.getName2(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getStras(), it0006DB.getStras())) {
				it0006DB.setStras(StringUtils.defaultString(requestPayload.getStras(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getOrt01(), it0006DB.getOrt01())) {
				it0006DB.setOrt01(StringUtils.defaultString(requestPayload.getOrt01(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getOrt02(), it0006DB.getOrt02())) {
				it0006DB.setOrt02(StringUtils.defaultString(requestPayload.getOrt02(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getPstlz(), it0006DB.getPstlz())) {
				it0006DB.setPstlz(StringUtils.defaultString(requestPayload.getPstlz(), ""));
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getTelnr(), it0006DB.getTelnr())) {
				it0006DB.setTelnr(StringUtils.defaultString(requestPayload.getTelnr(), ""));
				requestPayload.setIsDataChanged(true);
			}			
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getOrt02(), it0006DB.getOrt02())) {
				it0006DB.setOrt02(StringUtils.defaultString(requestPayload.getOrt02(), ""));
				requestPayload.setIsDataChanged(true);
			}			
			if (requestPayload.getEntkm() != (it0006DB.getEntkm() != null ? it0006DB.getEntkm().doubleValue() : 0.0)) {
				it0006DB.setEntkm(requestPayload.getEntkm());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getLocat(), it0006DB.getLocat())) {
				it0006DB.setLocat(StringUtils.defaultString(requestPayload.getLocat(), ""));
				requestPayload.setIsDataChanged(true);
			}			
			if (requestPayload.getEntk2() != (it0006DB.getEntk2() != null ? it0006DB.getEntk2().doubleValue() : 0.0)) {
				it0006DB.setEntk2(requestPayload.getEntk2());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getCom01(), it0006DB.getCom01())) {
				it0006DB.setCom01(StringUtils.defaultString(requestPayload.getCom01(), ""));
				requestPayload.setIsDataChanged(true);
			}			
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getNum01(), it0006DB.getNum01())) {
				it0006DB.setNum01(StringUtils.defaultString(requestPayload.getNum01(), ""));
				requestPayload.setIsDataChanged(true);
			}			
		}
		
		return new RequestObjectComparatorContainer<IT0006, IT0006RequestWrapper>(it0006DB, requestPayload);
	}				
}