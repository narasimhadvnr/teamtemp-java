package com.venkat.teamtemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venkat.teamtemp.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

	
}
