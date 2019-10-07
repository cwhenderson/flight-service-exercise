package com.globant.fligth.api.exercise;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globant.fligth.api.exercise.controller.FlightController;
import com.globant.fligth.api.exercise.model.ApiFlight;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightController.class)
public class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void testAllFlights() throws Exception {
		List<ApiFlight> flights = getFlightsFromUrl("/api/flights");
		
		Assert.assertEquals(5, flights.size());
	}

	@Test
	public void testAirlineCodeFilter() throws Exception {
		List<ApiFlight> flights = getFlightsFromUrl("/api/flights?airlineCode=AA");
		
		Assert.assertEquals(2, flights.size());
	}

	@Test
	public void testDateFilter() throws Exception {
		List<ApiFlight> flights = getFlightsFromUrl("/api/flights?departureDate=10/15/2019");
		
		Assert.assertEquals(2, flights.size());
	}

	@Test
	public void testAirlineCodeAndDateFilter() throws Exception {
		List<ApiFlight> flights = getFlightsFromUrl("/api/flights?airlineCode=AA&departureDate=10/17/2019");
		
		Assert.assertEquals(1, flights.size());
	}
	
	public List<ApiFlight> getFlightsFromUrl(String url) throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_UTF8_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String json = result.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		List<ApiFlight> flights = Arrays.asList(mapper.readValue(json, ApiFlight[].class));
		
		return flights;
	}
	
}
