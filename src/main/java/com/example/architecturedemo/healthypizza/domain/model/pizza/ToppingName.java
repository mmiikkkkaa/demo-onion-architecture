package com.example.architecturedemo.healthypizza.domain.model.pizza;

import lombok.Value;

@Value(staticConstructor = "of")
public class ToppingName {
    String value;
}
