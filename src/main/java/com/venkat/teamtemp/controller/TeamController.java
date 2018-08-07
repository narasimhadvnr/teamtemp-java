package com.venkat.teamtemp.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.Team;
import com.venkat.teamtemp.repository.TeamRepository;
import com.venkat.teamtemp.util.APIError;

@RestController
@RequestMapping("/teams")
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
	
	@GetMapping("/{teamId}")
	public ResponseEntity<Object> getUser( @PathVariable("teamId") long id){
		
		Optional<Team> team = repository.findById(id);
		
		if(team.isPresent()) {
			return new ResponseEntity<Object>(team.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(new APIError("No Team found with the id"),HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/{teamId}")
	public ResponseEntity<Object> editUser(@RequestBody Team teamData, @PathVariable("teamId") long id){
		
		Optional<Team> team = repository.findById(id);
		
		if(team.isPresent()) {
			team.get().setId(id);
			repository.save(team.get());
			return new ResponseEntity<Object>("success", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(new APIError("Invalid teamID"), HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/{teamId}")
	public ResponseEntity<String> deleteUser(@PathVariable("teamId") long id){
		
		repository.deleteById(id);
		
		
		return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
	}
	
	
}
