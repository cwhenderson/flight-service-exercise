package com.globant.fligth.api.exercise.model;

public class City {
	private String name;
	private String iataCode;
	
	public City (String name, String iataCode) {
		this.name = name;
		this.iataCode = iataCode;
	}
	
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
