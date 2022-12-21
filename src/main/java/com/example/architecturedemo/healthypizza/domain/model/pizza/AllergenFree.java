package com.example.architecturedemo.healthypizza.domain.model.pizza;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = AllergenValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AllergenFree {
    String message() default "Ingredients conflict with to-avoid allergens";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
