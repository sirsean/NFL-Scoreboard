package com.vikinghammer.nfl.scoreboard.model.pbp;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "same", "__cmde__", "__processing_ms__" })
public class PlayByPlay {
	
	@JsonProperty("gameId")
	private String gameId;
	
	@JsonProperty("quarter")
	private int quarter;
	
	@JsonProperty("locale")
	private String locale;
	
	@JsonProperty("1")
	private List<Play> firstQuarter;
	
	@JsonProperty("2")
	private List<Play> secondQuarter;
	
	@JsonProperty("3")
	private List<Play> thirdQuarter;
	
	@JsonProperty("4")
	private List<Play> fourthQuarter;
	
	public String getGameId() {
		return gameId;
	}
	
	public int getQuarter() {
		return quarter;
	}
	
	public String getLocale() {
		return locale;
	}
	
	public List<Play> getFirstQuarter() {
		return firstQuarter;
	}
	
	public List<Play> getSecondQuarter() {
		return secondQuarter;
	}
	
	public List<Play> getThirdQuarter() {
		return thirdQuarter;
	}
	
	public List<Play> getFourthQuarter() {
		return fourthQuarter;
	}

}
