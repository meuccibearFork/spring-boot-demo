package com.spring.mongodb.repository;

import com.spring.mongodb.model.SuperHero;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SuperHeroRepository extends MongoRepository<SuperHero, String> {

}
