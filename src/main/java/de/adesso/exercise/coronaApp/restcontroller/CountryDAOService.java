package de.adesso.exercise.coronaApp.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.adesso.exercise.coronaApp.entity.Country;
import de.adesso.exercise.coronaApp.repository.CountryRepository;

@Service
public class CountryDAOService {
	
	@Autowired
	CountryRepository countryRepository;

	public Optional<Country> findCountryInfos(String name) {
		List<Country> listOfAllCountries = new ArrayList<Country>(countryRepository.findAll());
		for (Country country : listOfAllCountries) {
			if (country.getName().equals(name)) {
				return Optional.of(country);
			}
		}
		return Optional.of(null);
	}

	public List<Country> findAllCountryInfos() {
		return countryRepository.findAll();
	}

	public List<String> findAllFavorites() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveFavorite(String name) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFavoriteByName(String name) {
		// TODO Auto-generated method stub
		
	}

}
