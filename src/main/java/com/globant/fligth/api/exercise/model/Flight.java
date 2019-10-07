package com.globant.fligth.api.exercise.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents an internal representation of a Flight that we get directly
 * from the FlightService (which here is backed by the mock API).
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {

	private String departureCity;
	private String destinationCity;
	private Date departureDateTime;
	private String flightNumber;
	private String airline;
	private String airlineCode;
	private String gate;
	
	public Flight() {
		
	}
	
	public Flight(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Date getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}

	
}
