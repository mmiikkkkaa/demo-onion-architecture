package com.example.architecturedemo.healthypizza.domain.model.address;

import lombok.Value;

@Value(staticConstructor = "of")
public class Street {
    String value;
}
