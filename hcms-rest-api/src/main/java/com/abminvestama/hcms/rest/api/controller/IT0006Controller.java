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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT0006CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT0006QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0006RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT0006ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.IT0006RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/address")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0006Controller extends AbstractResource {

	private IT0006CommandService it0006CommandService;
	private IT0006QueryService it0006QueryService;
	private IT0006RequestBuilderUtil it0006RequestBuilderUtil;
	private UserQueryService userQueryService;
	private Validator itValidator;
	
	@Autowired
	void setIT0006CommandService(IT0006CommandService it0006CommandService) {
		this.it0006CommandService = it0006CommandService;
	}
	
	@Autowired
	void setIT0006QueryService(IT0006QueryService it0006QueryService) {
		this.it0006QueryService = it0006QueryService;
	}	
	
	@Autowired
	void setIT0006RequestBuilderUtil(IT0006RequestBuilderUtil it0006RequestBuilderUtil) {
		this.it0006RequestBuilderUtil = it0006RequestBuilderUtil;
	}
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	@Qualifier("itValidator")
	public void setITValidator(Validator itValidator) {
		this.itValidator = itValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0006ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT0006ResponseWrapper it0006Response = null;
		APIResponseWrapper<IT0006ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0006> listOfIT0006 = it0006QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT0006.isEmpty()) {
				it0006Response = new IT0006ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0006 it0006 = listOfIT0006.get(0);
				it0006Response = new IT0006ResponseWrapper(it0006);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it0006Response);
		response.add(linkTo(methodOn(IT0006Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0006ResponseWrapper> findOneByPernrAndSubty(
			@RequestParam("pernr") String pernr, @RequestParam(required = false, defaultValue = "1") String subty) throws Exception {
		
		IT0006ResponseWrapper it0006Response = null;
		APIResponseWrapper<IT0006ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0006> listOfIT0006 = it0006QueryService.findByPernrAndSubty(numOfPernr, subty).stream().collect(Collectors.toList());
			
			if (listOfIT0006.isEmpty()) {
				it0006Response = new IT0006ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0006 it0006 = listOfIT0006.get(0);
				it0006Response = new IT0006ResponseWrapper(it0006);
			}
		} catch (NumberFormatException nfe) { 
			throw nfe;
		} catch (Exception e) {
			throw e;
		}
		
		response.setData(it0006Response);
		response.add(linkTo(methodOn(IT0006Controller.class).findOneByPernrAndSubty(pernr, subty)).withSelfRel());
		return response;
	}
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT0006RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT0006ResponseWrapper responseWrapper = new IT0006ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit: {
				try {
					Optional<IT0006> it0006 = it0006QueryService.findOneByCompositeKey(request.getPernr(), request.getSubty(),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda()),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda()));
					if (!it0006.isPresent()) {
						response.setMessage("Cannot update data. No Data Found!");
						break edit;
					}
				
					RequestObjectComparatorContainer<IT0006, IT0006RequestWrapper> updatedContainer = it0006RequestBuilderUtil.compareAndReturnUpdatedData(request, it0006.get());
				
					if (updatedContainer.getRequestPayload().isPresent()) {
						isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
					}
				
					if (!isDataChanged) {
						response.setMessage("No data changed. No need to perform the update.");
						break edit;
					}
				
					Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
					if (updatedContainer.getEntity().isPresent()) {
						it0006 = it0006CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
					}
				
					if (!it0006.isPresent()) {
						throw new CannotPersistException("Cannot update IT0006 (Address) data. Please check your data!");
					}				
				
					responseWrapper = new IT0006ResponseWrapper(it0006.get());
					response = new APIResponseWrapper<>(responseWrapper);
				
				} catch (NullPointerException nfe) { 
					throw nfe;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		response.add(linkTo(methodOn(IT0006Controller.class).edit(request, result)).withSelfRel());
		return response;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}
}