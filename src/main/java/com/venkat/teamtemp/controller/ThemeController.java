package com.venkat.teamtemp.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.Team;
import com.venkat.teamtemp.model.Theme;
import com.venkat.teamtemp.repository.ThemeRepository;
import com.venkat.teamtemp.repository.TeamRepository;
import com.venkat.teamtemp.util.AppConstants;
import com.venkat.teamtemp.util.RandomString;

@RestController
@RequestMapping("/teams/{teamId}/themes")
public class ThemeController {
	
	RandomString string;
	
	
	@Autowired
	private ThemeRepository repository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	public ThemeController() {
		// TODO Auto-generated constructor stub
		string = new RandomString(10);

	}
	
	@GetMapping
	public Iterable<Theme> getLinkRatings() {
		return repository.findAll();
	}

	@PostMapping
	public String createRatingLink(@RequestBody Theme instance, @PathVariable("teamId") long teamId ) {
		
		Optional<Team> team = teamRepository.findById(teamId);
		
		if(team.isPresent()) {
			
			// TODO find any team instance is still valid and create if not exists
			
			instance.setTeam(team.get());			
			instance.setStatus("active");
			instance.setLink(string.nextString());
			instance.setValidFrom(new Date().getTime());
			instance.setValidTill(instance.getValidFrom() + AppConstants.TWO_WEEKS);
			repository.save(instance);
			
			return instance.getLink();
		}else {
			return "invalid ID";
		}
	}
	

	
	
	@GetMapping("/{themeId}")
	public Theme getAllTeamInstances( @PathVariable("themeId") long id ){
		Optional<Theme>  teamInstance = repository.findById(id);
		if(teamInstance.isPresent()){
			return teamInstance.get();
		}
		return null;
	}

//	@GetMapping("/link/{linkName}")
//	public TeamInstance getRatingData( @PathVariable("teamId") long teamId, @PathVariable("linkName") String linkId ) {
//		
//		Optional<Team> team = teamRepository.findById(teamId);
//		
//		if(team.isPresent()) {
//			Team item = team.get();
//			
//			for(int i=0; i< item.getLinks().size(); i++){
//
//				RatingLink ratingLink = item.getLinks().get(i).getLinkValue();
//
//				if(ratingLink != null && ratingLink.getLink() == linkId)
//					return item.getLinks().get(i);
//			}
//			
//		}
//
//		return null;
//		
//	}
}
