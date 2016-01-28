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
import com.abminvestama.hcms.core.model.entity.IT0002;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT0002CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT0002QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0002RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT0002ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.IT0002RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/personal_info")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0002Controller extends AbstractResource {
	
	private IT0002CommandService it0002CommandService;
	private IT0002QueryService it0002QueryService;
	private IT0002RequestBuilderUtil it0002RequestBuilderUtil;
	
	private UserQueryService userQueryService;
	
	private Validator itValidator;
	
	@Autowired
	void setIT0002CommandService(IT0002CommandService it0002CommandService) {
		this.it0002CommandService = it0002CommandService;
	}
	
	@Autowired
	void setIT0002QueryService(IT0002QueryService it0002QueryService) {
		this.it0002QueryService = it0002QueryService;
	}
	
	@Autowired
	void setIT0002RequestBuilderUtil(IT0002RequestBuilderUtil it0002RequestBuilderUtil) {
		this.it0002RequestBuilderUtil = it0002RequestBuilderUtil;
	}
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	@Qualifier("itNoSubtypeValidator")
	void setITValidator(Validator itValidator) {
		this.itValidator = itValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0002ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT0002ResponseWrapper it0002Response = null;
		APIResponseWrapper<IT0002ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0002> listOfIT0002 = it0002QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT0002.isEmpty()) {
				it0002Response = new IT0002ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0002 it0002 = listOfIT0002.get(0);
				it0002Response = new IT0002ResponseWrapper(it0002);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it0002Response);
		response.add(linkTo(methodOn(IT0002Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}		
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT0002RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT0002ResponseWrapper responseWrapper = new IT0002ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit: {
				try {
					Optional<IT0002> it0002 = it0002QueryService.findOneByCompositeKey(request.getPernr(),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda()),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda()));
					if (!it0002.isPresent()) {
						response.setMessage("Cannot update data. No Data Found!");
						break edit;
					}
				
					RequestObjectComparatorContainer<IT0002, IT0002RequestWrapper> updatedContainer = it0002RequestBuilderUtil.compareAndReturnUpdatedData(request, it0002.get());

					if (updatedContainer.getRequestPayload().isPresent()) {
						isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
					}
				
					if (!isDataChanged) {
						response.setMessage("No data changed. No need to perform the update.");
						break edit;
					}
				
					Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
					if (updatedContainer.getEntity().isPresent()) {
						it0002 = it0002CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
					}
				
					if (!it0002.isPresent()) {
						throw new CannotPersistException("Cannot update IT0002 (Personal Information) data. Please check your data!");
					}
				
					responseWrapper = new IT0002ResponseWrapper(it0002.get());
					response = new APIResponseWrapper<>(responseWrapper);
				
				} catch (NullPointerException nfe) { 
					throw nfe;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		response.add(linkTo(methodOn(IT0002Controller.class).edit(request, result)).withSelfRel());
		return response;
	}	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}
}