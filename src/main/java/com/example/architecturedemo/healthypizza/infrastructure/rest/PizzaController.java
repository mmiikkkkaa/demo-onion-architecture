package com.example.architecturedemo.healthypizza.infrastructure.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.architecturedemo.healthypizza.application.order.usecases.OrderUseCase;
import com.example.architecturedemo.healthypizza.domain.model.customer.CustomerName;
import com.example.architecturedemo.healthypizza.domain.model.order.Order;
import lombok.val;

@RestController
@RequestMapping("pizza")
public class PizzaController {

    @Autowired
    private OrderUseCase orderUseCase;

    @Autowired
    private PizzaRequestMapper pizzaRequestMapper;

    @Autowired
    private AddressMapper addressMapper;

    @PostMapping("/order/delivery")
    public Order orderPizzaForDelivery(@Valid PizzaOrderDto pizzaOrderDto) {
        val pizzaRequests = pizzaRequestMapper.toDomain(pizzaOrderDto.pizzas);
        val customerName = CustomerName.of(pizzaOrderDto.customerName);
        val address = addressMapper.toDomain(pizzaOrderDto.address);


        return orderUseCase.createDeliveryOrder(pizzaRequests, customerName, address);
    }


    @PostMapping("/order/pickup")
    public Order orderPizzaForPickup(@Valid PizzaOrderDto pizzaOrderDto) {
        val pizzaRequests = pizzaRequestMapper.toDomain(pizzaOrderDto.pizzas);
        val customerName = CustomerName.of(pizzaOrderDto.customerName);

        return orderUseCase.createPickupOrder(pizzaRequests, customerName);
    }
}
