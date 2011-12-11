package com.vikinghammer.nfl.scoreboard.parse;

import java.io.Reader;

import org.codehaus.jackson.map.ObjectMapper;

import com.vikinghammer.nfl.scoreboard.model.pbp.CurrentDrive;

public class CurrentDriveParser {
	
	public CurrentDrive parse(Reader reader) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(reader, CurrentDrive.class);
	}

}
