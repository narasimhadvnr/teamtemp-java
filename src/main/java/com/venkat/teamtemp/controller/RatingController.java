package com.venkat.teamtemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.InstanceRating;
import com.venkat.teamtemp.model.TeamInstance;
import com.venkat.teamtemp.repository.RatingRepository;
import com.venkat.teamtemp.repository.TeamInstanceRepository;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	
	@Autowired
	private TeamInstanceRepository teamInstanceRepository;
	
	
	@Autowired
	private RatingRepository repository;
	
	boolean linkFound = false;

	@PostMapping("/{ratingLink}")
	public boolean saveRating(@RequestBody InstanceRating rating, @PathVariable("ratingLink") String ratingLink) {
		
		List<TeamInstance> instances = teamInstanceRepository.findAll();
		linkFound = false;
		System.out.println("instances found:"+instances.size());
		instances.iterator().forEachRemaining(instance -> {
			System.out.println(instance.getLinkValue().getLink());
			if(instance.getLinkValue().getLink().equals(ratingLink)) {
				rating.setTeamLink(instance);
				repository.save(rating);
				linkFound = true;
			}
		});
		
		if(linkFound)
			return true;
		
		return false;
		
	}
	
}
