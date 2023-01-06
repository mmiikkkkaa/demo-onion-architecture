package com.example.architecturedemo.healthypizza.infrastructure.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PREFERENCE")
public class PreferenceEntity {

    @Id
    private String name;

}
