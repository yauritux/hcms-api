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

import com.abminvestama.hcms.core.exception.CannotPersistException;
import com.abminvestama.hcms.core.model.entity.IT0009;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT0009CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT0009QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.IT0009RequestComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0009RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT0009ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.CommonRESTUtil;
import com.abminvestama.hcms.rest.api.helper.IT0009RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/bank")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0009Controller extends AbstractResource {

	private IT0009CommandService it0009CommandService;
	private IT0009QueryService it0009QueryService;
	private IT0009RequestBuilderUtil it0009RequestBuilderUtil;
	private UserQueryService userQueryService;
	private Validator it0009Validator;
	
	@Autowired
	void setIT0009CommandService(IT0009CommandService it0009CommandService) {
		this.it0009CommandService = it0009CommandService;
	}
	
	@Autowired
	void setIT0009QueryService(IT0009QueryService it0009QueryService) {
		this.it0009QueryService = it0009QueryService;
	}
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	void setIT0009RequestBuilderUtil(IT0009RequestBuilderUtil it0009RequestBuilderUtil) {
		this.it0009RequestBuilderUtil = it0009RequestBuilderUtil;
	}
	
	@Autowired
	@Qualifier("it0009Validator")
	void setIT0009Validator(Validator it0009Validator) {
		this.it0009Validator = it0009Validator;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0009ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT0009ResponseWrapper it0009Response = null;
		APIResponseWrapper<IT0009ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0009> listOfIT0009 = it0009QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT0009.isEmpty()) {
				it0009Response = new IT0009ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0009 it0009 = listOfIT0009.get(0);
				it0009Response = new IT0009ResponseWrapper(it0009);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it0009Response);
		response.add(linkTo(methodOn(IT0009Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}	
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT0009RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT0009ResponseWrapper responseWrapper = new IT0009ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit:
			try {
				Optional<IT0009> it0009 = it0009QueryService.findOneByCompositeKey(request.getPernr(), request.getSubty(),
						CommonRESTUtil.convertDateRequestParameterIntoDate(request.getEndda()),
						CommonRESTUtil.convertDateRequestParameterIntoDate(request.getBegda()));
				if (!it0009.isPresent()) {
					response.setMessage("Cannot update data. No Data Found!");
					break edit;
				}
				
				IT0009RequestComparatorContainer updatedContainer = it0009RequestBuilderUtil.compareAndReturnUpdatedData(request, it0009.get());

				if (updatedContainer.getRequestPayload().isPresent()) {
					isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
				}
				
				if (!isDataChanged) {
					response.setMessage("No data changed. No need to perform the update.");
					break edit;
				}
				
				Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
				if (updatedContainer.getEntity().isPresent()) {
					it0009 = it0009CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
				}
				
				if (!it0009.isPresent()) {
					throw new CannotPersistException("Cannot update IT0006 data. Please check your data!");
				}
				
				responseWrapper = new IT0009ResponseWrapper(it0009.get());
				
			} catch (NullPointerException nfe) { 
				throw nfe;
			} catch (Exception e) {
				throw e;
			}
		}
		
		response.add(linkTo(methodOn(IT0009Controller.class).edit(request, result)).withSelfRel());
		return response;
	}	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(it0009Validator);
	}
}