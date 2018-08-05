package com.venkat.teamtemp.util;

import com.venkat.teamtemp.dto.ThemeMetaData;
import com.venkat.teamtemp.model.Theme;

public class DTOUtils {

	public static ThemeMetaData convertToThemeDTO(Theme theme) {
		
		
		ThemeMetaData dto = new ThemeMetaData();
		
		dto.setTeamName(theme.getTeam().getName());
		dto.setTeamId(theme.getTeam().getId());
		dto.setThemeName(theme.getName());
		dto.setThemeDescription(theme.getDescription());
		
		return dto;
	}
}
