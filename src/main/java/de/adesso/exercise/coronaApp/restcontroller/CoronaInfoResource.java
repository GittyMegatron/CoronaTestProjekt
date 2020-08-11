package de.adesso.exercise.coronaApp.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import de.adesso.exercise.coronaApp.entity.Country;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CoronaInfoResource {
	
	@Autowired
	private CountryDAOService service;

	@GetMapping("/countries/{name}")
	public Optional<Country> retrieveCountryInfos(@PathVariable String name) {
		return service.findCountryInfos(name);
	}
	
	@GetMapping("/countries")
	public List<Country> retrieveAllCountryInfos() {
		return service.findAllCountryInfos();
	}
	
	@GetMapping("/countries/fav")
	public List<Country> retrieveFavoriteCountryInfos() {
		return service.findAllCountryInfos();
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/favorites")
	public List<String> retrieveAllFavorites() {
		return service.findAllFavorites();
	}
	
	@PostMapping("/favorites/{name}")
	public void saveFavorite(@PathVariable("name") String name) {
		service.saveFavorite(name);
	}
	
	@DeleteMapping("/favorites/{name}")
	public void deleteFavorite(@PathVariable("name") String name) {
		service.deleteFavoriteByName(name);
		
//		if(user==null) {
//			throw new UserNotFoundException("id-"+ id);
//		}
		
	}
	
}
