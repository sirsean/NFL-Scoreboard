package com.vikinghammer.nfl.scoreboard.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class WeekSchedule {
	
	private int season;
	private String type;
	
	private ScheduleInfo week;
	
	@SerializedName("content")
	private List<Game> games;
	
	public WeekSchedule() {
		games = new ArrayList<Game>();
	}
	
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public ScheduleInfo getWeek() {
		return week;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public class ScheduleInfo {
		private WeekInfo current;
		private WeekInfo next;
		private WeekInfo previous;
		
		public WeekInfo getCurrent() {
			return current;
		}
		public WeekInfo getNext() {
			return next;
		}
		public WeekInfo getPrevious() {
			return previous;
		}
	}

}
