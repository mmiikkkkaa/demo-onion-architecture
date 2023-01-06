package com.example.architecturedemo.healthypizza.infrastructure.persistence;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.architecturedemo.healthypizza.domain.model.money.Amount;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Allergen;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Availability;
import com.example.architecturedemo.healthypizza.domain.model.pizza.Topping;
import com.example.architecturedemo.healthypizza.domain.model.pizza.ToppingName;

@Component
public class ToppingsMapper {

    public Topping toDomain(ToppingEntity entity) {
        return Topping.builder()
                .name(ToppingName.of(entity.getName()))
                .price(Amount.of(entity.getPrice()))
                .allergens(entity.getPreferences().stream().map(it -> Allergen.valueOf(it.getName())).collect(Collectors.toSet()))
                .availability(entity.isAvailable() ? Availability.IN_STOCK : Availability.OUT_OF_STOCK)
                .build();
    }


    public ToppingEntity toEntity(Topping domain) {
        return new ToppingEntity(
                domain.getName().getValue(),
                domain.getPrice().getValue(),
                domain.getAllergens().stream()
                        .map(Enum::name)
                        .map(PreferenceEntity::new)
                        .collect(Collectors.toList()),
                domain.getAvailability() == Availability.IN_STOCK
        );
    }
}
