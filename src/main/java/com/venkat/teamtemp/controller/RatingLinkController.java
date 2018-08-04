package com.venkat.teamtemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.RatingLink;
import com.venkat.teamtemp.repository.RatingLinkRepository;
import java.util.List;

@RestController
@RequestMapping("/teams/{teamId}/ratingLink")
public class RatingLinkController {

	
	@Autowired
	RatingLinkRepository repository;

	
	@PostMapping
	public boolean saveRating(@RequestBody RatingLink rating) {
		
		repository.save(rating);
		return true;
	}


	@GetMapping
	public List<RatingLink> getAllRatingLinks(){
		return repository.findAll();
	}


	// @GetMapping("/rating/{linkName}")
	// public List<RatingLink> getRating( @PathVariable("linkName") String linkName){
	// 	return repository.findB
	// }

	
}
