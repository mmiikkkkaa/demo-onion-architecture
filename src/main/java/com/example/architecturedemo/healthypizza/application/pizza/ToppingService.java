package com.example.architecturedemo.healthypizza.application.pizza;

import java.util.Set;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;

public interface ToppingService {

    Set<Topping> getToppings();

    Set<Topping> getAvailableToppings();

}
