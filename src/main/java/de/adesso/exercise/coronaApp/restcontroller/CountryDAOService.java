package de.adesso.exercise.coronaApp.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import de.adesso.exercise.coronaApp.entity.Country;
import de.adesso.exercise.coronaApp.entity.Favorites;
import de.adesso.exercise.coronaApp.repository.CountryRepository;
import de.adesso.exercise.coronaApp.repository.FavoriteRepository;

@Service
public class CountryDAOService {
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	FavoriteRepository favoriteRepository;

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
		return favoriteRepository.findAll().get(0).getFavoritesList();
	}

	public void saveFavorite(String name) {
		if (favoriteRepository.findAll() != null) {
			favoriteRepository.insert(new Favorites(new ArrayList<String>()));
		}
		
		Favorites favorite = favoriteRepository.findAll().get(0);
		
		favorite.getFavoritesList().add(name);
		favoriteRepository.save(favorite);
		
	}

	public void deleteFavoriteByName(String name) {
		Favorites favorite = favoriteRepository.findAll().get(0);
		
		favorite.getFavoritesList().remove(name);
		favoriteRepository.save(favorite);
		
	}

}
