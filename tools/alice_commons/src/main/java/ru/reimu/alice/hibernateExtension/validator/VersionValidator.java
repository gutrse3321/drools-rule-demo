package ru.reimu.alice.hibernateExtension.validator;

import ru.reimu.alice.hibernateExtension.annotation.Version;
import ru.reimu.alice.support.StringUtility;
import ru.reimu.alice.support.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author Tomonori
 * @Mail gutrse3321@live.com
 * @Date 2020-09-20 3:02 AM
 */
public class VersionValidator implements ConstraintValidator<Version, String> {

    @Override
    public void initialize(Version constraintAnnotation) {
    }

    /**
     * 检查APP版本格式 例：1.0.0
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtility.hasText(value)) {
            return true;
        }
        return ValidatorUtility.checkClientVersion(value);
    }
}
