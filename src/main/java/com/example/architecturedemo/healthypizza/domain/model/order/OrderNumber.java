package com.example.architecturedemo.healthypizza.domain.model.order;

import lombok.Value;

@Value(staticConstructor = "of")
public class OrderNumber {
    String value;
}
