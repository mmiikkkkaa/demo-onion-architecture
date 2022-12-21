package com.example.architecturedemo.healthypizza.application.order.usecases;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.architecturedemo.healthypizza.application.pizza.ToppingService;
import com.example.architecturedemo.healthypizza.application.pizza.ToppingsNotAvailableException;
import com.example.architecturedemo.healthypizza.domain.model.address.Address;
import com.example.architecturedemo.healthypizza.domain.model.customer.CustomerName;
import com.example.architecturedemo.healthypizza.domain.model.order.DeliveryOrder;
import com.example.architecturedemo.healthypizza.domain.model.order.Order;
import com.example.architecturedemo.healthypizza.domain.model.order.PickupOrder;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;
import lombok.val;

@Component
public class OrderUseCase {

    @Autowired
    private ToppingService toppingService;

    @Autowired
    private RequestToPizzaMapper requestToPizzaMapper;

    public Order createDeliveryOrder(List<PizzaRequest> pizzaRequests, CustomerName customerName, Address address) {
        val availableToppings = toppingService.getAvailableToppings();
        validateToppingAvailability(pizzaRequests, availableToppings);

        return DeliveryOrder.builder()
                .pizzas(requestToPizzaMapper.toPizza(pizzaRequests, availableToppings))
                .customerName(customerName)
                .address(address)
                .build();
    }

    public Order createPickupOrder(List<PizzaRequest> pizzaRequests, CustomerName customerName) {
        val availableToppings = toppingService.getAvailableToppings();
        validateToppingAvailability(pizzaRequests, availableToppings);

        return PickupOrder.builder()
                .pizzas(requestToPizzaMapper.toPizza(pizzaRequests, availableToppings))
                .customerName(customerName)
                .build();
    }
    private void validateToppingAvailability(List<PizzaRequest> pizzaRequests, Set<Topping> availableToppings) {
        val requestedToppingNames = pizzaRequests.stream().map(it -> it.toppings).flatMap(Collection::stream).collect(Collectors.toSet());
        val availableToppingNames = availableToppings.stream().map(Topping::getName).collect(Collectors.toSet());
        val notAvailableToppingNames = requestedToppingNames.stream().filter(topping -> !availableToppingNames.contains(topping)).collect(Collectors.toSet());

        if (!notAvailableToppingNames.isEmpty()) {
            throw new ToppingsNotAvailableException(notAvailableToppingNames);
        }
    }
}
