package com.example.architecturedemo.healthypizza.domain.model.pizza;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CrustChoicesValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NonConflictingCrustChoices {
    String message() default "Conflicting crust choices";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
