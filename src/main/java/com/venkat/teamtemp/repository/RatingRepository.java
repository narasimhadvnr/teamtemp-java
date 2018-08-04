package com.venkat.teamtemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.teamtemp.model.ThemeRating;

public interface RatingRepository extends JpaRepository<ThemeRating, Long>, CustomRatingRepository{

	List<ThemeRating> findByThemeId(long id);
}
