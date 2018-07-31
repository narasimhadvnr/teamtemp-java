package com.venkat.teamtemp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.domain.Team;
import com.venkat.teamtemp.domain.TeamInstance;
import com.venkat.teamtemp.domain.User;
import com.venkat.teamtemp.repository.TeamRepository;

@RestController
@RequestMapping("/team")
public class TeamController {

	
	@Autowired
	private TeamRepository repository;
	
	@PostMapping
	public boolean addTeam(@RequestBody Team team) {
		
		repository.save(team);
		
		return true;
		
	}
	
	@GetMapping
	public Iterable<Team> getUsers(){
		return repository.findAll();
	}
	
	@PostMapping("/{teamId}/link")
	public boolean createRatingLink(@RequestBody TeamInstance instance, @PathVariable("teamId") long teamId ) {
		
		Optional<Team> team = repository.findById(teamId);
		
		if(team.isPresent()) {
			Team item = team.get();
			repository.save(item);
			return true;
		}else {
			return false;
		}
	}
}
