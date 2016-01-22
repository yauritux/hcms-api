package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.core.model.entity.BNKA;
import com.abminvestama.hcms.core.model.entity.IT0009;
import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.model.entity.T042Z;
import com.abminvestama.hcms.core.model.entity.T591S;
import com.abminvestama.hcms.core.service.api.business.query.BNKAQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T042ZQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T591SQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0009RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0009RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0009RequestBuilderUtil {

	private T591SQueryService t591sQueryService;
	private T042ZQueryService t042zQueryService;
	private T005TQueryService t005tQueryService;
	private BNKAQueryService bnkaQueryService;
	
	@Autowired
	void setT591SQueryService(T591SQueryService t591sQueryService) {
		this.t591sQueryService = t591sQueryService;
	}
	
	@Autowired
	void setT042ZQueryService(T042ZQueryService t042zQueryService) {
		this.t042zQueryService = t042zQueryService;
	}
	
	@Autowired
	void setT005TQueryService(T005TQueryService t005tQueryService) {
		this.t005tQueryService = t005tQueryService;
	}
	
	@Autowired
	void setBNKAQueryService(BNKAQueryService bnkaQueryService) {
		this.bnkaQueryService = bnkaQueryService;
	}
	
	/**
	 * Compare IT0009 request payload with existing IT0009 in the database.
	 * Update existing IT0009 data with the latest data comes from the request payload. 
	 * 
	 * @param requestPayload request data 
	 * @param it0009DB current existing IT0009 in the database.
	 * @return updated IT0009 object to be persisted into the database.
	 */
	public RequestObjectComparatorContainer<IT0009, IT0009RequestWrapper> compareAndReturnUpdatedData(IT0009RequestWrapper requestPayload, IT0009 it0009DB) {
		if (it0009DB == null) {
			it0009DB = new IT0009();
		} else {
			if (requestPayload.getBetrg() != (it0009DB.getBetrg() != null ? it0009DB.getBetrg().doubleValue() : 0.0)) {
				it0009DB.setBetrg(requestPayload.getBetrg());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getWaers(), it0009DB.getWaers())) {
				it0009DB.setWaers(StringUtils.defaultString(requestPayload.getWaers()));
				requestPayload.setIsDataChanged(true);
			}
			if (requestPayload.getAnzhl() != (it0009DB.getAnzhl() != null ? it0009DB.getAnzhl().doubleValue() : 0.0)) {
				it0009DB.setAnzhl(requestPayload.getAnzhl());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBnksa(), it0009DB.getBnksa() != null ? it0009DB.getBnksa().getSubty() : "")) {
				try {
					Optional<T591S> newT591S = t591sQueryService.findById(Optional.ofNullable(requestPayload.getBnksa()));
					if (newT591S.isPresent()) {
						it0009DB.setBnksa(newT591S.get());
						requestPayload.setIsDataChanged(true);
					}
				} catch (Exception e) {
					// bnksa not found..., ignore change
				}
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getZlsch(), it0009DB.getZlsch() != null ? it0009DB.getZlsch().getZlsch() : "")) {
				try {
					Optional<T042Z> newT042Z = t042zQueryService.findById(Optional.ofNullable(requestPayload.getZlsch()));
					if (newT042Z.isPresent()) {
						it0009DB.setZlsch(newT042Z.get());
						requestPayload.setIsDataChanged(true);
					}
				} catch (Exception e) {
					// zlsch not found..., ignore change
				}
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getEmftx(), it0009DB.getEmftx())) {
				it0009DB.setEmftx(requestPayload.getEmftx());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBkplz(), it0009DB.getBkplz())) {
				it0009DB.setBkplz(requestPayload.getBkplz());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBkort(), it0009DB.getBkort())) {
				it0009DB.setBkort(requestPayload.getBkort());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBanks(), it0009DB.getBanks() != null ? it0009DB.getBanks().getLand1() : "")) {
				try {
					Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getBanks()));
					if (newT005T.isPresent()) {
						it0009DB.setBanks(newT005T.get());
						requestPayload.setIsDataChanged(true);
					}
				} catch (Exception e) {
					// banks not found..., ignore change
				}
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBankl(), it0009DB.getBankn())) {
				try {
					Optional<BNKA> newBNKA = bnkaQueryService.findById(Optional.ofNullable(requestPayload.getBankl()));
					if (newBNKA.isPresent()) {
						it0009DB.setBankl(newBNKA.get());
						requestPayload.setIsDataChanged(true);
					}
				} catch (Exception e) {
					// bnka not found..., ignore change
				}
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getBankn(), it0009DB.getBankn())) {
				it0009DB.setBankn(requestPayload.getBankn());
				requestPayload.setIsDataChanged(true);
			}
			if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getZweck(), it0009DB.getZweck())) {
				it0009DB.setZweck(requestPayload.getZweck());
				requestPayload.setIsDataChanged(true);
			}
		}
		
		return new RequestObjectComparatorContainer<IT0009, IT0009RequestWrapper>(it0009DB, requestPayload);
	}			
}