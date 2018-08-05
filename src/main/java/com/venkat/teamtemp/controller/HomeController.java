package com.venkat.teamtemp.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.dto.ThemeMetaData;
import com.venkat.teamtemp.model.Team;
import com.venkat.teamtemp.model.Theme;
import com.venkat.teamtemp.repository.TeamRepository;
import com.venkat.teamtemp.repository.ThemeRepository;
import com.venkat.teamtemp.util.APIError;
import com.venkat.teamtemp.util.AppConstants;
import com.venkat.teamtemp.util.RandomString;

@RestController
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private ThemeRepository repository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@PostMapping
	public ResponseEntity<Object> createTeamAndThemeUrl(@RequestBody ThemeMetaData metadata){
		
		RandomString string=new RandomString();
		
		
		Team team = null;
		
		if(metadata.getTeamId() != 0) {
			
			Optional<Team> result =  teamRepository.findById(metadata.getTeamId());
			
			if(result.isPresent()) {
				team= result.get();
			}		
		}
			
		
		if(team == null) {
			team = teamRepository.findByName(metadata.getTeamName());
		}
		
		if(team == null)
		{
			team = new Team();
			team.setName(metadata.getTeamName());
			teamRepository.save(team);
		}else {
			
			Theme theme = repository.findByTeamIdAndName(team.getId(), metadata.getThemeName());
			
			if(theme!= null) {
				return new ResponseEntity<Object> (new APIError("TeamId and theme already exists with link:"+ theme.getLink()), HttpStatus.OK);
			}
		}
		
		Theme theme=new Theme();
		theme.setDescription(metadata.getThemeDescription());
		theme.setName(metadata.getThemeName());
		theme.setTeam(team);			
		theme.setStatus("active");
		theme.setLink(string.nextString());
		theme.setValidFrom(new Date().getTime());
		theme.setValidTill(theme.getValidFrom() + AppConstants.TWO_WEEKS);
		
		repository.save(theme);
		
		return new ResponseEntity<Object>(theme,HttpStatus.OK);
		
	}
}
