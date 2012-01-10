package com.vikinghammer.nfl.scoreboard.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({ "seasonType", "weekNumber" })
public class WeekInfo {
	
	@JsonProperty("season")
	private int season;
	
	@JsonProperty("week")
	private int week;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("weekName")
	private String weekName;
	
	
	public String getUrl() {
		if ("reg".equals(type.trim().toLowerCase())) {
			return String.format(
					"http://s3.amazonaws.com/nflgc/week_%s_%s_schedule.js",
					type,
					week
					);
		} else if (("post".equals(type.trim().toLowerCase())) || ("pro".equals(type.trim().toLowerCase()))) {
			return String.format(
					"http://app.prodlb.gotvnetworks.com/nflgc/api/schedule.js?season=%s&type=%s&week=%s",
					season,
					type,
					week
					);
		} else {
			return String.format(
					"http://s3.amazonaws.com/nflgc/week_%s_%s_schedule.js",
					type,
					week
					);
		}
	}
	
	public int getSeason() {
		return season;
	}
	public int getWeek() {
		return week;
	}
	public String getType() {
		return type;
	}
	public String getWeekName() {
		return weekName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + season;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + week;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeekInfo other = (WeekInfo) obj;
		if (season != other.season)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (week != other.week)
			return false;
		return true;
	}

}
