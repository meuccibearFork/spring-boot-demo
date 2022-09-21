package com.spring.mongodb.service;

import com.spring.mongodb.model.SuperHero;

import java.util.List;

public interface SuperHeroService {

    List<?> findAll();

    SuperHero findById(String id);

    SuperHero save(SuperHero superHero);

    SuperHero update(SuperHero superHero);

    void delete(String id);
}
