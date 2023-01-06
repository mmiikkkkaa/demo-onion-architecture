package com.example.architecturedemo.healthypizza.domain.model.pizza.validation;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Pizza;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllergenValidator implements
        ConstraintValidator<AllergenFree, Pizza> {

    @Override
    public void initialize(AllergenFree constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Pizza pizza, ConstraintValidatorContext context) {
        if (pizza.getBase().getAllergens().stream().anyMatch(allergen -> pizza.getAllergensToAvoid().contains(allergen))) {
            return false;
        }

        return pizza.getToppings().stream()
                .map(Topping::getAllergens)
                .flatMap(Collection::stream)
                .anyMatch(allergen -> pizza.getAllergensToAvoid().contains(allergen));
    }
}
