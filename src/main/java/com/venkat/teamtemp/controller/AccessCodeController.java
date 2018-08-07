package com.venkat.teamtemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.Theme;
import com.venkat.teamtemp.repository.ThemeRepository;
import com.venkat.teamtemp.util.APIError;

@RestController
@RequestMapping("/accesscode")
public class AccessCodeController {
	
	
	@Autowired
	private ThemeRepository repository;
	
	
	@GetMapping("/{accessCode}")
	public ResponseEntity<Object> getMappedUniqueUrl(@PathVariable("accessCode") int code){
		
		Theme theme = repository.findByAccessCode(code);
		
		if(theme != null) {
			return new ResponseEntity<Object>("{ \"url\": \""+theme.getLink() +"\" }", HttpStatus.OK) ;
		}
		return new ResponseEntity<Object>(new APIError("No url found for this accessCode"), HttpStatus.BAD_REQUEST);
		
	}
	

}
