package com.vikinghammer.nfl.scoreboard.model;

import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TeamInfo {
	
	@SerializedName("id")
	private String teamId;
	
	private String name;
	
	@SerializedName("nickName")
	private String nickname;
	
	private String abbreviation;
	private String city;
	private String conference;
	private String division;
	private String imageUrl;
	private String draftNeeds;
	
	public String getTeamId() {
		return teamId;
	}
	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public String getCity() {
		return city;
	}
	public String getConference() {
		return conference;
	}
	public String getDivision() {
		return division;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public List<String> getDraftNeeds() {
		return Arrays.asList(draftNeeds.split(","));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
		TeamInfo other = (TeamInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
