package com.vikinghammer.nfl.scoreboard.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "same", "__cmde__", "__processing_ms__" })
public class GameWrapper {
	
	@JsonProperty("gameId")
	private String gameId;
	
	@JsonProperty("content")
	private Game game;
	
	public String getGameId() {
		return gameId;
	}
	
	public Game getGame() {
		return game;
	}

}
