package com.abminvestama.hcms.rest.api.validator;

import java.time.DateTimeException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.abminvestama.hcms.common.util.CommonDateFunction;
import com.abminvestama.hcms.rest.api.dto.request.IT0006RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.request.IT0009RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.request.IT0021RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.request.IT0022RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.request.IT0185RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.request.IT2006RequestWrapper;
import com.abminvestama.hcms.rest.api.dto.request.ITRequestWrapper;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 * Bean validator for some SAP InfoType objects. Conform to Bean Validation 1.0 (JSR-303) 
 * and Bean Validation 1.1 (JSR-349) Validation Framework.
 */
@Component("itValidator")
public class InfoTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return IT0009RequestWrapper.class.equals(clazz)
				|| IT0006RequestWrapper.class.equals(clazz)
				|| IT0185RequestWrapper.class.equals(clazz)
				|| IT0021RequestWrapper.class.equals(clazz)
				|| IT0022RequestWrapper.class.equals(clazz)
				|| IT2006RequestWrapper.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final ITRequestWrapper request = (ITRequestWrapper) target;
		if (request.getPernr() == 0) {
			errors.rejectValue("pernr", null, "'ssn' is missing from the payload!");
		}
		if (StringUtils.isBlank(request.getSubty())) {
			errors.rejectValue("subty", null, "'subtype' is missing from the payload!");
		}
		if (StringUtils.isBlank(request.getEndda())) {
			errors.rejectValue("endda", null, "'end_date' is missing from the payload!");
		}
		if (StringUtils.isBlank(request.getBegda())) {
			errors.rejectValue("begda", null, "'begin_date' is missing from the payload!");
		}
		try {
			if (StringUtils.isNotBlank(request.getEndda())) {
				CommonDateFunction.convertDateRequestParameterIntoDate(request.getEndda());
			}
			if (StringUtils.isNotBlank(request.getBegda())) {
				CommonDateFunction.convertDateRequestParameterIntoDate(request.getBegda());
			}
		} catch (DateTimeException dte) {
			errors.rejectValue(null, null, dte.getMessage());
		}
	}
}