package com.capgemini.flightmanagement.controller;

import java.math.BigInteger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.flightmanagement.entity.Airport;
import com.capgemini.flightmanagement.exceptions.RecordAlreadyPresentException;
import com.capgemini.flightmanagement.exceptions.RecordNotFoundException;
import com.capgemini.flightmanagement.service.AirportService;
@CrossOrigin("http://localhost:8086")
@RestController
public class AirportController {
	@Autowired(required = true)
	AirportService airportService;

	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("id") BigInteger airportCode) {
		return airportService.viewAirport(airportCode);
	}

	@GetMapping("/allAirport")
	public Iterable<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}
	
	@PostMapping("/addAirport")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addAirport(@RequestBody Airport airport) 
	{
		airportService.addAirport(airport);
	}
	
	@PutMapping("/updateAirport/{Airportcode}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Airport> updateairport(@PathVariable BigInteger airportcode,@RequestBody Airport airport)
	{
		Airport updateAirport = airportService.modifyAirport(airport);
		return ResponseEntity.ok(updateAirport);
	}

	@DeleteMapping("/deleteAirport/{id}")
	//@ExceptionHandler(RecordNotFoundException.class)
	public void removeAirport(@PathVariable("id") BigInteger airportCode) {
		airportService.removeAirport(airportCode);
	}
}