package com.venkat.teamtemp.config;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venkat.teamtemp.util.APIError;

@RequestMapping(produces = "application/vnd.error+json")
@Profile("!dev")
public class AppControllerAdvice {
	

    @ExceptionHandler()
    public ResponseEntity<Object> databaseError(final Exception exception){
    	
    	return new ResponseEntity<Object>(new APIError("Error occurred"),HttpStatus.BAD_REQUEST);
    	
    }
    
    
}