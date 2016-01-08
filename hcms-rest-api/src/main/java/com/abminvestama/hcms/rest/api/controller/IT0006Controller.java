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

import com.abminvestama.hcms.core.model.entity.IT0006;
import com.abminvestama.hcms.core.service.api.business.query.IT0006QueryService;
import com.abminvestama.hcms.rest.api.dto.response.APIResponseWrapper;
import com.abminvestama.hcms.rest.api.dto.response.IT0006ResponseWrapper;

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

	private IT0006QueryService it0006QueryService;
	
	@Autowired
	void setIT0006QueryService(IT0006QueryService it0006QueryService) {
		this.it0006QueryService = it0006QueryService;
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
				it0006Response = new IT0006ResponseWrapper();
				response.setMessage("No Data Found");
			} else {
				IT0006 it0006 = listOfIT0006.get(0);
				it0006Response = new IT0006ResponseWrapper();
				it0006Response.setPernr(numOfPernr).setAedtm(it0006.getAedtm()).setUname(it0006.getUname())
					.setAnssa(it0006.getAnssa()).setName2(it0006.getName2()).setStras(it0006.getStras())
					.setOrt01(it0006.getOrt01()).setOrt02(it0006.getOrt02()).setPstlz(it0006.getPstlz())
					.setTelnr(it0006.getTelnr()).setEntkm(it0006.getEntkm() != null ? it0006.getEntkm() : 0.0)
					.setLocat(it0006.getLocat()).setEntk2(it0006.getEntk2() != null ? it0006.getEntk2() : 0.0)
					.setCom01(it0006.getCom01()).setNum01(it0006.getNum01());
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
}