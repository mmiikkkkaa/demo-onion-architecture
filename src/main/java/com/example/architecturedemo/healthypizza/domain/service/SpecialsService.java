package com.example.architecturedemo.healthypizza.domain.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Allergen;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;

@Service
public class SpecialsService {

    public List<Topping> filterByPreferences(Set<Topping> toppings, Set<Allergen> allergens) {
        return toppings.stream()
                .filter(topping -> topping.getAllergens().containsAll(allergens))
                .collect(Collectors.toList());

    }
}
