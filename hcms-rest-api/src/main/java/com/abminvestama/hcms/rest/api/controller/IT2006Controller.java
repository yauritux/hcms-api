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

import com.abminvestama.hcms.core.model.entity.IT2006;
import com.abminvestama.hcms.core.service.api.business.query.IT2006QueryService;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.IT2006ResponseWrapper;

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

	private IT2006QueryService it2006QueryService;
	
	private Validator itValidator;
	
	@Autowired
	void setIT2006QueryService(IT2006QueryService it2006QueryService) {
		this.it2006QueryService = it2006QueryService;
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
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(itValidator);
	}
}