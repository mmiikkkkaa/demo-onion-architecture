package com.example.architecturedemo.healthypizza.application.order.usecases;

import java.util.List;
import java.util.Set;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Allergen;
import com.example.architecturedemo.healthypizza.domain.model.pizza.PizzaBase;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Specials;
import com.example.architecturedemo.healthypizza.domain.model.pizza.ToppingName;
import lombok.Builder;

@Builder
public class  PizzaRequest {
    PizzaBase base;
    List<ToppingName> toppings;
    Set<Allergen> allergensToAvoid;
    Set<Specials> specials;
}
