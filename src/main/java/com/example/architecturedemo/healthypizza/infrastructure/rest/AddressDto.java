package com.example.architecturedemo.healthypizza.infrastructure.rest;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddressDto {
    @NotNull
    String name;
    @NotNull
    String city;
    @NotNull
    String street;
    @NotNull
    String zip;
}
