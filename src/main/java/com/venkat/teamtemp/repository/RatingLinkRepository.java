package com.venkat.teamtemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.venkat.teamtemp.model.RatingLink;

public interface RatingLinkRepository extends JpaRepository<RatingLink, Long> {
	
	
	
}
