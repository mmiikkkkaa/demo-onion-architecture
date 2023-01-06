package com.example.architecturedemo.healthypizza.domain.model.pizza.validation;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Specials;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CrustChoicesValidator implements
        ConstraintValidator<NonConflictingCrustChoices, Set<Specials>> {
    @Override
    public void initialize(NonConflictingCrustChoices constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Set<Specials> value, ConstraintValidatorContext context) {
        return !value.contains(Specials.WITHOUT_CRUST) && value.contains(Specials.GARLIC_FILLED_CRUST);
    }
}
