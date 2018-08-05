package com.venkat.teamtemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.teamtemp.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
	
}
