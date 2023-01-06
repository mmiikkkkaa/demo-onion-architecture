package com.example.architecturedemo.healthypizza.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepo extends CrudRepository<ToppingEntity, String> {
}
