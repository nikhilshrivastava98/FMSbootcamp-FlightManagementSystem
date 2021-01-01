package com.capgemini.flightmanagement.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.flightmanagement.entity.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String airportCode);

	public ResponseEntity<?> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(String airportCode);
}