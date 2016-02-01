package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT2006;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT2006CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT2006QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT2006RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT2006ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.IT2006RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/absence_quotas")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT2006Controller extends AbstractResource {

	private IT2006CommandService it2006CommandService;
	private IT2006QueryService it2006QueryService;
	private IT2006RequestBuilderUtil it2006RequestBuilderUtil;
	
	private UserQueryService userQueryService;
	
	private Validator itValidator;
	
	@Autowired
	void setIT2006CommandService(IT2006CommandService it2006CommandService) {
		this.it2006CommandService = it2006CommandService;
	}
	
	@Autowired
	void setIT2006QueryService(IT2006QueryService it2006QueryService) {
		this.it2006QueryService = it2006QueryService;
	}
	
	@Autowired
	void setIT2006RequestBuilderUtil(IT2006RequestBuilderUtil it2006RequestBuilderUtil) {
		this.it2006RequestBuilderUtil = it2006RequestBuilderUtil;
	}
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	@Qualifier("itValidator")
	void setITValidator(Validator itValidator) {
		this.itValidator = itValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT2006ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT2006ResponseWrapper it2006Response = null;
		APIResponseWrapper<IT2006ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT2006> listOfIT2006 = it2006QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT2006.isEmpty()) {
				it2006Response = new IT2006ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT2006 it2006 = listOfIT2006.get(0);
				it2006Response = new IT2006ResponseWrapper(it2006);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it2006Response);
		response.add(linkTo(methodOn(IT2006Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}	
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT2006RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT2006ResponseWrapper responseWrapper = new IT2006ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit: {
				try {
					Optional<IT2006> it2006 = it2006QueryService.findOneByCompositeKey(request.getPernr(), request.getSubty(),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda()),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda()));
					if (!it2006.isPresent()) {
						response.setMessage("Cannot update data. No Data Found!");
						break edit;
					}
				
					RequestObjectComparatorContainer<IT2006, IT2006RequestWrapper> updatedContainer = it2006RequestBuilderUtil.compareAndReturnUpdatedData(request, it2006.get());

					if (updatedContainer.getRequestPayload().isPresent()) {
						isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
					}
				
					if (!isDataChanged) {
						response.setMessage("No data changed. No need to perform the update.");
						break edit;
					}
				
					Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
					if (updatedContainer.getEntity().isPresent()) {
						System.out.println("IT2006Controller::edit::updating IT2006 Entity...");
						it2006 = it2006CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
					}
				
					if (!it2006.isPresent()) {
						throw new CannotPersistException("Cannot update IT2006 (Absence Quota Types) data. Please check your data!");
					}
				
					responseWrapper = new IT2006ResponseWrapper(it2006.get());
					response = new APIResponseWrapper<>(responseWrapper);
				
				} catch (NullPointerException nfe) { 
					throw nfe;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		response.add(linkTo(methodOn(IT2006Controller.class).edit(request, result)).withSelfRel());
		return response;
	}	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}
}