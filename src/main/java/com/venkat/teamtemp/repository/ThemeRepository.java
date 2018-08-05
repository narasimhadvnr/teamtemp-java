package com.venkat.teamtemp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.teamtemp.model.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long>{
	
	Theme findByName(String name);

	Theme findByLink(String name);
	
	Theme findByTeamIdAndName(long id, String name);

}
