package com.example.architecturedemo.healthypizza.infrastructure.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.architecturedemo.healthypizza.application.order.usecases.PizzaRequest;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Allergen;
import com.example.architecturedemo.healthypizza.domain.model.pizza.PizzaBase;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Specials;
import com.example.architecturedemo.healthypizza.domain.model.pizza.ToppingName;

@Component
public class PizzaRequestMapper {

    public List<PizzaRequest> toDomain(List<PizzaRequestDto> dtos) {
        return dtos.stream().map(this::toDomain).collect(Collectors.toList());
    }

    public PizzaRequest toDomain(PizzaRequestDto dto) {
        return PizzaRequest.builder()
                .base(PizzaBase.valueOf(dto.base))
                .toppings(dto.toppings.stream().map(ToppingName::of).collect(Collectors.toList()))
                .allergensToAvoid(dto.allergensToAvoid.stream().map(Allergen::valueOf).collect(Collectors.toSet()))
                .specials(dto.specials.stream().map(Specials::valueOf).collect(Collectors.toSet()))
                .build();

    }
}
