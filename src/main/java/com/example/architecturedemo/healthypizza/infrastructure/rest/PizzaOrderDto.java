package com.example.architecturedemo.healthypizza.infrastructure.rest;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class PizzaOrderDto {
    @NotEmpty
    final List<PizzaRequestDto> pizzas;

    @NotBlank
    final String customerName;

    AddressDto address;
}
