package de.adesso.exercise.coronaApp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "favorites")
public class Favorites {

	@Id
	private String id;
	
	private ArrayList<String> favoritesList;

	public Favorites(ArrayList<String> favoritesList) {
		super();
		this.favoritesList = favoritesList;
	}	
}
