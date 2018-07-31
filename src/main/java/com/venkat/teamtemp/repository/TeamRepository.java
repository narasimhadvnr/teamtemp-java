package com.venkat.teamtemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venkat.teamtemp.domain.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{

	
}
