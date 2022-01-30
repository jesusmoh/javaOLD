package core.validation.annotations.impl;

import core.validation.annotations.ApiEmailValidator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ApiEmailValidatorImpl implements ConstraintValidator<ApiEmailValidator, String> {

    @Value("${validator.api.email.regex}")
    private String validatorApiEmailRegex;

    private static String mattcherRegex;

    @PostConstruct
    public void ini() {
        mattcherRegex = validatorApiEmailRegex;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        return value.matches(mattcherRegex);
    }

}
