package com.venkat.teamtemp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.venkat.teamtemp.model.InstanceRating;

public interface RatingRepository extends JpaRepository<InstanceRating, Long>, CustomRatingRepository{


}
