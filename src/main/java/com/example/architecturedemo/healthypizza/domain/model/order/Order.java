package com.example.architecturedemo.healthypizza.domain.model.order;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Pizza;
import com.example.architecturedemo.healthypizza.domain.model.customer.CustomerName;
import com.example.architecturedemo.healthypizza.domain.model.money.Amount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Accessors(fluent = true)
public abstract class Order {


    protected OrderNumber orderNumber;

    @NotNull
    protected final CustomerName customerName;

    @NotNull
    protected final List<Pizza> pizzas;

    public Amount getPrice() {
        return Amount.of(pizzas.stream().map(Pizza::getPrice).map(Amount::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
