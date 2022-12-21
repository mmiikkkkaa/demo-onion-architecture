package com.example.architecturedemo.healthypizza.domain.model.pizza;

import java.util.Set;

import com.example.architecturedemo.healthypizza.domain.model.money.Amount;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Topping {
    ToppingName name;
    Set<Allergen> allergens;
    Amount price;
    Availability availability;
}
