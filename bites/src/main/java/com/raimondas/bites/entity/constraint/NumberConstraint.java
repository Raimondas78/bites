package com.raimondas.bites.entity.constraint;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonalCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberConstraint {

    String message() default "Invalid personal code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};


}
