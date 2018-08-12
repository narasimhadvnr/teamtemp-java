package com.venkat.teamtemp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.venkat.teamtemp.model.ArchiveThemeRating;

public interface ArchiveRepository extends PagingAndSortingRepository<ArchiveThemeRating, Long>{
	
	List<ArchiveThemeRating> findByThemeId(long id);
	
	@Query( "select f from ThemeRating f where theme_id = :id" )
	Page<ArchiveThemeRating> findByThemeAndPaging(long id, Pageable pageable);
	
	
	ArchiveThemeRating findByBrowserIdAndThemeId(String browserId, long themeId);

}
