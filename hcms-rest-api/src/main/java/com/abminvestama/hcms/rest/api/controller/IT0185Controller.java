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
import com.abminvestama.hcms.core.model.entity.IT0185;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT0185CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT0185QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0185RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT0185ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.IT0185RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/personal_id")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0185Controller extends AbstractResource {

	private UserQueryService userQueryService;
	private IT0185RequestBuilderUtil it0185RequestBuilderUtil;
	private IT0185CommandService it0185CommandService;
	private IT0185QueryService it0185QueryService;
	private Validator itValidator;
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	void setIT0185RequestBuilderUtil(IT0185RequestBuilderUtil it0185RequestBuilderUtil) {
		this.it0185RequestBuilderUtil = it0185RequestBuilderUtil;
	}
	
	@Autowired
	void setIT0185CommandService(IT0185CommandService it0185CommandService) {
		this.it0185CommandService = it0185CommandService;
	}
	
	@Autowired
	void setIT0185QueryService(IT0185QueryService it0185QueryService) {
		this.it0185QueryService = it0185QueryService;
	}
	
	@Autowired
	@Qualifier("itValidator")
	void setITValidator(Validator itValidator) {
		this.itValidator = itValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0185ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT0185ResponseWrapper it0185Response = null;
		APIResponseWrapper<IT0185ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0185> listOfIT0185 = it0185QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT0185.isEmpty()) {
				it0185Response = new IT0185ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0185 it0185 = listOfIT0185.get(0);
				it0185Response = new IT0185ResponseWrapper(it0185);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it0185Response);
		response.add(linkTo(methodOn(IT0185Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}		
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT0185RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT0185ResponseWrapper responseWrapper = new IT0185ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit: {
				try {
					Optional<IT0185> it0185 = it0185QueryService.findOneByCompositeKey(request.getPernr(), request.getSubty(),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda()),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda()));
					if (!it0185.isPresent()) {
						response.setMessage("Cannot update data. No Data Found!");
						break edit;
					}
				
					RequestObjectComparatorContainer<IT0185, IT0185RequestWrapper> updatedContainer = it0185RequestBuilderUtil.compareAndReturnUpdatedData(request, it0185.get());

					if (updatedContainer.getRequestPayload().isPresent()) {
						isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
					}
				
					if (!isDataChanged) {
						response.setMessage("No data changed. No need to perform the update.");
						break edit;
					}
				
					Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
					if (updatedContainer.getEntity().isPresent()) {
						it0185 = it0185CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
					}
				
					if (!it0185.isPresent()) {
						throw new CannotPersistException("Cannot update IT0006 data. Please check your data!");
					}
				
					responseWrapper = new IT0185ResponseWrapper(it0185.get());
					response = new APIResponseWrapper<>(responseWrapper);
				
				} catch (NullPointerException nfe) { 
					throw nfe;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		response.add(linkTo(methodOn(IT0185Controller.class).edit(request, result)).withSelfRel());
		return response;
	}		
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}	
}