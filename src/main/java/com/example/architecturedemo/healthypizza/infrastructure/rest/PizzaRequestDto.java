package com.example.architecturedemo.healthypizza.infrastructure.rest;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PizzaRequestDto {

    String base = "STANDARD";

    @NotNull
    @NotEmpty
    final List<String> toppings;

    List<String> specials;

    List<String> allergensToAvoid;
}
