package de.adesso.exercise.coronaApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.adesso.exercise.coronaApp.entity.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, Integer>{
	
	
}
