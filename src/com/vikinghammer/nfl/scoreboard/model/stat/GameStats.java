package com.vikinghammer.nfl.scoreboard.model.stat;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;


@JsonIgnoreProperties({ "same", "__cmde__", "__processing_ms__" })
public class GameStats {
	
	@JsonProperty("gameId")
	private String gameId;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("home")
	private Team home;
	
	@JsonProperty("away")
	private Team away;
	
	public String getGameId() {
		return gameId;
	}
	
	public String getState() {
		return state;
	}
	
	public Team getHome() {
		return home;
	}
	
	public Team getAway() {
		return away;
	}
	
}
