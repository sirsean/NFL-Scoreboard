package com.vikinghammer.nfl.scoreboard.model;

public class WeekInfo {
	
	private int season;
	private int week;
	private String type;
	private String weekName;
	
	public String getUrl() {
		return String.format(
				"http://s3.amazonaws.com/nflgc/week_%s_%s_schedule.js",
				type,
				week
				);
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
