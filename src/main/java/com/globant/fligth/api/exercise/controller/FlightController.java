package com.globant.fligth.api.exercise.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Request;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.fligth.api.exercise.model.ApiFlight;
import com.globant.fligth.api.exercise.model.Flight;
import com.globant.fligth.api.exercise.service.FlightService;

@RestController
@RequestMapping(path = "/api/", produces = APPLICATION_JSON_UTF8_VALUE)
public class FlightController {
	
	private static final String datePattern = "MM/dd/yyyy";

	/**
	 * Returns list of flights in the external representation of ApiFlight.
	 * Filterable by airline code and departure date
	 * @param airlineCode
	 * @param departureDate
	 * @return
	 */
	@GetMapping(path="/flights")
	public List<ApiFlight> getFlights(
			@RequestParam(required = false) String airlineCode,
			@RequestParam(required = false) @DateTimeFormat(pattern = datePattern) Date departureDate){
		
		// Get filtered list of flights from flight service
		List<Flight> flights = FlightService.getFilteredFlights(airlineCode, departureDate);
		
		// Convert to list of ApiFlight for external API representation
		return flights.stream().map(f -> new ApiFlight(f)).collect(Collectors.toList());

	}
}
