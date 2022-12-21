package com.example.architecturedemo.healthypizza.domain.model.customer;

import lombok.Value;

@Value(staticConstructor = "of")
public class CustomerName {
    String value;
}
