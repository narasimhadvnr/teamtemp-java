package com.venkat.teamtemp.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.RatingLink;
import com.venkat.teamtemp.model.Team;
import com.venkat.teamtemp.model.TeamInstance;
import com.venkat.teamtemp.repository.RatingLinkRepository;
import com.venkat.teamtemp.repository.TeamInstanceRepository;
import com.venkat.teamtemp.repository.TeamRepository;
import com.venkat.teamtemp.util.RandomString;

@RestController
@RequestMapping("/team/")
public class TeamInstanceController {
	
	RandomString string;
	
	private final static long TWO_WEEKS = (1000 * 60*60 *24) * 14;
	
	@Autowired
	private TeamInstanceRepository repository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	@Autowired
	private RatingLinkRepository ratingLinkRepository;
	
	@GetMapping
	public Iterable<TeamInstance> getLinkRatings() {
		return repository.findAll();
	}
	
	
	public TeamInstanceController() {
		// TODO Auto-generated constructor stub
		string = new RandomString(10);

	}
	
	@PostMapping("/{teamId}/link")
	public boolean createRatingLink( @PathVariable("teamId") long teamId ) {
		
		Optional<Team> team = teamRepository.findById(teamId);
		
		if(team.isPresent()) {
			
			
			// TODO find any team instance is still valid and create if not exists
			
			TeamInstance instance = new TeamInstance();
			instance.setTeam(team.get());
			repository.save(instance);
			
			RatingLink link = new RatingLink();
			
			link.setStatus("active");
			link.setLink(string.nextString());
			link.setValidFrom(new Date().getTime());
			link.setValidTill(link.getValidFrom() + TWO_WEEKS);
			link.setTeamInstance(instance);
			
			ratingLinkRepository.save(link);
			
			instance.setLinkValue(link);
			repository.save(instance);
			
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/{teamId}/link")
	public boolean getRatingData( @PathVariable("teamId") long teamId ) {
		
		Optional<Team> team = teamRepository.findById(teamId);
		
		if(team.isPresent()) {
			Team item = team.get();
			//TODO RETURN LINK DETAILS
			return true;
		}else {
			return false;
		}
	}
}
