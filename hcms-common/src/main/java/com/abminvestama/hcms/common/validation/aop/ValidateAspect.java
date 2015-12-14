package com.abminvestama.hcms.common.validation.aop;

import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.HibernateValidator;

/**
 * 
 * @author yauri (yauritux@gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Aspect
public class ValidateAspect {

	@Pointcut("execution(@com.abminvestama.hcms.common.validation.annotation.ValidateMethod * *.*(..))")
	public void methodAnnotated() {}
	
	@Pointcut("execution(public * *(.., @com.abminvestama.hcms.common.validation.annotation.ValidateMethod (*), ..))")
	public void parameterAnnotated() {}
	
	@Before("methodAnnotated() || parameterAnnotated()")
	public void validate(JoinPoint jp) throws NoSuchMethodException, ConstraintViolationException {
		final Method method = ((MethodSignature) jp.getSignature()).getMethod();
		
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
		
		ExecutableValidator executableValidator = validatorFactory.getValidator().forExecutables();
		Set<ConstraintViolation<Object>> violations = executableValidator.validateParameters(jp.getTarget(), method, jp.getArgs());
		
		if (violations != null && !violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}
}