package com.venkat.teamtemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.RatingLink;
import com.venkat.teamtemp.repository.RatingLinkRepository;
import com.venkat.teamtemp.repository.TeamInstanceRepository;

@RestController
@RequestMapping("/rating")
public class RatingLinkController {

	
	@Autowired
	RatingLinkRepository repository;
	
	@PostMapping
	public boolean saveRating(@RequestBody RatingLink rating) {
		
		repository.save(rating);
		return true;
	}
	
}
