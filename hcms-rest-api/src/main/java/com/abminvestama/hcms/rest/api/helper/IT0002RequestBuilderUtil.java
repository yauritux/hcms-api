package com.abminvestama.hcms.rest.api.helper;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abminvestama.hcms.common.util.CommonComparatorFunction;
import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.model.entity.IT0002;
import com.abminvestama.hcms.core.model.entity.T002T;
import com.abminvestama.hcms.core.model.entity.T005T;
import com.abminvestama.hcms.core.model.entity.T502T;
import com.abminvestama.hcms.core.model.entity.T516T;
import com.abminvestama.hcms.core.model.entity.T522G;
import com.abminvestama.hcms.core.model.entity.T535N;
import com.abminvestama.hcms.core.model.entity.T535NKey;
import com.abminvestama.hcms.core.service.api.business.query.T002TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T005TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T502TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T516TQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T522GQueryService;
import com.abminvestama.hcms.core.service.api.business.query.T535NQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0002RequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component("it0002RequestBuilderUtil")
@Transactional(readOnly = true)
public class IT0002RequestBuilderUtil {
	
	private T535NQueryService t535nQueryService;
	private T522GQueryService t522gQueryService;
	private T005TQueryService t005tQueryService;
	private T002TQueryService t002tQueryService;
	private T516TQueryService t516tQueryService;
	private T502TQueryService t502tQueryService;
	
	@Autowired
	void setT535NQueryService(T535NQueryService t535nQueryService) {
		this.t535nQueryService = t535nQueryService;
	}
	
	@Autowired
	void setT522GQueryService(T522GQueryService t522gQueryService) {
		this.t522gQueryService = t522gQueryService;
	}
	
	@Autowired
	void setT005TQueryService(T005TQueryService t005tQueryService) {
		this.t005tQueryService = t005tQueryService;
	}
	
	@Autowired
	void setT002TQueryService(T002TQueryService t002tQueryService) {
		this.t002tQueryService = t002tQueryService;
	}
	
	@Autowired
	void setT516TQueryService(T516TQueryService t516tQueryService) {
		this.t516tQueryService = t516tQueryService;
	}
	
	@Autowired
	void setT502TQueryService(T502TQueryService t502tQueryService) {
		this.t502tQueryService = t502tQueryService;
	}

