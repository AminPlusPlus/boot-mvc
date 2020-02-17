package com.amin.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidation implements ConstraintValidator<CourseCode,String>  {

    private String prefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return (s != null && s.startsWith(prefix));
    }
}
