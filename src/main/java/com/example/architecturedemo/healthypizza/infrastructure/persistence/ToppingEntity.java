package com.example.architecturedemo.healthypizza.infrastructure.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TOPPINGS")
public class ToppingEntity {

    @Id
    private String name;

    private BigDecimal price;

    @OneToMany(mappedBy = "name")
    private List<PreferenceEntity> preferences;

    private boolean isAvailable;
}