	/**
	 * Compare IT0002 requested payload with an existing IT0002 in the database.
	 * Update the existing IT0002 data with the latest data comes from the requested payload. 
	 * 
	 * @param requestPayload requested data 
	 * @param it0002DB current existing IT0002 in the database.
	 * @return updated IT0002 object to be persisted into the database.
	 */
	public RequestObjectComparatorContainer<IT0002, IT0002RequestWrapper> compareAndReturnUpdatedData(IT0002RequestWrapper requestPayload, IT0002 it0002DB) {
		
		if (it0002DB == null) {
			it0002DB = new IT0002();
		} else {
			
			if (StringUtils.isNotBlank(requestPayload.getNachn())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getNachn(), it0002DB.getNachn())) {
					it0002DB.setNachn(requestPayload.getNachn());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getCname())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getCname(), it0002DB.getCname())) {
					it0002DB.setCname(requestPayload.getCname());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getArt()) && StringUtils.isNotBlank(requestPayload.getTitle())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getArt(), it0002DB.getTitle() != null ? it0002DB.getTitle().getId().getArt() : StringUtils.EMPTY)
						&&
					CommonComparatorFunction.isDifferentStringValues(requestPayload.getTitle(),  it0002DB.getTitle() != null ? it0002DB.getTitle().getId().getTitle() : StringUtils.EMPTY)) {
					try {
						Optional<T535N> newT535N = t535nQueryService.findById(Optional.ofNullable(new T535NKey(requestPayload.getArt(), requestPayload.getTitle())));
						if (newT535N.isPresent()) {
							it0002DB.setTitle(newT535N.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T535N not found... cancel the update process
					}
				}
			}

			if (StringUtils.isNotBlank(requestPayload.getArt2()) && StringUtils.isNotBlank(requestPayload.getTitle2())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getArt2(), it0002DB.getTitl2() != null ? it0002DB.getTitl2().getId().getArt() : StringUtils.EMPTY)
						&&
					CommonComparatorFunction.isDifferentStringValues(requestPayload.getTitle2(),  it0002DB.getTitl2() != null ? it0002DB.getTitl2().getId().getTitle() : StringUtils.EMPTY)) {
					try {
						Optional<T535N> newT535N = t535nQueryService.findById(Optional.ofNullable(new T535NKey(requestPayload.getArt2(), requestPayload.getTitle2())));
						if (newT535N.isPresent()) {
							it0002DB.setTitl2(newT535N.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T535N not found... cancel the update process
					}
				}
			}			
			
			if (StringUtils.isNotBlank(requestPayload.getArt3()) && StringUtils.isNotBlank(requestPayload.getTitle3())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getArt3(), it0002DB.getNamzu() != null ? it0002DB.getNamzu().getId().getArt() : StringUtils.EMPTY)
						&&
					CommonComparatorFunction.isDifferentStringValues(requestPayload.getTitle3(),  it0002DB.getNamzu() != null ? it0002DB.getNamzu().getId().getTitle() : StringUtils.EMPTY)) {
					try {
						Optional<T535N> newT535N = t535nQueryService.findById(Optional.ofNullable(new T535NKey(requestPayload.getArt3(), requestPayload.getTitle3())));
						if (newT535N.isPresent()) {
							it0002DB.setNamzu(newT535N.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T535N not found... cancel the update process
					}
				}
			}			
			
			if (StringUtils.isNotBlank(requestPayload.getRufnm())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getRufnm(), it0002DB.getRufnm())) {
					it0002DB.setRufnm(requestPayload.getRufnm());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getKnznm())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getKnznm(), it0002DB.getKnznm())) {
					it0002DB.setKnznm(requestPayload.getKnznm());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getAnred())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getAnred(), it0002DB.getAnred().getAnred())) {
					try {
						Optional<T522G> newT522G = t522gQueryService.findById(Optional.ofNullable(requestPayload.getAnred()));
						if (newT522G.isPresent()) {
							it0002DB.setAnred(newT522G.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T522G not found... cancel the update process
					}
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getGesch())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getGesch(), it0002DB.getGesch())) {
					it0002DB.setGesch(requestPayload.getGesch());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getGbdat())) {
				if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getGbdat()), it0002DB.getGbdat())) {
					it0002DB.setGbdat(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getGbdat()));
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getGblnd())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getGblnd(), it0002DB.getGblnd() != null ? it0002DB.getGblnd().getLand1() : StringUtils.EMPTY)) {
					try {
						Optional<T005T> newT005T = t005tQueryService.findById(Optional.ofNullable(requestPayload.getGblnd()));
						if (newT005T.isPresent()) {
							it0002DB.setGblnd(newT005T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T005T not found... cancel the update process
					}
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getGbort())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getGbort(), it0002DB.getGbort())) {
					it0002DB.setGbort(requestPayload.getGbort());
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getSprsl())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getSprsl(), it0002DB.getSprsl() != null ? it0002DB.getSprsl().getSprsl() : StringUtils.EMPTY)) {
					try {
						Optional<T002T> newT002T = t002tQueryService.findById(Optional.ofNullable(requestPayload.getSprsl()));
						if (newT002T.isPresent()) {
							it0002DB.setSprsl(newT002T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T002T not found... cancel the update process
					}
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getKonfe())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getKonfe(), it0002DB.getKonfe() != null ? it0002DB.getKonfe().getKonfe() : StringUtils.EMPTY)) {
					try {
						Optional<T516T> newT516T = t516tQueryService.findById(Optional.ofNullable(requestPayload.getKonfe()));
						if (newT516T.isPresent()) {
							it0002DB.setKonfe(newT516T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T516T not found... cancel the update process
					}
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getFamst())) {
				if (CommonComparatorFunction.isDifferentStringValues(requestPayload.getFamst(), it0002DB.getFamst() != null ? it0002DB.getFamst().getFamst() : StringUtils.EMPTY)) {
					try {
						Optional<T502T> newT502T = t502tQueryService.findById(Optional.ofNullable(requestPayload.getFamst()));
						if (newT502T.isPresent()) {
							it0002DB.setFamst(newT502T.get());
							requestPayload.setIsDataChanged(true);
						}
					} catch (Exception e) {
						//T502T not found.. cancel the update process
					}
				}
			}
			
			if (StringUtils.isNotBlank(requestPayload.getFamdt())) {
				if (CommonComparatorFunction.isDifferentDateValues(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getFamdt()), it0002DB.getFamdt())) {
					it0002DB.setFamdt(CommonDateFunction.convertDateRequestParameterIntoDate(requestPayload.getFamdt()));
					requestPayload.setIsDataChanged(true);
				}
			}
			
			if (requestPayload.getAnzkd() != 0) {
				if (CommonComparatorFunction.isDifferentNumberValues(requestPayload.getAnzkd(), it0002DB.getAnzkd() != null ? it0002DB.getAnzkd().byteValue() : 0)) {
					it0002DB.setAnzkd(requestPayload.getAnzkd());
					requestPayload.setIsDataChanged(true);
				}
			}
		}
		
		return new RequestObjectComparatorContainer<IT0002, IT0002RequestWrapper>(it0002DB, requestPayload);
	}								
}