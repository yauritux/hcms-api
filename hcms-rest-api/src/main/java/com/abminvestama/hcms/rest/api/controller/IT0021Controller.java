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
import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.model.entity.User;
import com.abminvestama.hcms.core.service.api.business.command.IT0021CommandService;
import com.abminvestama.hcms.core.service.api.business.query.IT0021QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.helper.RequestObjectComparatorContainer;
import com.abminvestama.hcms.rest.api.dto.request.IT0021RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.ArrayData;
import com.abminvestama.hcms.rest.api.dto.response.IT0021ResponseWrapper;
import com.abminvestama.hcms.rest.api.exception.dto.ExceptionResponseWrapper;
import com.abminvestama.hcms.rest.api.helper.IT0021RequestBuilderUtil;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/v1/emergency_info")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class IT0021Controller extends AbstractResource {

	private UserQueryService userQueryService;
	private Validator itValidator;
	private IT0021RequestBuilderUtil it0021RequestBuilderUtil;
	
	private IT0021CommandService it0021CommandService;
	private IT0021QueryService it0021QueryService;
	
	@Autowired
	void setUserQueryService(UserQueryService userQueryService) {
		this.userQueryService = userQueryService;
	}
	
	@Autowired
	@Qualifier("itValidator")
	void setITValidator(Validator itValidator) {
		this.itValidator = itValidator;
	}
	
	@Autowired
	void setIT0021RequestBuilderUtil(IT0021RequestBuilderUtil it0021RequestBuilderUtil) {
		this.it0021RequestBuilderUtil = it0021RequestBuilderUtil;
	}
	
	@Autowired
	void setIT0021CommandService(IT0021CommandService it0021CommandService) {
		this.it0021CommandService = it0021CommandService;
	}
	
	@Autowired
	void setIT0021QueryService(IT0021QueryService it0021QueryService) {
		this.it0021QueryService = it0021QueryService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ssn/{pernr}", 
			headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<IT0021ResponseWrapper> findOneByPernr(@PathVariable String pernr) throws Exception {
		IT0021ResponseWrapper it0021Response = null;
		APIResponseWrapper<IT0021ResponseWrapper> response = new APIResponseWrapper<>();
		
		try {
			Long numOfPernr = Long.valueOf(pernr);
			
			List<IT0021> listOfIT0021 = it0021QueryService.findByPernr(numOfPernr).stream().collect(Collectors.toList());
			
			if (listOfIT0021.isEmpty()) {
				it0021Response = new IT0021ResponseWrapper(null);
				response.setMessage("No Data Found");
			} else {
				IT0021 it0021 = listOfIT0021.get(0);
				it0021Response = new IT0021ResponseWrapper(it0021);
			}
		} catch (NumberFormatException nfe) {
			throw nfe;
		} catch (Exception e) {
			throw e;
		}

		response.setData(it0021Response);
		response.add(linkTo(methodOn(IT0185Controller.class).findOneByPernr(pernr)).withSelfRel());
		return response;
	}	
	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public APIResponseWrapper<?> edit(@RequestBody @Validated IT0021RequestWrapper request, BindingResult result) throws Exception {
		APIResponseWrapper<?> response = null;
		
		if (result.hasErrors()) {
			response = new APIResponseWrapper<>(new ArrayData<>(
                           ExceptionResponseWrapper.getErrors(
                              result.getFieldErrors(), HttpMethod.PUT
                           )
                       ), "Validation error!");
		} else {
			boolean isDataChanged = false;
			
			IT0021ResponseWrapper responseWrapper = new IT0021ResponseWrapper(null);
			
			response = new APIResponseWrapper<>(responseWrapper);
			
			edit: {
				try {
					Optional<IT0021> it0021 = it0021QueryService.findOneByCompositeKey(request.getPernr(), request.getSubty(),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda()),
							CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda()));
					if (!it0021.isPresent()) {
						response.setMessage("Cannot update data. No Data Found!");
						break edit;
					}
				
					RequestObjectComparatorContainer<IT0021, IT0021RequestWrapper> updatedContainer = it0021RequestBuilderUtil.compareAndReturnUpdatedData(request, it0021.get());

					if (updatedContainer.getRequestPayload().isPresent()) {
						isDataChanged = updatedContainer.getRequestPayload().get().isDataChanged();
					}
				
					if (!isDataChanged) {
						response.setMessage("No data changed. No need to perform the update.");
						break edit;
					}
				
					Optional<User> currentUser = userQueryService.findByUsername(currentUser());
				
					if (updatedContainer.getEntity().isPresent()) {
						it0021 = it0021CommandService.save(updatedContainer.getEntity().get(), currentUser.isPresent() ? currentUser.get() : null);
					}
				
					if (!it0021.isPresent()) {
						throw new CannotPersistException("Cannot update IT0021 (Emergency Info) data. Please check your data!");
					}
				
					responseWrapper = new IT0021ResponseWrapper(it0021.get());
					response = new APIResponseWrapper<>(responseWrapper);
				
				} catch (NullPointerException nfe) { 
					throw nfe;
				} catch (Exception e) {
					throw e;
				}
			}
		}
		
		response.add(linkTo(methodOn(IT0021Controller.class).edit(request, result)).withSelfRel());
		return response;
	}	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}		
}