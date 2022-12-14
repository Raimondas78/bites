package com.raimondas.bites.entity.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonalCodeValidator implements ConstraintValidator<NumberConstraint, String> {

    @Override
    public void initialize(NumberConstraint personalCode) {
    }

    @Override
    public boolean isValid(String personalCode, ConstraintValidatorContext cxt) {

        return personalCode != null && personalCode.matches("[0-9]+")
                && (personalCode.length() == 11);
    }
}
