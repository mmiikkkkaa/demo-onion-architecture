package com.example.architecturedemo.healthypizza.infrastructure.rest;

import org.springframework.stereotype.Component;

import com.example.architecturedemo.healthypizza.domain.model.address.Address;
import com.example.architecturedemo.healthypizza.domain.model.address.City;
import com.example.architecturedemo.healthypizza.domain.model.address.Street;
import com.example.architecturedemo.healthypizza.domain.model.address.ZipCode;

@Component
public class AddressMapper {

    public Address toDomain(AddressDto dto) {
        return Address.builder()
                .city(City.of(dto.city))
                .zipCode(ZipCode.of(dto.zip))
                .street(Street.of(dto.street))
                .build();

    }
}
