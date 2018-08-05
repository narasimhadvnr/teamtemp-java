package com.venkat.teamtemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.dto.RatingMetaData;
import com.venkat.teamtemp.model.Theme;
import com.venkat.teamtemp.model.ThemeRating;
import com.venkat.teamtemp.repository.RatingRepository;
import com.venkat.teamtemp.repository.ThemeRepository;
import com.venkat.teamtemp.util.APIError;
import com.venkat.teamtemp.util.DTOUtils;

@RestController
@RequestMapping("/comments")
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
	public ThemeRating getRatings( @PathVariable("ratingLink") String ratingLink) {
		
		
		Theme theme = themeRepository.findByLink(ratingLink);
		if(theme != null) {
			return repository.findByThemeId(theme.getId());
		}
		
		return null;
	}	
	
	@GetMapping("/{ratingLink}/metadata")
	public ResponseEntity<Object> getRatingsMetadata( @PathVariable("ratingLink") String ratingLink) {
		
		
		Theme theme = themeRepository.findByLink(ratingLink);
		if(theme != null) {
			ThemeRating rating = repository.findByThemeId(theme.getId());
			
			if(rating != null) {
				
				RatingMetaData dto = DTOUtils.convertToDTO(rating);
				return new ResponseEntity(dto, HttpStatus.OK);
			}
			else {
				return new ResponseEntity(new APIError("No metadata found for this link"), HttpStatus.OK);

			}
			
		}
		
		return new ResponseEntity(new APIError("No Link found with this linkname"), HttpStatus.OK);
	}	
	
}
