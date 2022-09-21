package com.spring.mongodb.service.impl;

import com.spring.mongodb.model.SuperHero;
import com.spring.mongodb.repository.SuperHeroRepository;
import com.spring.mongodb.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

    @Override
    public SuperHero findById(String id) {
        return repository.findById(id).orElse(new SuperHero());
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public void delete(String id) {
       repository.findById(id).ifPresent(superHero -> repository.delete(superHero));
    }
}
