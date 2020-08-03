package de.adesso.exercise.coronaApp.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	
	private String name;
	
	private Set<String> favorites;
}
