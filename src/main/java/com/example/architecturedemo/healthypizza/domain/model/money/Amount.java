package com.example.architecturedemo.healthypizza.domain.model.money;

import java.math.BigDecimal;

import lombok.Value;

@Value(staticConstructor = "of")
public class Amount {
    BigDecimal value;
}
