package com.vikinghammer.nfl.scoreboard.model;

import java.util.List;

public class AllWeeks {
	
	private WeekInfo current;
	
	private List<WeekInfo> content;
	
	public WeekInfo getCurrent() {
		return current;
	}
	
	public List<WeekInfo> getWeeks() {
		return content;
	}

}
