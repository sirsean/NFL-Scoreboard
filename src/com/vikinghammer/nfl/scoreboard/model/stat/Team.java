package com.vikinghammer.nfl.scoreboard.model.stat;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Team {
	@JsonProperty("teamId")
	private String teamId;
	
	@JsonProperty("labels")
	private List<String> labels;
	
	@JsonProperty("stats")
	private List<String> stats;
	
	private List<Stat> cachedStats = null;
	
	@JsonProperty("passing")
	private TeamStatRank passing;
	
	@JsonProperty("rushing")
	private TeamStatRank rushing;
	
	@JsonProperty("receiving")
	private TeamStatRank receiving;
	
	public String getTeamId() {
		return teamId;
	}
	
	public List<Stat> getStats() {
		if (cachedStats == null) {
			cachedStats = new ArrayList<Stat>();
			for (int i=0; i < labels.size(); i++) {
				cachedStats.add(new Stat(labels.get(i), stats.get(i)));
			}
		}
		return cachedStats;
	}
	
	public TeamStatRank getPassing() {
		return passing;
	}
	
	public TeamStatRank getRushing() {
		return rushing;
	}

	public TeamStatRank getReceiving() {
		return receiving;
	}
}
