package com.vikinghammer.nfl.scoreboard.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.vikinghammer.nfl.scoreboard.free.R;

public class NFLUtil {
	
	public static String allWeeksUrl() {
		return "http://s3.amazonaws.com/nflgc/allWeeks.js";
	}

	public static String getGameUrl(String gameId) {
		return String.format(
				"http://s3.amazonaws.com/nflgc/game_%s_game.js",
				gameId
				);
	}
	
	public static String getGameStatsUrl(String gameId) {
		return String.format(
				"http://s3.amazonaws.com/nflgc/game_%s_gameStats.js",
				gameId
				);
	}
	
	public static int timeoutsDrawable(int timeouts) {
		return timeoutsImages[timeouts];
	}

	private static int[] timeoutsImages = new int[] {
		R.drawable.timeouts_0,
		R.drawable.timeouts_1,
		R.drawable.timeouts_2,
		R.drawable.timeouts_3
	};
	
	public static int teamLogoDrawable(String abbreviation) {
		return teamLogos.get(abbreviation);
	}
	
	private static ConcurrentMap<String, Integer> teamLogos;
	static {
		teamLogos = new ConcurrentHashMap<String, Integer>();
		
		// NFC North
		teamLogos.put("GB", R.drawable.icon_team_gb);
		teamLogos.put("CHI", R.drawable.icon_team_chi);
		teamLogos.put("DET", R.drawable.icon_team_det);
		teamLogos.put("MIN", R.drawable.icon_team_min);
		
		// NFC South
		
		teamLogos.put("NO", R.drawable.icon_team_no);
		teamLogos.put("ATL", R.drawable.icon_team_atl);
		teamLogos.put("TB", R.drawable.icon_team_tb);
		teamLogos.put("CAR", R.drawable.icon_team_car);
		
		// NFC East

		teamLogos.put("DAL", R.drawable.icon_team_dal);
		teamLogos.put("NYG", R.drawable.icon_team_nyg);
		teamLogos.put("PHI", R.drawable.icon_team_phi);
		teamLogos.put("WAS", R.drawable.icon_team_was);
		
		// NFC West
		
		teamLogos.put("SF", R.drawable.icon_team_sf);
		teamLogos.put("SEA", R.drawable.icon_team_sea);
		teamLogos.put("ARI", R.drawable.icon_team_ari);
		teamLogos.put("STL", R.drawable.icon_team_stl);
		
		// AFC North
		
		teamLogos.put("BAL", R.drawable.icon_team_bal);
		teamLogos.put("PIT", R.drawable.icon_team_pit);
		teamLogos.put("CIN", R.drawable.icon_team_cin);
		teamLogos.put("CLE", R.drawable.icon_team_cle);
		
		// AFC East
		
		teamLogos.put("NE", R.drawable.icon_team_ne);
		teamLogos.put("NYJ", R.drawable.icon_team_nyj);
		teamLogos.put("BUF", R.drawable.icon_team_buf);
		teamLogos.put("MIA", R.drawable.icon_team_mia);
		
		// AFC West
		
		teamLogos.put("OAK", R.drawable.icon_team_oak);
		teamLogos.put("DEN", R.drawable.icon_team_den);
		teamLogos.put("SD", R.drawable.icon_team_sd);
		teamLogos.put("KC", R.drawable.icon_team_kc);
		
		// AFC South
		
		teamLogos.put("IND", R.drawable.icon_team_ind);
		teamLogos.put("JAC", R.drawable.icon_team_jac);
		teamLogos.put("HOU", R.drawable.icon_team_hou);
		teamLogos.put("TEN", R.drawable.icon_team_ten);
		
	}

}
