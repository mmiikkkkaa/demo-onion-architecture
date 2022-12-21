package com.example.architecturedemo.healthypizza.domain.model.pizza;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public enum PizzaBase {
    STANDARD(Allergen.GLUTEN),
    GLUTEN_FREE();

    private Set<Allergen> allergens;

    PizzaBase(Allergen... allergens) {
        this.allergens = Arrays.stream(allergens).collect(Collectors.toSet());
    }
}
