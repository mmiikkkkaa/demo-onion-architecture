package com.example.architecturedemo.healthypizza.infrastructure.persistence;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.architecturedemo.healthypizza.application.pizza.ToppingService;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;

@Service
public class JpaToppingService implements ToppingService {

    @Autowired
    private ToppingRepo toppingRepo;

    @Autowired
    private ToppingsMapper toppingsMapper;

    @Override
    public Set<Topping> getToppings() {
        return StreamSupport.stream(toppingRepo.findAll().spliterator(), true)
                .map(toppingsMapper::toDomain)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Topping> getAvailableToppings() {
        return StreamSupport.stream(toppingRepo.findAll().spliterator(), true)
                .map(toppingsMapper::toDomain)
                .collect(Collectors.toSet());
    }
}
