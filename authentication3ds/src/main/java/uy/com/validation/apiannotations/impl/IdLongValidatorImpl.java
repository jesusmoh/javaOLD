package uy.com.validation.apiannotations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uy.com.validation.apiannotations.IdLongValidator;

public class IdLongValidatorImpl implements ConstraintValidator<IdLongValidator, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext arg1) {

        if (name.matches("[a-zA-Z]+")) {
            return true;
        } else {
            System.out.println("Pattern Matched -->" + name);
            return false;
        }
    }

}
