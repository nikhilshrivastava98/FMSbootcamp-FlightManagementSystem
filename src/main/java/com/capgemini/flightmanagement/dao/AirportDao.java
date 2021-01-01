package com.capgemini.flightmanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.flightmanagement.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String> {

}