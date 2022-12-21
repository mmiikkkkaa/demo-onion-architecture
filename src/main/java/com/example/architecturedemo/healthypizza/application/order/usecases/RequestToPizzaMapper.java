package com.example.architecturedemo.healthypizza.application.order.usecases;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Pizza;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;

@Component
public class RequestToPizzaMapper {

    public List<Pizza> toPizza(List<PizzaRequest> pizzaRequests, Set<Topping> availableToppings) {
        return pizzaRequests.stream()
                .map(pizzaRequest -> toPizza(pizzaRequest, availableToppings))
                .collect(Collectors.toList());
    }

    public Pizza toPizza(PizzaRequest pizzaRequest, Set<Topping> availableToppings) {
        return Pizza.builder()
                .base(pizzaRequest.base)
                .toppings(mapToppings(pizzaRequest, availableToppings))
                .specials(pizzaRequest.specials)
                .allergensToAvoid(pizzaRequest.allergensToAvoid)
                .build();
    }

    private static List<Topping> mapToppings(PizzaRequest pizzaRequest, Set<Topping> toppings) {
        return pizzaRequest.toppings.stream().map(it -> toppings.stream()
                        .filter(topping -> topping.getName().equals(it))
                        .findFirst()
                        .orElseThrow(IllegalStateException::new))
                .collect(Collectors.toList());
    }
}
