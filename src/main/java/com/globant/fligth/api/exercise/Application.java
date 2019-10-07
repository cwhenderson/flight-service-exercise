package com.globant.fligth.api.exercise;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.globant.fligth.api.exercise.model.Flight;
import com.globant.fligth.api.exercise.service.FlightService;

@SpringBootApplication
public class Application {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
    private void init() {
    	LOGGER.info("init");

    	// Get flights from mock API.
    	// In production, these might instead be stored in a DB
    	// and our services would gather data from it instead;
    	FlightService.loadFlights();
    }
}
