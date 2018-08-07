package com.venkat.teamtemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.teamtemp.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

	Team findByName(String name);
}
