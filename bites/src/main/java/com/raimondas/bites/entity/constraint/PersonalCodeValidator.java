package com.raimondas.bites.entity.constraint;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PersonalCodeValidator implements ConstraintValidator<NumberConstraint, Object> {

    private String personalCode;
    private String companyName;
    private String companyCode;

    @Override
    public void initialize(NumberConstraint annotation) {

        this.personalCode = annotation.personalCode();
        this.companyName = annotation.companyName();
        this.companyCode = annotation.companyCode();

    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext constraintValidatorContext) {

        Object pCode = new BeanWrapperImpl(value).getPropertyValue(personalCode);
        Object compName = new BeanWrapperImpl(value).getPropertyValue(companyName);
        Object compCode = new BeanWrapperImpl(value).getPropertyValue(companyCode);

        if (pCode != null && !pCode.equals("")) {
//            Long number = 0L;
//            try {
//                number = Long.parseLong((String) pCode);
//            } catch (NumberFormatException ex) {
//                throw new IllegalArgumentException("Cannot parse Long from String in Customer personal code");
//            }
            boolean toReturn = pCode.toString().matches("[0-9]+") && (pCode.toString().length() == 11);
            if (!toReturn) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext
                        .buildConstraintViolationWithTemplate("Personal code is not valid")
                        .addPropertyNode(personalCode)
                        .addBeanNode()
                        .addConstraintViolation();
                return false;
            }
        } else if (compName == null || compName.equals("")) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Company name must be present")
                    .addBeanNode()
                    .addConstraintViolation();
            return false;

        } else if (compCode == null || compCode.equals("")) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Company code must be present")
                    .addBeanNode()
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
