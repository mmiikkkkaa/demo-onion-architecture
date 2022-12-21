package com.example.architecturedemo.healthypizza.domain.model.customer;

import javax.validation.constraints.NotNull;

import com.example.architecturedemo.healthypizza.domain.model.address.Address;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Customer {
    @NotNull
    CustomerId customerId;
    @NonNull
    CustomerName customerName;
    @NotNull
    Address address;
}
