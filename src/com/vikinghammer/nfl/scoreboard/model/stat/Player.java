package com.vikinghammer.nfl.scoreboard.model.stat;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Player {
	@JsonProperty("playerId")
	private String playerId;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("stats")
	private List<String> stats;
	
	public String getPlayerId() {
		return playerId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return String.format("%s %s", firstName, lastName).trim();
	}
	
	public List<String> getStats() {
		return stats;
	}
}
