package com.example.architecturedemo.healthypizza.application.pizza;

import java.util.Set;
import java.util.stream.Collectors;

import com.example.architecturedemo.healthypizza.domain.model.pizza.ToppingName;

public class ToppingsNotAvailableException extends RuntimeException {

    public ToppingsNotAvailableException(Set<ToppingName> toppings) {
        super("Following Topping(s) are currently unavailable: " +
                toppings.stream()
                        .map(ToppingName::getValue)
                        .collect(Collectors.joining(", ")));
    }
}
