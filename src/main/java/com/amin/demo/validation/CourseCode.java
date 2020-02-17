package com.amin.demo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeValidation.class)
@Target(value = {ElementType.FIELD,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME )
public @interface CourseCode {
    String value()  default "MUM";
    String message() default "must start with MUM";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
