package com.venkat.teamtemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.model.ThemeRating;
import com.venkat.teamtemp.model.Theme;
import com.venkat.teamtemp.repository.RatingRepository;
import com.venkat.teamtemp.repository.ThemeRepository;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	
	@Autowired
	private ThemeRepository themeRepository;
	
	
	@Autowired
	private RatingRepository repository;
	
	boolean linkFound = false;

	@PostMapping("/{ratingLink}")
	public boolean saveRating(@RequestBody ThemeRating rating, @PathVariable("ratingLink") String ratingLink) {
		
		List<Theme> instances = themeRepository.findAll();
		linkFound = false;
		System.out.println("instances found:"+instances.size());
		instances.iterator().forEachRemaining(instance -> {
			System.out.println(instance.getLink());
			if(instance.getLink().equals(ratingLink)) {
				rating.setTheme(instance);
				repository.save(rating);
				linkFound = true;
			}
		});
		
		if(linkFound)
			return true;
		
		return false;
		
	}
	
	@GetMapping("/{ratingLink}")
	public List<ThemeRating> getRatings( @PathVariable("ratingLink") String ratingLink) {
		
		
		Theme theme = themeRepository.findByLink(ratingLink);
		if(theme != null) {
			return repository.findByThemeId(theme.getId());
		}
		
		return null;
	}
	
}
