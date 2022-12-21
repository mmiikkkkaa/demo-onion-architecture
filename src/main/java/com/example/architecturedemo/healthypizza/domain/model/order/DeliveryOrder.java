package com.example.architecturedemo.healthypizza.domain.model.order;

import java.util.List;

import com.example.architecturedemo.healthypizza.domain.model.pizza.Pizza;
import com.example.architecturedemo.healthypizza.domain.model.address.Address;
import com.example.architecturedemo.healthypizza.domain.model.customer.CustomerName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeliveryOrder extends Order {
    Address address;

    @Builder
    public DeliveryOrder(CustomerName customerName, List<Pizza> pizzas, Address address) {
        super(customerName, pizzas);
        this.address = address;
    }
}
