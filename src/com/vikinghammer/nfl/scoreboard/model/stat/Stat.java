package com.vikinghammer.nfl.scoreboard.model.stat;

public class Stat {
	private String label;
	private String value;
	
	public Stat(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getValue() {
		return value;
	}
}
