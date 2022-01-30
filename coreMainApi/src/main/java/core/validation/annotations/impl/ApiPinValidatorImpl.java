package core.validation.annotations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import core.validation.annotations.ApiPinValidator;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ApiPinValidatorImpl implements ConstraintValidator<ApiPinValidator, String> {

    @Value("${validator.api.pin.regex}")
    private String validatorApiPinRegex;

    private static String mattcherRegex;

    @PostConstruct
    public void ini() {
        mattcherRegex = validatorApiPinRegex;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        return value.matches(mattcherRegex);
    }

}
