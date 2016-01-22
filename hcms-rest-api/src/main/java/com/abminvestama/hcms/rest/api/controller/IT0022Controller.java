package com.abminvestama.hcms.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abminvestama.hcms.core.model.entity.IT0022;
import com.abminvestama.hcms.core.service.api.business.query.IT0022QueryService;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.IT0022ResponseWrapper;

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
	
	private IT0022QueryService it0022QueryService;
	
	@Autowired
	void setIT0022QueryService(IT0022QueryService it0022QueryService) {
		this.it0022QueryService = it0022QueryService;
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
}