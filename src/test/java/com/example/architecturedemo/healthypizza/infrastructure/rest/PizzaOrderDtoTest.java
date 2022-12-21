package com.example.architecturedemo.healthypizza.infrastructure.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.val;

class PizzaOrderDtoTest {

    @Test
    void print() throws JsonProcessingException {
        // given

        @NotBlank String name = "Batman";
        PizzaRequestDto pizzaRequestDto = new PizzaRequestDto(Arrays.asList("Tomato", "Garlic", "Pineapple"));
        pizzaRequestDto.setBase("GLUTEN_FREE");
        pizzaRequestDto.setAllergensToAvoid(Arrays.asList("GLUTEN", "NUTS"));
        pizzaRequestDto.setSpecials(Arrays.asList("WITHOUT_CRUST", "CUT"));
        @NotEmpty List<PizzaRequestDto> pizzas = Arrays.asList(pizzaRequestDto);


        final val pizzaOrderDto = new PizzaOrderDto(pizzas, name);
        // when
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String actualJson = objectWriter.writeValueAsString(pizzaOrderDto);

        // then
        System.out.println(actualJson);
    }

}