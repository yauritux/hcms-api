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
import com.abminvestama.hcms.core.model.entity.IT0022;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT0022CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT0022QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0022RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT0022ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.IT0022RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/education")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0022Controller extends AbstractResource {
	
	private IT0022CommandService it0022CommandService;
	private IT0022QueryService it0022QueryService;
	
	private Validator itValidator;
	private IT0022RequestBuilderUtil it0022RequestBuilderUtil;
	private UserQueryService userQueryService;
	
	@Autowired
	void setIT0022CommandService(IT0022CommandService it0022CommandService) {
		this.it0022CommandService = it0022CommandService;
	}
	
	@Autowired
	void setIT0022QueryService(IT0022QueryService it0022QueryService) {
		this.it0022QueryService = it0022QueryService;
	}
	
	@Autowired
	@Qualifier("itValidator")	
	void setITValidator(Validator itValidator) {
		this.itValidator = itValidator;
	}
	
	@Autowired
	@Qualifier("it0022RequestBuilderUtil")
	void setIT0022RequestBuilderUtil(IT0022RequestBuilderUtil it0022RequestBuilderUtil) {
		this.it0022RequestBuilderUtil = it0022RequestBuilderUtil;
	}
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0022ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT0022ResponseWrapper it0022Response = null;
		APIResponseWrapper<IT0022ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0022> listOfIT0022 = it0022QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT0022.isEmpty()) {
				it0022Response = new IT0022ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0022 it0022 = listOfIT0022.get(0);
				it0022Response = new IT0022ResponseWrapper(it0022);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it0022Response);
		response.add(linkTo(methodOn(IT0022Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}	
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT0022RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT0022ResponseWrapper responseWrapper = new IT0022ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit: {
				try {
					Optional<IT0022> it0022 = it0022QueryService.findOneByCompositeKey(request.getPernr(), request.getSubty(),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda()),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda()));
					if (!it0022.isPresent()) {
						response.setMessage("Cannot update data. No Data Found!");
						break edit;
					}
				
					RequestObjectComparatorContainer<IT0022, IT0022RequestWrapper> updatedContainer = it0022RequestBuilderUtil.compareAndReturnUpdatedData(request, it0022.get());

					if (updatedContainer.getRequestPayload().isPresent()) {
						isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
					}
				
					System.out.println("IT0022Controller::isDataChanged = " + isDataChanged);
					if (!isDataChanged) {
						response.setMessage("No data changed. No need to perform the update.");
						break edit;
					}
				
					Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
					if (updatedContainer.getEntity().isPresent()) {
						it0022 = it0022CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
					}
				
					if (!it0022.isPresent()) {
						throw new CannotPersistException("Cannot update IT0022 (Educational Info) data. Please check your data!");
					}
				
					responseWrapper = new IT0022ResponseWrapper(it0022.get());
					response = new APIResponseWrapper<>(responseWrapper);
				
				} catch (NullPointerException nfe) { 
					throw nfe;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		response.add(linkTo(methodOn(IT0022Controller.class).edit(request, result)).withSelfRel());
		return response;
	}	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}			
}