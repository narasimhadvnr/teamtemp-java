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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.Team;
import com.venkat.teamtemp.repository.TeamRepository;

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
	public ResponseEntity<Team> getUser( @PathVariable("teamId") long id){
		
		Optional<Team> team = repository.findById(id);
		
		if(team.isPresent()) {
			return new ResponseEntity(team.get(), HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity(null,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/{teamId}")
	public ResponseEntity<String> editUser(@RequestBody Team teamData, @PathVariable("teamId") long id){
		
		Optional<Team> team = repository.findById(id);
		
		if(team.isPresent()) {
			team.get().setId(id);
			repository.save(team.get());
			return new ResponseEntity("success", HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity("Invalid teamID", HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/{teamId}")
	public ResponseEntity<String> deleteUser(@PathVariable("teamId") long id){
		
		repository.deleteById(id);
		
		
		return new ResponseEntity("success", HttpStatus.ACCEPTED);
	}
	
	
}
