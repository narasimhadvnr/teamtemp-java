package com.venkat.teamtemp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.venkat.teamtemp.model.ThemeRating;

public interface RatingRepository extends PagingAndSortingRepository<ThemeRating, Long>, CustomRatingRepository{

	List<ThemeRating> findByThemeId(long id);
	
	@Query( "select f from ThemeRating f where theme_id = :id" )
	Page<ThemeRating> findByThemeAndPaging(long id, Pageable pageable);
	
//	ThemeRating findByThemeId(long id);
}
