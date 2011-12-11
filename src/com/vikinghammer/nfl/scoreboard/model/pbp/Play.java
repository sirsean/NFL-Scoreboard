package com.vikinghammer.nfl.scoreboard.model.pbp;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.vikinghammer.nfl.scoreboard.model.TeamInfo;

@JsonIgnoreProperties({ "startPossessionTeam", "endPossessionTeam", "media" })
public class Play {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("playType")
	private String playType;
	
	@JsonProperty("clockTime")
	private String clockTime;
	
	@JsonProperty("descriptionShort")
	private String descriptionShort;
	
	@JsonProperty("down")
	private int down;
	
	@JsonProperty("isScoringPlay")
	private boolean scoringPlay;
	
	@JsonProperty("scoringType")
	private String scoringType;
	
	@JsonProperty("isRun")
	private boolean run;
	
	@JsonProperty("isPass")
	private boolean pass;
	
	@JsonProperty("netYards")
	private int netYards;
	
	@JsonProperty("onOpponentSide")
	private boolean onOpponentSide;
	
	@JsonProperty("quarter")
	private int quarter;
	
	@JsonProperty("yardLine")
	private String yardLine;
	
	@JsonProperty("yardLineBefore")
	private int yardLineBefore;
	
	@JsonProperty("yardsFromGoal")
	private int yardsFromGoal;
	
	@JsonProperty("yardsToGo")
	private int yardsToGo;
	
	@JsonProperty("yardTeamAfter")
	private TeamInfo yardTeamAfter;
	
	@JsonProperty("yardTeamBefore")
	private TeamInfo yardTeamBefore;

	public String getId() {
		return id;
	}

	public String getPlayType() {
		return playType;
	}

	public String getClockTime() {
		return clockTime;
	}

	public String getDescriptionShort() {
		return descriptionShort;
	}

	public int getDown() {
		return down;
	}

	public boolean isScoringPlay() {
		return scoringPlay;
	}
	
	public String getScoringType() {
		return scoringType;
	}

	public boolean isRun() {
		return run;
	}

	public boolean isPass() {
		return pass;
	}

	public int getNetYards() {
		return netYards;
	}

	public boolean isOnOpponentSide() {
		return onOpponentSide;
	}

	public int getQuarter() {
		return quarter;
	}

	public String getYardLine() {
		return yardLine;
	}

	public int getYardLineBefore() {
		return yardLineBefore;
	}

	public int getYardsFromGoal() {
		return yardsFromGoal;
	}

	public int getYardsToGo() {
		return yardsToGo;
	}

	public TeamInfo getYardTeamAfter() {
		return yardTeamAfter;
	}

	public TeamInfo getYardTeamBefore() {
		return yardTeamBefore;
	}
	
}
