package com.venkat.teamtemp.util;

import com.venkat.teamtemp.dto.RatingMetaData;
import com.venkat.teamtemp.model.ThemeRating;

public class DTOUtils {

	public static RatingMetaData convertToDTO(ThemeRating rating) {
		
		
		RatingMetaData dto = new RatingMetaData();
		
		dto.setTeamName(rating.getTheme().getTeam().getName());
		dto.setTeamId(rating.getTheme().getTeam().getId());
		dto.setThemeName(rating.getTheme().getName());
		dto.setThemeDescription(rating.getTheme().getDescription());
		
		return dto;
	}
}
