package com.vikinghammer.nfl.scoreboard.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "nbPreSeasonGames", "nbOffSeasonGames", "same", "__cmde__", "__processing_ms__" })
public class AllWeeks {
	
	@JsonProperty("current")
	private WeekInfo current;
	
	@JsonProperty("content")
	private List<WeekInfo> content;
	
	public WeekInfo getCurrent() {
		return current;
	}
	
	public List<WeekInfo> getWeeks() {
		return content;
	}

}
