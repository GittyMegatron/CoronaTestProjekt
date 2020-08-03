package de.adesso.exercise.coronaApp.coronaInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.adesso.exercise.coronaApp.entity.Country;
import de.adesso.exercise.coronaApp.repository.CountryRepository;

@Component
public class CoronaRestClient implements CommandLineRunner{

	
	
	private static CountryRepository countryRepository;
	
	@Autowired
	public CoronaRestClient(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	private static void getAsJsonNode(long id) throws IOException {
		
		String URI = "https://api.covid19api.com/summary";
		
		  RestTemplate restTemplate = new RestTemplate();
		
		  String jsonString = restTemplate.getForObject(URI,
		                                                String.class,
		                                                id);
		  ObjectMapper mapper = new ObjectMapper();
		  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  
		  JsonNode jsonNode = mapper.readTree(jsonString);
		  
		  List<JsonNode> listOfCountries = jsonNode.findParents("Country");
		  
		  List<Country> listOfCountryObjects = new ArrayList<Country>();
		  
		  for (JsonNode node: listOfCountries) {
			  listOfCountryObjects.add(mapper.treeToValue(node, Country.class));
		  }
		  
		  if (listOfCountryObjects != null) {
			  countryRepository.deleteAll();
		  }
		  
		  countryRepository.saveAll(listOfCountryObjects);
		  
		  
	}

	@Override
	public void run(String... args) throws Exception {
		getAsJsonNode(0);
		
	}
	

	
	
	

	
}
