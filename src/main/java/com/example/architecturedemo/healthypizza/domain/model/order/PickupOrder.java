package com.example.architecturedemo.healthypizza.domain.model.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Pizza;
import com.example.architecturedemo.healthypizza.domain.model.customer.CustomerName;
import com.example.architecturedemo.healthypizza.domain.model.money.Amount;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PickupOrder extends Order {

    // 20% off for pickup orders
    public static final BigDecimal PICKUP_DISCOUNT = BigDecimal.valueOf(0.2);

    @Builder
    public PickupOrder(CustomerName customerName, List<Pizza> pizzas) {
        super(customerName, pizzas);
    }

    @Override
    public Amount getPrice() {
        return Amount.of(super.getPrice().getValue().multiply(BigDecimal.ONE.subtract(PICKUP_DISCOUNT)).setScale(2, RoundingMode.HALF_DOWN));
    }
}
