package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.model.entity.IT0021;
import com.abminvestama.hcms.core.service.api.business.query.IT0021QueryService;
import com.abminvestama.hcms.core.service.api.business.query.UserQueryService;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.IT0021ResponseWrapper;

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
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}		
}