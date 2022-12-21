package com.example.architecturedemo.healthypizza.domain.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Allergen;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;

@Service
public class ToppingAllergenFilterService {

    public Set<Topping> filterByAllergens(Set<Topping> toppings, Set<Allergen> allergensToAvoid) {
        return toppings.stream()
                .filter(topping -> topping.getAllergens().stream().noneMatch(allergensToAvoid::contains))
                .collect(Collectors.toSet());

    }
}
