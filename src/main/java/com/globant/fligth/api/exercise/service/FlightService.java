package com.globant.fligth.api.exercise.service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.globant.fligth.api.exercise.model.Flight;

/**
 * Represents a service that obtains and filters all known flights.
 * This is a mock service that gets the flight information from the
 * mock API.  In production, we might create an IFlightService interface
 * that could be implemented by both this mock class and a production
 * class that reads the requested data from a database.
 *
 */
public class FlightService {
	private static List<Flight> allFlights;
	private static String flightUrl = "http://demo3998236.mockable.io/flights";

	/**
	 * Loads all flights from mock flight API
	 */
	public static void loadFlights() {
    	RestTemplate template = new RestTemplate();
    	ResponseEntity<List<Flight>> flightResponse = template.exchange(flightUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>(){});
    	allFlights = flightResponse.getBody();
	}

	/* Predicates for filtering on various fields */
	static Predicate<Flight> airlineCodeMatch(String airlineCode){
		return f -> airlineCode == null || f.getAirlineCode().equals(airlineCode);
	}
	static Predicate<Flight> dateMatch(Date date) {
		return f -> date == null || DateUtils.isSameDay(f.getDepartureDateTime(), date);
	}

	public static List<Flight> getAllFlights() {
		return allFlights;
	}

	/**
	 * Returns all flights that match the given filters
	 * @param airlineCode Flight airline code
	 * @param departureDate Flight departure date
	 * @return flights that match
	 */
	public static List<Flight> getFilteredFlights(String airlineCode, Date departureDate) {
		return allFlights.stream()
				.filter(airlineCodeMatch(airlineCode))
				.filter(dateMatch(departureDate))
				.collect(Collectors.toList());
	}
	
}
