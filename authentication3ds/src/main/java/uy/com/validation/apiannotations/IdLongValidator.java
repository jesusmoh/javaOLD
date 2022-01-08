package uy.com.validation.apiannotations;

import uy.com.validation.apiannotations.impl.IdLongValidatorImpl;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { IdLongValidatorImpl.class })
public @interface IdLongValidator {

	String message() default "MSG05~~Employee Name can't contain numbers";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}