package com.raimondas.bites.entity.constraint;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PersonalCodeValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberConstraint {

    String message() default "Invalid values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

    String personalCode();

    String companyCode();

    String companyName();
    // String errorMessage();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        NumberConstraint[] value();
    }
}
