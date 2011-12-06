package com.vikinghammer.nfl.scoreboard.parse;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import com.vikinghammer.nfl.scoreboard.model.AllWeeks;

public class AllWeeksParser {
	
	public AllWeeks parse(Reader reader) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		AllWeeks allWeeks = mapper.readValue(reader, AllWeeks.class);
		
		return allWeeks;
	}

}
