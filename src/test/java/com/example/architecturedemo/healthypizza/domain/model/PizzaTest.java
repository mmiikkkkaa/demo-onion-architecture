package com.example.architecturedemo.healthypizza.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.example.architecturedemo.healthypizza.domain.model.money.Amount;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Pizza;
import com.example.architecturedemo.healthypizza.domain.model.pizza.PizzaBase;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;
import com.example.architecturedemo.healthypizza.domain.model.pizza.ToppingName;
import lombok.val;

class PizzaTest {
    @Test
    void shouldCalculatePriceWithoutToppings() {
        // given
        val pizza = Pizza.builder()
                .base(PizzaBase.STANDARD)
                .toppings(Collections.emptyList())
                .build();

        // when
        val price = pizza.getPrice();

        // then
        assertThat(price).isEqualTo(Amount.of(BigDecimal.valueOf(3)));
    }

    @Test
    void shouldCalculatePrice() {
        // given
        val toppings = Arrays.asList(
                Topping.builder().name(ToppingName.of("Tomato")).price(Amount.of(BigDecimal.valueOf(1.50))).build(),
                Topping.builder().name(ToppingName.of("Pineapple")).price(Amount.of(BigDecimal.valueOf(2.50))).build(),
                Topping.builder().name(ToppingName.of("Teriyaki Sauce")).price(Amount.of(BigDecimal.valueOf(1.00))).build(),
                Topping.builder().name(ToppingName.of("Garlic")).price(Amount.of(BigDecimal.valueOf(0.50))).build()
        );
        val pizza = Pizza.builder()
                .base(PizzaBase.STANDARD)
                .toppings(toppings)
                .build();

        // when
        val price = pizza.getPrice();

        // then
        assertThat(price).isEqualTo(Amount.of(BigDecimal.valueOf(8.5)));

    }
}