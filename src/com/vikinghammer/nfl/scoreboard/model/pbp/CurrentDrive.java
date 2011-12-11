package com.vikinghammer.nfl.scoreboard.model.pbp;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "same", "__cmde__", "__processing_ms__" })
public class CurrentDrive {

	@JsonProperty("gameId")
	private String gameId;
	
	@JsonProperty("content")
	private List<Play> plays;
	
	public String getGameId() {
		return gameId;
	}
	
	public List<Play> getPlays() {
		return plays;
	}
}
