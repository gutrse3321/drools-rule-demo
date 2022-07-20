package ru.reimu.alice.hibernateExtension.validator;

import ru.reimu.alice.hibernateExtension.annotation.StringJson;
import ru.reimu.alice.support.StringUtility;
import ru.reimu.alice.support.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @date 2020-09-22 10:44
 */
public class StringJsonValidator implements ConstraintValidator<StringJson, String> {

    @Override
    public void initialize(StringJson constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtility.hasLength(s)) return true;
        return ValidatorUtility.isJsonString(s);
    }
}
