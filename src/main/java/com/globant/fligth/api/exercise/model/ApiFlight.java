package com.globant.fligth.api.exercise.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * A class that represents the external representation of a flight
 * in the external API.  Flights are converted to ApiFlight objects 
 * before being returned by our API functions.  This allows us to
 * have different representations for our flight objects for
 * external consumption.  
 * 
 * (Created because the API response specified in the requirements 
 *  does not match the API from the mock url).
 *
 */
public class ApiFlight {
	private String from;
	private String to;
	private String flight_number;
	private Date departure_datetime;
	private String gate;
	
	public ApiFlight() {}

	/**
	 * Constructor to translate a Flight into an ApiFlight object
	 * @param f The original Flight object
	 */
	public ApiFlight(Flight f) {
		this.from = f.getDepartureCity();
		this.to   = f.getDestinationCity();
		this.flight_number = f.getFlightNumber();
		this.departure_datetime = f.getDepartureDateTime();
		this.gate = f.getGate();
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public Date getDeparture_datetime() {
		return departure_datetime;
	}

	public void setDeparture_datetime(Date departure_datetime) {
		this.departure_datetime = departure_datetime;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}
	
	
	
	
}
