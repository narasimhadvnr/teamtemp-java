package com.venkat.teamtemp.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class APIError implements Serializable{

	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	List<Error> errors;

	public APIError(String error) {
		errors = new ArrayList<Error>();
		errors.add(new Error(error));
	}
	
	public APIError(String error, String description) {
		errors = new ArrayList<Error>();
		errors.add(new Error(error, description));
	}
	
	public APIError() {
		
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	
	class Error implements Serializable{
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		String error;
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		String description;
		
		public Error(String error) {
			this.error = error;
		}
		
		public Error (String error,String description) {
			this.error = error;
			this.description = description;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}


	
	
	
}
