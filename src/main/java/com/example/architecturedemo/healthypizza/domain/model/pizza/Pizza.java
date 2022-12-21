package com.example.architecturedemo.healthypizza.domain.model.pizza;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.architecturedemo.healthypizza.domain.model.money.Amount;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllergenFree
public class Pizza {

    private static BigDecimal basePrice = BigDecimal.valueOf(3);

    @NotNull
    @Builder.Default
    PizzaBase base = PizzaBase.STANDARD;

    @NotEmpty
    List<Topping> toppings;

    @NotNull
    @Builder.Default
    @NonConflictingCrustChoices
    Set<Specials> specials = Collections.emptySet();

    @NotNull
    @Builder.Default
    Set<Allergen> allergensToAvoid = Collections.emptySet();

    public Amount getPrice() {
        return Amount.of(basePrice.add(toppings.stream().map(it -> it.getPrice().getValue()).reduce(BigDecimal.ZERO, BigDecimal::add)));
    }
}
