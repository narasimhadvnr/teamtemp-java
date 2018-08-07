package com.venkat.teamtemp.controller;

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
import com.venkat.teamtemp.util.AppUtils;
import com.venkat.teamtemp.util.RandomKey;

@RestController
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private ThemeRepository repository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@PostMapping
	public ResponseEntity<Object> createTeamAndThemeUrl(@RequestBody ThemeMetaData metadata){
		
		
		if(metadata.getTeamName() == null || metadata.getThemeDescription() == null || metadata.getThemeName() ==null) {
			
			return new ResponseEntity<Object>(new APIError("TeamName & themeName & theme description is mandatory"),
					HttpStatus.BAD_REQUEST);
		}
		
		
		RandomKey key=new RandomKey();
		
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
	
		String url = getUniqueUrl(key);
		
		int accessCode = getUniqueLong(key);
		
		Theme theme = AppUtils.generateTheme(team, metadata, url, accessCode);
		
		repository.save(theme);
		
		return new ResponseEntity<Object>(theme,HttpStatus.OK);
		
	}
	
	
	private int getUniqueLong(RandomKey key) {
		
		int randomAccessCode =-1;
		boolean exit = true;		
		while(exit) {
			randomAccessCode= key.nextRandomInt();
			Theme search= repository.findByAccessCode(randomAccessCode);
			if(search==null)
				exit = false;

		}
		return randomAccessCode;
		
	}
	
	private String getUniqueUrl(RandomKey key) {
		String urlLink = null;
		boolean exit = true;
		while(exit) {
			urlLink = key.nextString();
			Theme search= repository.findByLink(urlLink);
			if(search== null)
				exit = false;

		}
		return urlLink;
	}
}
