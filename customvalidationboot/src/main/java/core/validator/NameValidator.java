package core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameCheck, String> {

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
