package com.vikinghammer.nfl.scoreboard.model.stat;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TeamStatRank {
	@JsonProperty("labels")
	private List<String> labels;
	
	@JsonProperty("players")
	private List<Player> players;
	
	public List<String> getLabels() {
		return labels;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
}
