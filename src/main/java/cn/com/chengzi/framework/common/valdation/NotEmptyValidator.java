package cn.com.chengzi.framework.common.valdation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;


public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

	@Override
	public void initialize(NotEmpty constrainAnnotation) {
				
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {		
		return StringUtils.isEmpty(value);
	}
}
