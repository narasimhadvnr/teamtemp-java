package com.venkat.teamtemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.teamtemp.dto.ThemeMetaData;
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
	
	
	@GetMapping
	public ResponseEntity<Object> getAllData(){
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteComment(@PathVariable("id")  long id) {
		
		repository.deleteById(id);
		
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	@GetMapping("/{ratingLink}")
	public ResponseEntity<Object> getRatings( @PathVariable("ratingLink") String ratingLink,
			
			@RequestParam("page") int page,
			@RequestParam("size") int pageSize) {
		
		
		Theme theme = themeRepository.findByLink(ratingLink);
		if(theme != null) {
			
			Page<ThemeRating> result= repository.findByThemeAndPaging(theme.getId(),
					new PageRequest(page, pageSize));
			
			return new ResponseEntity<Object>(result,HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(new APIError("NO data found"),HttpStatus.NO_CONTENT);
	}	
	
	@GetMapping("/{ratingLink}/metadata")
	public ResponseEntity<Object> getRatingsMetadata( @PathVariable("ratingLink") String ratingLink) {
		
		
		Theme theme = themeRepository.findByLink(ratingLink);
		if(theme != null) {			
				
				ThemeMetaData dto = DTOUtils.convertToThemeDTO(theme);
				return new ResponseEntity<Object>(dto, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Object>(new APIError("No Link found with this linkname"), HttpStatus.OK);
	}
	
	@GetMapping("/{ratingLink}/all")
	public ResponseEntity<Object> getRatings( @PathVariable("ratingLink") String ratingLink) {
		
		
		Theme theme = themeRepository.findByLink(ratingLink);
		if(theme != null) {			
				

				return new ResponseEntity<Object>(theme.getRatings(), HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Object>(new APIError("No Link found with this linkname"), HttpStatus.OK);
	}
	
}
