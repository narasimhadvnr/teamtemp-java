package com.venkat.teamtemp.config;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venkat.teamtemp.util.APIError;

@ControllerAdvice 
@RequestMapping(value="/error",produces = "application/vnd.error+json") 
public class AppControllerAdvice {
	

    @ExceptionHandler()
    public ResponseEntity<Object> databaseError(final Exception exception){
    	
    	return new ResponseEntity<Object>(new APIError("Error occurred"),HttpStatus.BAD_REQUEST);
    	
    }
    
    
}