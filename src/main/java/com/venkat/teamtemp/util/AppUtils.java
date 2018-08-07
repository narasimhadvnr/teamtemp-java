package com.venkat.teamtemp.util;

import java.util.Date;

import com.venkat.teamtemp.dto.ThemeMetaData;
import com.venkat.teamtemp.model.Team;
import com.venkat.teamtemp.model.Theme;

public class AppUtils {
	
	public static Theme generateTheme(Team team, ThemeMetaData metadata,
			String url, int accessCode ) {
		
		Theme theme = new Theme();
		theme.setDescription(metadata.getThemeDescription());
		theme.setName(metadata.getThemeName());
		theme.setTeam(team);			
		theme.setStatus("active");
		theme.setLink(url);
		theme.setAccessCode(accessCode);
		theme.setValidFrom(new Date().getTime());
		theme.setValidTill(0);
		return theme;
		
	}

}
