package com.venkat.teamtemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.Location;
import com.venkat.teamtemp.repository.LocationRepository;
import com.venkat.teamtemp.util.APIError;

@RestController
@RequestMapping("/locations")
public class LocationController {

	
	@Autowired
	private LocationRepository repository;
	
	@GetMapping
	public ResponseEntity<Object> getAllLocations(){
		List<Location>  result=repository.findAll();
		
		if(result.size() ==0) {
			return new ResponseEntity<Object>(new APIError("No data found"), HttpStatus.BAD_REQUEST);
		}else
			return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
}
