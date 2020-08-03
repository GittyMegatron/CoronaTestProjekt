package de.adesso.exercise.coronaApp.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "country")
public class Country {

	@Id
	private String id;
	
	private int newConfirmed;
	private int	totalConfirmed;
	private int	newDeaths;
	private int	totalDeaths;
	private int	newRecovered;
	private int	totalRecovered;
	private String	name;
	private Date	date;
	
//	public Country() {
//	}
//
//	public Country(int newConfirmed, int totalConfirmed, int newDeaths, int totalDeaths, int newRecovered,
//			int totalRecovered, String name, Date date) {
//		super();
//		this.newConfirmed = newConfirmed;
//		this.totalConfirmed = totalConfirmed;
//		this.newDeaths = newDeaths;
//		this.totalDeaths = totalDeaths;
//		this.newRecovered = newRecovered;
//		this.totalRecovered = totalRecovered;
//		this.name = name;
//		this.date = date;
//	}
//
	public int getNewConfirmed() {
		return newConfirmed;
	}
	
	@JsonSetter("NewConfirmed")
	public void setNewConfirmed(int newConfirmed) {
		this.newConfirmed = newConfirmed;
	}

	public int getTotalConfirmed() {
		return totalConfirmed;
	}

	@JsonSetter("TotalConfirmed")
	public void setTotalConfirmed(int totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}

	public int getNewDeaths() {
		return newDeaths;
	}

	@JsonSetter("NewDeaths")
	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	@JsonSetter("TotalDeaths")
	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public int getNewRecovered() {
		return newRecovered;
	}

	@JsonSetter("NewRecovered")
	public void setNewRecovered(int newRecovered) {
		this.newRecovered = newRecovered;
	}

	public int getTotalRecovered() {
		return totalRecovered;
	}

	@JsonSetter("TotalRecovered")
	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getName() {
		return name;
	}

	@JsonSetter("Country")
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	@JsonSetter("Date")
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ",totalConfirmed=" + totalConfirmed + ", name=" + name + ", date=" + date + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
