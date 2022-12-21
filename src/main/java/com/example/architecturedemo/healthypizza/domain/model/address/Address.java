package com.example.architecturedemo.healthypizza.domain.model.address;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Address {
    @NotNull
    Street street;
    @NotNull
    City city;
    @NotNull
    ZipCode zipCode;
}
