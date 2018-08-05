package com.venkat.teamtemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.User;
import com.venkat.teamtemp.repository.UserRepository;
import com.venkat.teamtemp.util.APIError;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	
	@PostMapping
	public boolean addUser(@RequestBody User user) {
		
		repository.save(user);
		return true;
	}

	@GetMapping
	public Iterable<User> getUsers() {
		return repository.findAll();
	}	

	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String name){
		return repository.findByName(name);
	}
	
	
	@GetMapping("/{userName}/roles")
	public ResponseEntity<Object> getRoleUsers (@PathVariable("userName") String userName){
	
		User result = repository.findByName(userName);
	
		if(result != null) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		
		return new ResponseEntity(new APIError("No users found with that name"), HttpStatus.OK);
	}

}
